import java.io.*;
import java.net.*;

//서버로 메시지를 전송하는 클래스
public class Receiver4 extends Thread {

	Socket socket;
	BufferedReader in = null;

	// Socket을 매개변수로 받는 생성자
	public Receiver4(Socket socket) {
		this.socket = socket;

		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (Exception e) {
			System.out.println("예외1[Receiver3 Class] : " + e);
		}
	}

	// run() 메소드 재정의 - 오버라이드
	@Override
	public void run() {
		while (in != null) {
			try {
				
				//여기를 탈 수가 없다. 이거 받는게 아니기 때문에
/*				String s2 = s.nextLine();

				if (s2.equals("q") || s2.equals("Q")) {
					out.print(s2);
					break;
				} else {
					out.println(s_name + " => " + s2);
				}
				*/
				
				System.out.println("Thread Receive : " + in.readLine());

			} catch (java.net.SocketException ne) {
				break;
			}
			catch (Exception e) {
				System.out.println("예외2[Receiver3 run()] : " + e);
			}
			// 여기에 놓으면 에러가 난다. 아마도 상위 Exception 이 다 걸러가기 때문인것같다.
			// catch (java.net.SocketException ne) {
			// break;
			// }
		}

		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3[run() close] : " + e);
		}
	}
}
