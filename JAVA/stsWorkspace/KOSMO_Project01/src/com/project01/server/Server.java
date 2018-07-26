package com.project01.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;

	// 생성자
	public Server() {
		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		// 해쉬맵 동기화 설정
		Collections.synchronizedMap(clientMap);
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new MultiServerT(socket); // 쓰레드 생성.
				msr.start();
			}
		} catch (Exception e) {
			System.out.println("예외[Server/init] : " + e);
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e2) {
				System.out.println("예외[Server/initCose] : " + e2);
			}
		}
	}

	// 접속된 모든 클라이언트들에게 메시지 전달
	public void sendAllMsg(String msg) {
		// 출력 스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());

				it_out.println(URLEncoder.encode(msg, "UTF-8"));
			} catch (Exception e) {
				System.out.println("예외[Server/sendAllMsg] : " + e);
			}
		}
	}

	public void CommandProcess(String command, String name, String body) {
		try {
			
			System.out.println(command);
			System.out.println(name);
			System.out.println(body);

			switch (command) {

			case "/list":
				CmdList(name);
				break;

			case "/to":
				CmdWhisper(body);
				break;

			default:
				CmdDefault(name);

			}
		} catch (Exception e) {
			System.out.println("예외[Server/CommandProcess] : " + e);
		}

	}

	public void CmdList(String name) {
		String sResult = "";

		try {
			// Key만 담고있는 컬렉션 인스턴스 생성
			Set<String> keys = clientMap.keySet();

			// 전체 Key 출력
			for (String n : keys) {
				if (sResult == "") {
					sResult = n;
				} else {
					sResult = sResult + ", " + n;
				}
			}
			
			PrintWriter it_out = (PrintWriter) clientMap.get(name);
			it_out.println(URLEncoder.encode(sResult.toString(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdWhisper(String msg) {

		StringTokenizer to = new StringTokenizer(msg, " ");
		to.nextToken();
		to.nextToken();
		to.nextToken();
		String toName = to.nextToken();
		String toBody = to.nextToken("").trim();

		// System.out.println("[" + toName + "]");
		// System.out.println("[" + toBody + "]");

		try {
			PrintWriter it_out = (PrintWriter) clientMap.get(toName);

			it_out.println(URLEncoder.encode("From [" + toName + "] : " + toBody, "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdWhisper] : " + e);
		}
	}

	public void CmdDefault(String name) {

		try {
			PrintWriter it_out = (PrintWriter) clientMap.get(name);

			it_out.println(URLEncoder.encode("알수없는 명령어 입니다.", "UTF-8"));
		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {		
		Server ms = new Server();
		ms.init();
	}

//	////////////////////////////////////////////////////////////
//	// 내부클래스
//	// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드
//
//	class MultiServerT extends Thread {
//		Socket socket;
//		PrintWriter out = null;
//		BufferedReader in = null;
//
//		// 생성자
//		public MultiServerT(Socket socket) {
//			this.socket = socket;
//			try {
//				// 서버에서 Out은 Client 것
//				out = new PrintWriter(this.socket.getOutputStream(), true);
//				// Read는 서버꺼
//				in = new BufferedReader(
//						new InputStreamReader(
//								this.socket.getInputStream(), "UTF-8"));
//				
//			} catch (Exception e) {
//				System.out.println("예외 : " + e);
//			}
//		}
//
//		// 쓰레드를 사용하기 위해서 run() 메서드 재정의
//		@Override
//		public void run() {
//			String name = "";
//
//			try {
//				name = in.readLine();
//				name = URLDecoder.decode(name, "UTF-8");
//
//				sendAllMsg(name + " 님이 입장하셨습니다.");
//				// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
//				clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
//				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
//
//				// 입력스트림이 null이 아니면 반복.
//				String s = "";
//
//				while (in != null) {
//					// s = in.readLine();
//					s = in.readLine();
//					s = URLDecoder.decode(s, "UTF-8");
//					
//					System.out.println(s);
//
//					// int check = s.indexOf(":");
//					if (s.equals("q") || s.equals("Q")) {
//						break;
//					}
//
//					// ------------------------------------------------------------
//					StringTokenizer test = new StringTokenizer(s, " ");
//					System.out.println(test.nextToken());
//					System.out.println(test.nextToken());
//					String tokenCommand = test.nextToken();
//					System.out.println(tokenCommand);
//
//					if (tokenCommand.substring(0, 1).equals("/")) {
//						CommandProcess(tokenCommand, name, s);
//					} else {
//						sendAllMsg(s);
//					}
//					// ------------------------------------------------------------
//				}
//
//			} catch (
//
//			Exception e) {
//				System.out.println("예외[Server/수신부] : " + e);
//			} finally {
//				// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
//				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
//				clientMap.remove(name);
//				sendAllMsg(name + "님이 퇴장하셨습니다.");
//				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
//
//				try {
//					in.close();
//					out.close();
//
//					socket.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}

}
