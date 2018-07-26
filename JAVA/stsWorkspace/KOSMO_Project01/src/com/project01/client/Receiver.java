package com.project01.client;

import java.io.*;
import java.net.*;

//서버로 메시지를 전송하는 클래스
public class Receiver extends Thread {
	Socket socket;
	BufferedReader in = null;

	// Socket을 매개변수로 받는 생성자
	public Receiver(Socket socket) {
		this.socket = socket;

		try {
<<<<<<< HEAD
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "EUC-KR"));
=======
			in = new BufferedReader(
					new InputStreamReader(
							this.socket.getInputStream(), "UTF-8"));
>>>>>>> a9fcf728c4ce50ead3871b4777fb16648fc3eafa

		} catch (Exception e) {
			System.out.println("예외 : " + e);
		}
	}

	// run() 메서드 재정의
	@Override
	public void run() {
		while (in != null) {
			try {
				System.out.println("[Thread Receive] " + URLDecoder.decode(in.readLine(), "UTF-8"));
			} catch (java.net.SocketException ne) {
				break;
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}
		}
		
		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외3 : " + e);
		}
	}

}
