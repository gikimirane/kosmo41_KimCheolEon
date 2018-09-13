package com.study.jsp.websocket;

import java.util.Map;
import java.util.StringTokenizer;

import javax.websocket.Session;

import com.sun.security.ntlm.Client;

public class A01CommandProcess {

	private static A01CommandProcess instance = new A01CommandProcess();

	public static A01CommandProcess getInstance() {
		return instance;
	}

	// 커맨드 처리 부분 (switch ~ case로 분류 및 메소드 호출)
	public String CommandProcess(String command, String name, String body) {

		String result = "";

		System.out.println("command : [" + command + "]");
		System.out.println("name : [" + name + "]");
		System.out.println("body : [" + body + "]");

		try {
			switch (command) {

			case "/list":

				break;

			case "/to":
				result = CmdWhisper(body);
				break;

			case "/roomlist":

				break;

			case "/mkroom":

				break;

			case "/dstroom":

				break;

			case "/in":

				break;

			case "/exit":

				break;

			case "/kick":

				break;

			case "/adminto":

				break;

			case "/myroomlist":

				break;

			case "/info":

				break;

			case "/all":

				break;

			case "/toh":

				break;

			default:
				result = "지원하지 않는 명령어....";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String CmdWhisper(String body) {
		StringTokenizer to = new StringTokenizer(body, " ");
		String wantName = to.nextToken();
		
		return wantName;
	}
	

}
