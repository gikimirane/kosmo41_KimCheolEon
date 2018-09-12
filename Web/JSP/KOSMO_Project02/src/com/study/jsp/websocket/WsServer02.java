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

	private static final java.util.Map<Session, String> clientMap = java.util.Collections
			.synchronizedMap(new java.util.HashMap<Session, String>());

	///////////////////////////////////////////////////////////////////////////////////////////
	boolean nameInterrupt = true;
	String inUser = null;
	
	B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Open session id : " + session.getId());

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("Connection Established");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		sessions.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		sessions.remove(session);
		chuDAO.deleteCHAT_USERS(inUser);
	}

	@OnMessage
	public void onMessage(String message, Session session) {

		if (nameInterrupt) {
			nameInterrupt = false;

			inUser = message.replace(" 님이 입장하였습니다.", "");
			System.out.println("추출된 이름 : [" + inUser + "]");

			// http://localhost:8081/KOSMO_Project02/WA02Client.jsp
			// 링크 강제로 타는데 null 이름 갖고 대화방 난입하길래 강제로 끊어버림

			clientMap.put(session, inUser);
			System.out.println("clientMap.get(session) : " + clientMap.get(session));
			
			chuDAO.insertCHAT_USERS(inUser);
		}
		
		System.out.println("[session-" + session.getId() + "] " + message);

		if (inUser.equals("null")) {
			return;
		}
		
		
		// 메시지로 장난칠 지점/////////////////////////////////////////
		// 기존거 쓸라면 메시지랑 아이디랑 분리시켜야함
		String messageBody = message.replace(inUser+" : ", "").trim();
		
		System.out.println("분리메시지[" + messageBody + "]");
		
//		// 제대로 토큰될라면, 아이디에 공백이 없어야함
//		StringTokenizer test = new StringTokenizer(message, " ");
//
//		String sendName = test.nextToken();
//
//		// 토큰2 - : (콜론)
//		String unWokrd = test.nextToken();
//
//		// 토큰3 - 콜론 이후 내용물 시작
//		String tokenCommand = test.nextToken();
//
//		String tokenBody = "";
//		if (test.hasMoreTokens()) {
//			tokenBody = test.nextToken("").trim();
//		}

		// 그 토큰3의 첫시작이 "/" 일때 명령어 커맨드로 구분
		if (messageBody.substring(0, 1).equals("/")) {
//			func.CommandProcess(tokenCommand, sendName, tokenBody);
			System.out.println("명령어 시작!");
		} else {
//			func.sendPrivateMsg(s, name);
			try {
				final Basic basic = session.getBasicRemote();
				// 내가 보낸 메세지, 즉 이 부분이 에코
				basic.sendText(message);
				////////////////////////////////
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			// 이 부분이 사람들한테 메시지 보내기 (반복문으로 자기 세션 빼고)
			sendAllSessionToMessage(session, message);
		}
		
		
		
		
		
		
		
		
		
		
		

	}

	private void sendAllSessionToMessage(Session self, String message) {
		try {
			for (Session session : WsServer02.sessions) {
				// 반복문 돌려서 자신 빼고 나머지 세션한테 던지네
				if (!self.getId().equals(session.getId())) {
					// 남에게 보내는 메시지
					session.getBasicRemote().sendText(message);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

}
