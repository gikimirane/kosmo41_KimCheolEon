package com.project01.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class MultiServerT extends Thread {
	Socket socket;
	PrintWriter out = null;
	BufferedReader in = null;
	
	Server svr = new Server();

	// 생성자
	public MultiServerT(Socket socket) {
		this.socket = socket;
		try {
			// 서버에서 Out은 Client 것
			out = new PrintWriter(this.socket.getOutputStream(), true);
			// Read는 서버꺼
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (Exception e) {
			System.out.println("예외 : " + e);
		}
	}

	// 쓰레드를 사용하기 위해서 run() 메서드 재정의
	@Override
	public void run() {
		String name = "";

		boolean Whisper = false;

		try {
			name = in.readLine();

			svr.sendAllMsg(name + "님이 입장하셨습니다.");
			// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
			svr.clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
			System.out.println("현재 접속자 수는 " + svr.clientMap.size() + "명 입니다.");

			// 입력스트림이 null이 아니면 반복.
			String s = "";
			while (in != null) {
				s = in.readLine();

				System.out.println(s);

				// int check = s.indexOf(":");
				if (s.equals("q") || s.equals("Q")) {
					break;
				}
				// s 를 파싱 해서 명령어가 있는지 판단
				// 명령어 있으면 명령어 분리
				// if 명령어 then
				// { CommandProcess}
				// else { sendAllMsg}

				// 정규식 - .* .* 하나이상의 문자를 포함하는 문자열
				if (s.matches(".*:/.*") == true) {
					svr.CommandProcess(s);
				} else {
					svr.sendAllMsg(s);
				}

			}

		} catch (Exception e) {
			System.out.println("예외[Server/수신부] : " + e);
		} finally {
			// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
			// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
			svr.clientMap.remove(name);
			svr.sendAllMsg(name + "님이 퇴장하셨습니다.");
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
