package com.project01.client;

import java.io.*;
import java.net.*;

//서버로 메시지를 전송하는 클래스
public class B02Receiver extends Thread {
	Socket socket;
	BufferedReader in = null;

	// Socket을 매개변수로 받는 생성자
	public B02Receiver(Socket socket) {
		this.socket = socket;

		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));

		} catch (Exception e) {
			System.out.println("예외[Receiver] : " + e);
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
				System.out.println("예외 [ReceiverRun] : " + e);
				break;
			}
		}

		try {
			in.close();
		} catch (Exception e) {
			System.out.println("예외[ReceiverClose] : " + e);
		}
	}

}
