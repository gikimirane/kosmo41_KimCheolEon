import java.io.*;
import java.net.*;
import java.util.*;

public class MuiltiClient5 {

	public static void main(String[] args) {

		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		try {
			String ServerIP = "localhost";
			Socket socket = new Socket(ServerIP, 9999);
			// Socket socket = new Socket(args[0], Port);
			System.out.println("서버와 연결이 되었습니다.........");

			// 서버에서 보내는 메시지를 사용자 콘솔에 출력하는 "쓰레드"
			Thread receiver = new Receiver5(socket);
			receiver.start();

			// 사용자로부터 얻은 문자열 서버로 전송하는 스레드
			Thread sender = new Sender5(socket, s_name);
			sender.start();

		} catch (Exception e) {
			System.out.println("예외 [MultiClient class] : " + e);
		}

	}

}
