package com.project01.server;

import java.io.*;
import java.net.*;
import java.util.*;

/*Physical Port
Logical Port - File Handler

서버 - 피지컬 리슨;
클라이언트 - 커넥트
서버 - 억셉트 - 스레드로 로지컬포트랑 정보 날림
서로 다른 파일핸들러(혹은 로지컬포트를 본다)

q1. 프로그램당 포트는 하나사용, 한컴퓨터에서 서버,클라이언트? : 파일핸들러로 다른걸 보니까
q2. 서버측에서 겟포트하면 뜨는 포트번호는 왜 9999가 아니라 다른게 나오는가? : 위와 같다

궁금증 해결 완
*/

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
				// 이거 안씀

				it_out.println(msg);
			} catch (Exception e) {
				System.out.println("예외[Server/sendAllMsg] : " + e);
			}
		}
	}

	public void CommandProcess(String message) {
		try {
			System.out.println("CommandProcess : " + message);
			message = message.trim();
			String cmd = null;
			int check = message.indexOf(":");
			int check2 = message.indexOf(" ");

			String clientId;
			clientId = message.substring(0, check);

			System.out.println("check \':\' : " + check);
			System.out.println("check2 \' \' : " + check2);

			if (check2 != -1) {
				// case : to
				cmd = message.substring(check + 2, check2);
				message = message.substring(check2).trim();
			} else {
				// case : list
				cmd = message.substring(check + 2);
				message = "";
			}

			switch (cmd.toLowerCase()) {

			case "list":
				CmdList(clientId);
				break;

			case "to":
				CmdWhisper(clientId, message);
				break;

			default:
				CmdDefault(clientId);

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
			it_out.println(sResult);

		} catch (Exception e) {
			System.out.println("예외[Server/CmdList] : " + e);
		}
	}

	public void CmdWhisper(String name, String msg) {
		int check2 = msg.indexOf(" ");

		// if(check2 != -1) {
		String sRecv = msg.substring(0, check2);
		String SMessage = msg.substring(check2).trim();

		// System.out.println("발신자: " + name);
		// System.out.println("수신자 :[" + sRecv + "]");
		// System.out.println("메시지: " + SMessage);

		try {
			PrintWriter it_out = (PrintWriter) clientMap.get(sRecv);

			it_out.println("From [" + name + "] : " + SMessage);
		} catch (Exception e) {
			System.out.println("예외[Server/CmdWhisper] : " + e);
		}
		// }else {

		// }

	}

	public void CmdDefault(String name) {

		try {
			PrintWriter it_out = (PrintWriter) clientMap.get(name);

			it_out.println("알수없는 명령어 입니다.");
		} catch (Exception e) {
			System.out.println("예외[Server/CmdDefault] : " + e);
		}

	}

	public static void main(String[] args) {
		Server ms = new Server();
		ms.init();
	}
}
