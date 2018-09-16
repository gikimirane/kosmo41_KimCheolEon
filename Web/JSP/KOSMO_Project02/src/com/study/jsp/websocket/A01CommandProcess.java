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
				result = CmdRoomIn(inName, body);
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

	public String CmdRoomIn(String name, String body) {
		
		System.out.println("name : " + name);
		System.out.println("body : " + body);
		
		ArrayList<B01chat_usersDTO> USER = chuDAO.checkUSERS("NAME", name);

		// 명령어 날린사람 계급 확보 ADMIN / NOADMIN
		String isAdmin = USER.get(0).getROOMADMIN();
		// 명령어 날린사람의 LOCATION 확보
		String isLocation = USER.get(0).getLOCATION();
		
		System.out.println("isAdmin ? : " + isAdmin);
		System.out.println("isLocation ? : " + isLocation);

//		int PassCheck = 0;
//		// body 분리 및 토큰개수 확보
		StringTokenizer inToken = new StringTokenizer(body, " ");
		int tokenCount = inToken.countTokens();
//
		String tokenBody = "";
		String tokenPass = "";
//
//		// 토큰의 갯수에 따른 토큰데이터 확보
		if (tokenCount == 1) {
			tokenBody = inToken.nextToken();
		}
//
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
		
		
		System.out.println("doRnumber : " + doRnumber);
		System.out.println("doMax : " + doMax);
		System.out.println("doUserCount : " + doUserCount);
		System.out.println("doHidden : " + doHidden);
		System.out.println("doPass : " + doPass);
		
		
		if (isAdmin.equals("ADMIN")) {
			return "방장은 특별한 조치후에 다른방에 입장할 수 있습니다.";
		}
		
//		if (!isNumeric(tokenBody)) {
//			return "";
//		}
		
		if (doMax == doUserCount) {
			return "방에 인원이 꽉찼습니다.";
		}
		
		System.out.println("IN 처리 시작");
		
		if (doHidden.equals("공개")) {
			chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", body);
			
			C01roomlistDTO selectCreateRoom = roomDAO.selectRoomList("RNUMBER", body);
			int AddCount = Integer.parseInt(selectCreateRoom.getRUSERCOUNT()) + 1;
			
			roomDAO.updateRoom(Integer.toString(AddCount), selectCreateRoom.getRNUMBER());
		}
		
		if (doHidden.equals("비공개")) {
			if (tokenPass.equals(doPass)) {
				chuDAO.updateCHAT_USERS("NAME", name, "LOCATION", tokenBody);

				C01roomlistDTO selectCreateRoom = roomDAO.selectRoomList("RNUMBER", tokenBody);
				int AddCount = Integer.parseInt(selectCreateRoom.getRUSERCOUNT()) + 1;
				
				roomDAO.updateRoom(Integer.toString(AddCount), selectCreateRoom.getRNUMBER());
			}else {
				return "비밀번호가 틀렸습니다.";
			}
		}
		
		return "방이 이동되었습니다. (번호 : " + tokenBody + ")";
	}

	public boolean isNumeric(String s) {
		try {
			// Double.parseDouble(s);
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
