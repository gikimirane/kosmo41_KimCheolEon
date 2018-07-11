//콘솔 멀티채팅 클라이언트 프로그램...?

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClient {

	public static void main(String[] args) {
		
		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
		
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			//String ServerIP = "localhost";
			Socket socket = new Socket(args[0], 8080);
			System.out.println("서버와 연결이 되었습니다.........");
			
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			
			out.println(s_name);
			
			System.out.println("Receive : " + in.readLine());
			
			in.close();
			out.close();
			
			socket.close();
			
		} catch (Exception e) {
			System.out.println("예외 [MultiClient] : " + e);
		}

	}

}
