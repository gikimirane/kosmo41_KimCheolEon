import java.io.*;
import java.net.*;
import java.util.*;

//쬐끔 바꿔놔서, args[0] / args[1] 따로 받아서 넘김
// args[0] - ip
// args[1] - port

public class MuiltiClient4 {

	public static void main(String[] args) {

		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;
		// BufferedReader in = null;

		int Port = Integer.parseInt(args[1]);

		try {
			// 소켓 객체 생성
			Socket socket = new Socket(args[0], Port);
			System.out.println("서버와 연결이 되었습니다.........");

			/////////////////////////////////////////
			// 서버에서 보내는 메시지를 사용자 콘솔에 출력하는 "쓰레드"
			Thread receiver = new Receiver4(socket);
			receiver.start();
			/////////////////////////////////////////

			out = new PrintWriter(socket.getOutputStream(), true);

			out.println(s_name);

			while (out != null) {
				try {
					String s2 = s.nextLine();

					if (s2.equals("q") || s2.equals("Q")) {
						out.print(s2);
						break;
					} else {
						out.println(s_name + " => " + s2);
					}

				} catch (Exception e) {
					System.out.println("예외[MultiClient3 출력] : " + e);
				}
			}

			out.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("예외 [MultiClient class] : " + e);
		}

	}

}
