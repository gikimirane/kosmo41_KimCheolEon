import java.io.*;
import java.net.*;

public class MulitiServer4 {

	ServerSocket serverSocket = null;
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	String s = "";

	// 생성자
	public MulitiServer4() {

	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress() + " : " + socket.getPort());

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			//////////////////////////////////
			while (in != null) {
				s = in.readLine();

				if (s == null) {
					break;
				}
				if (s.equals("q") || s.equals("Q")) {
					break;
				}
				System.out.println(">> " + s);
//				out.println(">> " + s);
				sendAllMsg(s);
			}
			//////////////////////////////////

			System.out.println("Bye...");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외1 : " + e);
			// e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();

				socket.close();
				serverSocket.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("예외2 : " + e2);
				e2.printStackTrace();
			}
		}
	}

	// 접속된 모든 클라이언트들에게 메세지 전달
	public void sendAllMsg(String msg) {
		try {
			out.println(msg);
		} catch (Exception e) {
			System.out.println("예외[Allmsg] : " + e);
		}
	}

	public static void main(String[] args) {
		//서버 객체 생성
		MulitiServer4 ms = new MulitiServer4();
		ms.init();
	}

}
