import java.io.*;
import java.net.*;
import java.util.*;

public class MulitiServer6 {

	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;

	// 생성자
	public MulitiServer6() {
		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();

		// 해쉬맵 동기화 설정
		Collections.synchronizedMap(clientMap);
	}

	public void init() {
		try {
			// 서버소켓 - 9999 포트
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + " : " + socket.getPort());

				// 서버 스레드 생성
				Thread msr = new MultiSrverT(socket);
				//msr.run();
				msr.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 접속된 모든 클라이언트들에게 메세지 전달
	public void sendAllMsg(String msg) {
		// 출력스트림을 순차적으로 얻어와서 해당 메시지 출력
		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				it_out.println(msg);
			} catch (Exception e) {
				System.out.println("예외[Allmsg] : " + e);
			}
		}
	}

	public static void main(String[] args) {
		// 서버 객체 생성
		MulitiServer6 ms = new MulitiServer6();
		ms.init();
	}

	//////////////////////////////////////////////////////////////
	// 내부 클래스
	// 클라이언트로서 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서-드

	class MultiSrverT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;

		// 생성자
		public MultiSrverT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}
		}

		// 서버 스레드 생성용 run() 메서드 재정의
		@Override
		public void run() {

			// String s = "";
			String name = "";

			try {
				name = in.readLine();

				sendAllMsg("[ " + name + "] 님이 입장하셨습니다.");
				// 현재 소켓 외 다른 접속 알림
				clientMap.put(name, out);
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");

				String s = "";
				while (in != null) {
					s = in.readLine();
					System.out.println(s);
					if (s.equals("q") || s.equals("Q")) {
						break;
					}
					sendAllMsg(s);
				}

				// System.out.println("Bye.....");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				clientMap.remove(name);
				sendAllMsg("[ " + name + "] 님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");

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
}
