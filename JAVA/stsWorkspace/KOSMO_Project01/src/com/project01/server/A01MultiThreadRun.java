package com.project01.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.StringTokenizer;

import com.project01.DB.B01chat_usersDO;
import com.project01.DB.B02chat_usersDAO;

class A01MultiThreadRun extends Thread {

	private static final String BLOCK = null;
	Server svr = new Server();
	A02ServerFunction func = new A02ServerFunction();

	Socket socket;
	PrintWriter out = null;
	BufferedReader in = null;

	// ------------------------------------------------------------
	B02chat_usersDAO chuDAO = new B02chat_usersDAO();
	// ------------------------------------------------------------

	public void ConnectionDennied() {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 생성자
	public A01MultiThreadRun(Socket socket) {
		this.socket = socket;
		try {
			// 서버에서 Out은 Client 것
			out = new PrintWriter(this.socket.getOutputStream(), true);
			// Read는 서버꺼
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외 : " + e);
		}
	}

	// 쓰레드를 사용하기 위해서 run() 메서드 재정의
	@Override
	public void run() {
		String name = "";

		try {
			name = in.readLine();
			name = URLDecoder.decode(name, "UTF-8");

			// ----------------------------------------------------------
			// DAO 에서 NAME SQL excute 시도 (실패시 없는 계정)
			System.out.println("[SYSTEM] 회원 테이블 확인중....");
			B01chat_usersDO checkUSERS = chuDAO.checkUSERS(name);
			// 접속중인 계정인가? 테이블 확인
			// Q1. 서버가 먼저 껐을때, IN 남은상태로 접속시 어떻게 되는가?
			// A1. 최초 접속시 접속이 거부당한다. 접속시도시 날린 네임이 UPDATE 되어서 2번째 시도엔 접속된다.
			// 사실상 서버가 먼저 꺼지면 관리문제 또한 있으므로, 그 책임은 관리자에게 미루자
			// A2. 게임에서 강제종료됬을때 원래 그러잖아? 헐 그러네;
			// Q2. 접속중일때, 다른 계정이 접속시도시 어떻게 되는가?
			// A2. 차단당함. 그런데, 접속중이던 원래계정까지 튕겨나가는데 채팅은 보내지는 기묘한 사태가... 물론 받진 못함..
			// A3. 강제 블록시켜버릴까도 고민중임
			if (checkUSERS.getLOGIN().equals("IN")) {
				System.out.println("[접속거부] 중복 접속");
				ConnectionDennied();
				in.close();
				out.close();
				socket.close();
			} else {
				
				System.out.println("[SYSTEM] 중복되지 않은 접속");
			}

			// 차단된 계정인가? 테이블확인
			if (checkUSERS.getBLOCK().equals("BLOCK")) {
				System.out.println("[접속거부] 차단된 회원");
				ConnectionDennied();
			} else {
				System.out.println("[SYSTEM] 차단되지 않은 회원");
			}

			// ----------------------------------------------------------

			func.sendAllMsg("[" + name + "] 님이 입장하셨습니다.");
			// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
			svr.clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

			// ############################################################
			// UPDATE IN
			boolean logIN_chuUSERS = chuDAO.updateCHAT_USERS("NAME", name, "LOGIN", "IN");

			if (logIN_chuUSERS) {
				System.out.println("[SYSTEM] 회원정보 LogIN UPDATE TRUE.");
			} else {
				System.out.println("[SYSTEM] 회원정보 LogIN UPDATE FALSE");
			}

			// ############################################################

			// 입력스트림이 null이 아니면 반복.
			String s = "";

			while (in != null) {
				s = in.readLine();
				s = URLDecoder.decode(s, "UTF-8");

				if (s.equals("q") || s.equals("Q")) {
					break;
				}

				// **********************************************************************
				// 제대로 토큰될라면, 아이디에 공백이 없어야함
				System.out.println("전송된 메시지 : " + s);
				StringTokenizer test = new StringTokenizer(s, " ");

				// 토큰1 - 보낸사람 NAME
				String sendName = test.nextToken();
				System.out.println("토큰1 : " + sendName);

				// 토큰2 - : (콜론)
				String unWokrd = test.nextToken();
				System.out.println("토큰2 : " + unWokrd);

				// 토큰3 - 콜론 이후 내용물 시작
				String tokenCommand = test.nextToken();
				System.out.println("토큰3 : " + tokenCommand);

				String tokenBody = "";
				if (test.hasMoreTokens()) {
					tokenBody = test.nextToken("").trim();
					System.out.println("토큰4 : " + tokenBody);
				}

				// 그 토큰3의 첫시작이 "/" 일때 명령어 커맨드로 구분
				if (tokenCommand.substring(0, 1).equals("/")) {
//					func.CommandProcess(tokenCommand, sendName, s);
					func.CommandProcess(tokenCommand, sendName, tokenBody);
				} else {
					func.sendAllMsg(s);
				}
				// **********************************************************************
			}
		} catch (Exception e) {
			System.out.println("예외[Server/수신부] : " + e);
		} finally {
			// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
			// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
			svr.clientMap.remove(name);
			func.sendAllMsg("[" + name + "] 님이 퇴장하셨습니다.");
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

			// UPDATE NOTIN
			B02chat_usersDAO chuDAO = new B02chat_usersDAO();
			boolean logOUT_chuUSERS = chuDAO.updateCHAT_USERS("NAME", name, "LOGIN", "NOTIN");
			if (logOUT_chuUSERS) {
				System.out.println("[SYSTEM] 회원정보 logOUT UPDATE TRUE.");
			} else {
				System.out.println("[SYSTEM] 회원정보 logOUT UPDATE FALSE");
			}

			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}