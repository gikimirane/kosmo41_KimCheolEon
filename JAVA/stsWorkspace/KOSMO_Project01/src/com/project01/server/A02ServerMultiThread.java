package com.project01.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.project01.DB.*;

class A02ServerMultiThread extends Thread {

	private static final String BLOCK = null;
	Server svr = new Server();
	A03ServerFunction func = new A03ServerFunction();

	Socket socket;
	PrintWriter out = null;
	BufferedReader in = null;

	B02usersDAO uDAO = new B02usersDAO();

	C01chat_usersDO chuDO = new C01chat_usersDO();
	C02chat_usersDAO chuDAO = new C02chat_usersDAO();

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
	public A02ServerMultiThread(Socket socket) {
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
			// 중복접속확인 >> 테이블확인 >> 차단확인

			// B02usersDAO uDAO = new B02usersDAO();
			B01usersDO checkUSERS = uDAO.checkUSERS(name);

			if (svr.clientMap.get(name) != null) {
				System.out.println("[접속거부] 중복 접속");
				ConnectionDennied();
			} else {
				System.out.println("[A] 중복되지 않은 이름");
				if (!name.equals(checkUSERS.getNAME())) {
					System.out.println("[접속거부] 회원 테이블에 존재하지 않음.");
					ConnectionDennied();
				} else {
					System.out.println("[B] 회원 테이블 확인");
					if (checkUSERS.getBLOCK().equals("Y")) {
						System.out.println("[접속거부] 차단된 회원");
						ConnectionDennied();
					} else {
						System.out.println("[C] 차단되지 않은 회원");
					}
				}
			}

			// ----------------------------------------------------------

			func.sendAllMsg("[" + name + "] 님이 입장하셨습니다.");
			// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
			svr.clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

			// ############################################################
			// 접속명단으로 INSERT (CHAT_USERS)

			// C02chat_usersDAO chuDAO = new C02chat_usersDAO();
			// C01chat_usersDO chuDO = new C01chat_usersDO();

			chuDO.setNAME(name);

			boolean insert = chuDAO.insertCHAT_users(chuDO);

			if (insert) {
				System.out.println("[SYSTEM] 회원정보가 대기실로 이동되었습니다.");
			} else {
				System.out.println("[SYSTEM] 회원정보 INSERT FALSE");
			}

			// ############################################################

			// 입력스트림이 null이 아니면 반복.
			String s = "";

			while (in != null) {
				// s = in.readLine();
				s = in.readLine();
				s = URLDecoder.decode(s, "UTF-8");

				System.out.println(s);

				// int check = s.indexOf(":");
				if (s.equals("q") || s.equals("Q")) {
					break;
				}

				// **********************************************************************
				StringTokenizer test = new StringTokenizer(s, " ");
				System.out.println(test.nextToken());
				System.out.println(test.nextToken());
				String tokenCommand = test.nextToken();
				System.out.println(tokenCommand);

				if (tokenCommand.substring(0, 1).equals("/")) {
					func.CommandProcess(tokenCommand, name, s);
				} else {
					func.sendAllMsg(s);
				}
				// **********************************************************************
			}

		} catch (

		Exception e) {
			System.out.println("예외[Server/수신부] : " + e);
		} finally {
			// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
			// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
			svr.clientMap.remove(name);
			func.sendAllMsg("[" + name + "] 님이 퇴장하셨습니다.");
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

			chuDO.setNAME(name);
			boolean delete = chuDAO.deleteCHAT_users(chuDO);
			if (delete) {
				System.out.println("정상 삭제");
			} else {
				System.out.println("비정상 삭제 : 테이블을 확인해주세요");
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