package com.study.jsp.websocket;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.server.ServerEndpoint;

import sun.security.jca.GetInstance;

@ServerEndpoint("/websocketendpoint2")
public class WsServer02 {

	// set<Session> 기존에는 hashMap, key / value 였다면, 지금은 session 하나만 넣어놓음
	// 여러개가 필요하다면 그냥 맵으로 넣어버려서 처리해야 함.
	// 이게 싫다면 데이터베이스를 연결해서 써야함
	// 핵심적으로 수정해야 할 부분
	private static final java.util.Set<Session> sessions = java.util.Collections
			.synchronizedSet(new java.util.HashSet<Session>());

	private static final java.util.Map<String, Session> clientMap = java.util.Collections
			.synchronizedMap(new java.util.HashMap<String, Session>());

	///////////////////////////////////////////////////////////////////////////////////////////
	boolean nameInterrupt = true;
	String inUser = null;

	B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();
	A01CommandProcess process = A01CommandProcess.getInstance();

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id : " + session.getId());

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("접속 성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		sessions.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		sessions.remove(session);
		clientMap.remove(inUser);
		chuDAO.deleteCHAT_USERS(inUser);
	}

	@OnMessage
	public void onMessage(String message, Session session) {

		String toName = "";

		//최초 접속시, 접속한 사람 이름 획득
		if (nameInterrupt) {
			nameInterrupt = false;

			message = message.trim();

			inUser = message.replace(" 님이 입장하였습니다.", "");
			System.out.println("접속자 : [" + inUser + "]");

			// 이름 추출해서 맵에 넣음
			clientMap.put(inUser, session);

			// DB INSERT table, CHAT_USERS
			chuDAO.insertCHAT_USERS(inUser);
		}

		System.out.println("[session-" + session.getId() + "] " + message);

		// 유저 셀렉트박스 선택했을 때, 사용자 아이디 추출
		if (!(message.indexOf("t@o@") == -1)) {
			int encrypt = message.indexOf("t@o@") + 4;
			int length = message.length();

			toName = message.substring(encrypt, length);

			System.out.println("toName :[" + toName + "]");

			message = message.replace("t@o@" + toName, "");
		}

		// http://localhost:8081/KOSMO_Project02/WA02Client.jsp
		// 링크 강제로 타는데 null 이름 갖고 대화방 난입하길래 강제로 끊어버림
		if (inUser.equals("null")) {
			return;
		}

		// ***********************************************************************************************
		// 전문 구성
		// (아이디 : )부분 삭제, 메세지만 뽑음
		String exMessage = message.replace(inUser + " : ", "").trim();

		String command = "";
		String tokenBody = "";
		// 토크나이징 시작,
		if (!exMessage.equals("")) {
			StringTokenizer test = new StringTokenizer(exMessage, " ");

			// /명령어 추출
			command = test.nextToken();

			// 띄어쓰고 명령어 다음 메시지
			tokenBody = "";
			if (test.hasMoreTokens()) {
				tokenBody = test.nextToken("").trim();
			}
			
			if (exMessage.substring(0, 1).equals("/")) {
				System.out.println("command : " + command);
				System.out.println("tokenBody : " + tokenBody);
//				resultText = process.CommandProcess(command, inUser, tokenBody);
			}
		}

		try {
			final Basic basic = session.getBasicRemote();
			// 내가 보낸 메세지, 즉 이 부분이 센드
			basic.sendText(message);
			////////////////////////////////
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// 이 부분이 사람들한테 메시지 보내기 (반복문으로 자기 세션 빼고)
		if (toName.equals("")) {
			sendAllSessionToMessage(session, message);
		} else {
			sendSignlSessionToMessage(clientMap.get(toName), inUser, exMessage);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	private void sendAllSessionToMessage(Session self, String message) {
		try {
			for (Session session : WsServer02.sessions) {
				// 반복문 돌려서 자신 빼고 나머지 세션한테 던지네
				if (!self.getId().equals(session.getId())) {
					// 남에게 보내는 메시지
					session.getBasicRemote().sendText("[전체] " + message);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendSignlSessionToMessage(Session who, String user, String message) {

		try {
			who.getBasicRemote().sendText("[귓속말] " + user + " : " + message);
		} catch (Exception e) {
			// 대상이 존재하지않습니다
			try {
				clientMap.get(inUser).getBasicRemote().sendText("[Server] " + "대상이 존재하지 않음");
			} catch (IOException e1) {
			}
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

}
