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
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
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
				System.out.println("예외 : " + e);
			}
		}
	}

	public static void main(String[] args) {
		Server ms = new Server();
		ms.init();
	}

	////////////////////////////////////////////////////////////
	// 내부클래스
	// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드

	class MultiServerT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;

		// 생성자
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
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

				sendAllMsg(name + "님이 입장하셨습니다.");
				// 현재 객체가 가지고 있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
				clientMap.put(name, out); // 해쉬맵에 키를 name으로 출력스트림 객체를 저장.
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");

				// 입력스트림이 null이 아니면 반복.
				String s = "";
				while (in != null) {
					s = in.readLine();

					System.out.println(s);

					if (s.equals("q") || s.equals("Q")) {
						break;
					}
					sendAllMsg(s);
				}

			} catch (Exception e) {
				System.out.println("예외 : " + e);
			} finally {
				// 예외가 발생할 때 퇴장. 해쉬맵에서 해당 데이터 제거
				// 보통 종료하거나 나가면 java.net.SocketException: 예외발생
				clientMap.remove(name);
				sendAllMsg(name + "님이 퇴장하셨습니다.");
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
