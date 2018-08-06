package com.project01.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	static ServerSocket serverSocket = null;
	static Socket socket = null;
	static Map<String, PrintWriter> clientMap;

	public static void main(String[] args) {

		// 클라이언트의 출력스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		// 해쉬맵 동기화 설정
		Collections.synchronizedMap(clientMap);

		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new A01MultiThreadRun(socket); // 쓰레드 생성.
				msr.start();
			}
		} catch (Exception e) {
			System.out.println("예외[Server/init] : " + e);
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e2) {
				System.out.println("예외[Server/initCose] : " + e2);
			}
		}
	}
}
