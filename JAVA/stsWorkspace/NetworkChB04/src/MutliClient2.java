import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MutliClient2 {

	public static void main(String[] args) {

		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		PrintWriter out = null;
		BufferedReader in = null;

		//
		int Port = Integer.parseInt(args[1]);
		
		try {
			// 수정
//			String ServerIP = "localhost";
//			Socket socket = new Socket(ServerIP, 9999);
			//
			Socket socket = new Socket(args[0], Port);
			//
			System.out.println("서버와 연결이 되었습니다.........");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println(s_name);

			/////////////////////////////////////////////
			while (out != null) {
				try {
					// 입력단
					if (in != null) {
						System.out.println("Receive : " + in.readLine());
					}

					// 출력
					String s2 = s.nextLine();
					if (s2.equals("q") || s2.equals("Q")) {
						out.print(s2);
						break;
					} else {
						out.println(s_name + " => " + s2);
					}

				} catch (IOException e) {
					// TODO: handle exception
					System.out.println("예외 : " + e);
				}
			}
			/////////////////////////////////////////////

//			System.out.println("Receive : " + in.readLine());

			in.close();
			out.close();

			socket.close();

		} catch (Exception e) {
			System.out.println("예외 [MultiClient] : " + e);
		}

	}

}
