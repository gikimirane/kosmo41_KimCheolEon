package com.study.jsp.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Basic;

public class A01CommandProcess {

	private static A01CommandProcess instance = new A01CommandProcess();

	public static A01CommandProcess getInstance() {
		return instance;
	}

	static Set<Session> wsSession = WsServer02.getSession();
	static Map<String, Session> wsClientMap = WsServer02.getClientMap();

	B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();
	C02roomlistDAO roomDAO = C02roomlistDAO.getInstance();

	// 커맨드 처리 부분 (switch ~ case로 분류 및 메소드 호출)
	public String CommandProcess(String command, String inName, String body) {
		String result = "";

		System.out.println("command : [" + command + "]");
		System.out.println("name : [" + inName + "]");
		System.out.println("body : [" + body + "]");

		try {
			switch (command) {

			case "/list":

				break;

			case "/to":

				break;

			case "/roomlist":

				break;

			case "/mkroom":

				break;

			case "/dstroom":

				break;

			case "/in":
				CmdRoomIn(inName, body);
				result = "입장하였습니다.";
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
				result = "[SYSTEM] 올바르지 않은 명령입니다.....";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void CmdRoomIn(String name, String body) {
		ArrayList<B01chat_usersDTO> USER = chuDAO.checkUSERS("NAME", name);

		// 명령어 날린사람 계급 확보 ADMIN / NOADMIN
		String isAdmin = USER.get(0).getROOMADMIN();
		// 명령어 날린사람의 LOCATION 확보
		String isLocation = USER.get(0).getLOCATION();

		int PassCheck = 0;
		// body 분리 및 토큰개수 확보
		StringTokenizer inToken = new StringTokenizer(body, " ");
		int tokenCount = inToken.countTokens();

		String tokenBody = "";
		String tokenPass = "";

		// 토큰의 갯수에 따른 토큰데이터 확보
		if (tokenCount == 1) {
			tokenBody = inToken.nextToken();
		}

		if (tokenCount == 2) {
			tokenBody = inToken.nextToken();
			tokenPass = inToken.nextToken();
		}

		// 방이 존재하는가?
		// 방이 존재하지 않으면 NULLpoint error, CommandProcess 에서 에러처리
		C01roomlistDTO selectRoom = roomDAO.selectRoomList("RNUMBER", tokenBody);

		// 대상된 방의 정보 확보
		String doRnumber = selectRoom.getRNUMBER();
		int doMax = Integer.parseInt(selectRoom.getRMAX());
		int doUserCount = Integer.parseInt(selectRoom.getRUSERCOUNT());
		String doHidden = selectRoom.getRHIDDEN();
		String doPass = selectRoom.getRPASS();
		
		if (isAdmin.equals("ADMIN")) {
			
		}
	}

}
