import java.io.*;
import java.net.*;

public class MulitiServer5 {

	ServerSocket serverSocket = null;
	Socket socket = null;

	// 생성자
	public MulitiServer5() {

	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + " : " + socket.getPort());
				
				//서버 스레드 생성
				Thread msr = new MultiSrverT(socket); 
				msr.run();				
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외1 : " + e);
			// e.printStackTrace();
		} finally {
			try {
				serverSocket.close();

			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("예외2 : " + e2);
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 서버 객체 생성
		MulitiServer5 ms = new MulitiServer5();
		ms.init();
	}

	//////////////////////////////////////////////////////////////
	// 내부 클래스
	// 클라이언트로서 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서-드

	class MultiSrverT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		//생성자
		public MultiSrverT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
						this.socket.getInputStream()));
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}	
		}
		
		//서버 스레드 생성용 run() 메서드 재정의
		@Override
		public void run() {

			String s = "";
			
			try {
				while (in != null) {
					s = in.readLine();

					if (s == null) {
						break;
					}
					if (s.equals("q") || s.equals("Q")) {
						break;
					}
					System.out.println(">> " + s);
					sendAllMsg(s, out);
				}
				
				System.out.println("Bye.....");				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					in.close();
					out.close();
					
					socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		// 접속된 모든 클라이언트들에게 메세지 전달
		public void sendAllMsg(String msg, PrintWriter out) {
			try {
				out.println(msg);
			} catch (Exception e) {
				System.out.println("예외[Allmsg] : " + e);
			}
		}
	}
}
