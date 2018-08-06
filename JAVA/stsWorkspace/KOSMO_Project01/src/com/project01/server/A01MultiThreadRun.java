package com.project01.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.project01.DB.B01chat_usersDO;
import com.project01.DB.B02chat_usersDAO;

class A01MultiThreadRun extends Thread {

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

			ArrayList<B01chat_usersDO> checkUSERS = chuDAO.checkUSERS("NAME", name);
			String getuLoc = checkUSERS.get(0).getLOCATION();

			if (checkUSERS.get(0).getLOGIN().equals("IN")) {
				System.out.println("[접속거부] 중복 접속");
				ConnectionDennied();
				in.close();
				out.close();
				socket.close();
			} else {

				System.out.println("[SYSTEM] 중복되지 않은 접속");
			}

			// 차단된 계정인가? 테이블확인
			if (checkUSERS.get(0).getBLOCK().equals("BLOCK")) {
				System.out.println("[접속거부] 차단된 회원");
				ConnectionDennied();
			} else {
				System.out.println("[SYSTEM] 차단되지 않은 회원");
			}

			// ----------------------------------------------------------

			func.sendAllMsg("[" + name + "] 님이 입장하셨습니다.");
			// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
			Server.clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
			System.out.println("현재 접속자 수는 " + Server.clientMap.size() + "명 입니다.");

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
				
				System.out.println("전송된 메시지 : " + s);
				// 제대로 토큰될라면, 아이디에 공백이 없어야함
				StringTokenizer test = new StringTokenizer(s, " ");

				String sendName = test.nextToken();

				// 토큰2 - : (콜론)
				String unWokrd = test.nextToken();

				// 토큰3 - 콜론 이후 내용물 시작
				String tokenCommand = test.nextToken();

				String tokenBody = "";
				if (test.hasMoreTokens()) {
					tokenBody = test.nextToken("").trim();
				}

				// 그 토큰3의 첫시작이 "/" 일때 명령어 커맨드로 구분
				if (tokenCommand.substring(0, 1).equals("/")) {
					func.CommandProcess(tokenCommand, sendName, tokenBody);
				} else {
					func.sendPrivateMsg(s, name);
				}
				// **********************************************************************
			}
		} catch (Exception e) {
			System.out.println("예외[Server/수신부] : " + e);
		} finally {
			// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
			// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
			Server.clientMap.remove(name);
			func.sendAllMsg("[" + name + "] 님이 퇴장하셨습니다.");
			System.out.println("현재 접속자 수는 " + Server.clientMap.size() + "명 입니다.");

			// -----------------------------------------------------------------------------------

			// UPDATE NOTIN
			B02chat_usersDAO chuDAO = new B02chat_usersDAO();
			boolean logOUT_chuUSERS = chuDAO.updateCHAT_USERS("NAME", name, "LOGIN", "NOTIN");
			if (logOUT_chuUSERS) {
				System.out.println("[SYSTEM] 회원정보 logOUT UPDATE TRUE.");
			} else {
				System.out.println("[SYSTEM] 회원정보 logOUT UPDATE FALSE");
			}
			// -----------------------------------------------------------------------------------

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