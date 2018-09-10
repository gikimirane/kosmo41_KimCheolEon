import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketendpoint2")
public class WsServer02 {

	// set<Session> 기존에는 hashMap, key / value 였다면, 지금은 session 하나만 넣어놓음
	// 여러개가 필요하다면 그냥 맵으로 넣어버려서 처리해야 함.
	// 이게 싫다면 데이터베이스를 연결해서 써야함
	// 핵심적으로 수정해야 할 부분
	private static final java.util.Set<Session> sessions = 
			java.util.Collections.synchronizedSet(new java.util.HashSet<Session>());
	
	
//	private static final java.util.Map<String, Session> clientMap = 
//			java.util.Collections.synchronizedMap(new java.util.HashMap<String, Session>());
	
	///////////////////////////////////////////////////////////////////////////////////////////

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
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("Message from " + session.getId() + ": " + message);

		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		sendAllSessionToMessage(session, message);
	}

	private void sendAllSessionToMessage(Session self, String message) {
		try {
			for (Session session : WsServer02.sessions) {
				if (!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText("All : " + message);
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
