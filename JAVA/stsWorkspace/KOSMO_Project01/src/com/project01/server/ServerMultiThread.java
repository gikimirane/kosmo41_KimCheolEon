package com.project01.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

////////////////////////////////////////////////////////////
// 내부클래스
// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드

class ServerMultiThread extends Thread {

	Server svr = new Server();
	ServerFunction func = new ServerFunction();

	Socket socket;
	PrintWriter out = null;
	BufferedReader in = null;

	// 생성자
	public ServerMultiThread(Socket socket) {
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

			func.sendAllMsg(name + " 님이 입장하셨습니다.");
			// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
			svr.clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

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

				// ------------------------------------------------------------
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
				// ------------------------------------------------------------
			}

		} catch (

		Exception e) {
			System.out.println("예외[Server/수신부] : " + e);
		} finally {
			// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
			// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
			svr.clientMap.remove(name);
			func.sendAllMsg(name + "님이 퇴장하셨습니다.");
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

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