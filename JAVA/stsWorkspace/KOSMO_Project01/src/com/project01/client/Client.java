package com.project01.client;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {

		System.out.println("이름을 입력해주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();

		try {
<<<<<<< HEAD
			String ServerIP = "ec2-13-124-116-158.ap-northeast-2.compute.amazonaws.com";
//			String ServerIP = "localhost";
=======
//			String ServerIP = "ec2-13-124-116-158.ap-northeast-2.compute.amazonaws.com";
			String ServerIP = "localhost";
>>>>>>> a9fcf728c4ce50ead3871b4777fb16648fc3eafa
			if (args.length > 0) {
				ServerIP = args[0];
			}
			Socket socket = new Socket(ServerIP, 9999);
			System.out.println(socket.getInetAddress() + ":" + socket.getPort());
			System.out.println("서버와 연결이 되었습니다...........");

			// 서버에서 보내는 메시지를 사용자의 콘솔에 출력하는 쓰레드
			Thread receiver = new Receiver(socket);
			receiver.start();
			
			new ChatWin(socket, s_name);

		} catch (Exception e) {
			System.out.println("예외[MultiClient class] : " + e);
		}

	}

}
