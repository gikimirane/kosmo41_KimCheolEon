package WebSocketEx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketendpoint2")
public class yybJava {
   String bChatSessionId = null;
   String bChatId = null;
   String bChatRoomNum = null;
   int onOpenCheck = 0; // OnOpen 할 경우 값을 1로 설정
   
   BCDao bcDao = BCDao.getInstance(); // DB에 session id, 대화명 저장
   
   private static final java.util.Set<Session> sessions =
         java.util.Collections.synchronizedSet(new java.util.HashSet<Session>());
   
   @OnOpen
   public int onOpen(Session session) {
      System.out.println("=> Class WsSserver Open session id : " + session.getId());
      try {         
         final Basic basic = session.getBasicRemote();
         basic.sendText("connection Established");
         /*sendAllSessionToMessage(session, session.getId()); 입장 시 servlet 에서 채팅 창에 보내는 메세지*/
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
      sessions.add(session);
      this.onOpenCheck = 1; // Onopen 실행 시 DB 설정을 위해 숫자 변경
      System.out.println("=> Class WsSserver onOpen 'onOpenCheck' value : " + onOpenCheck);
      
      return onOpenCheck;
   }
   
   @OnClose
   public void onClose(Session session) {
      System.out.println("Session " + session.getId() + " has ended");
      /*sendAllSessionToMessage(session, session.getId()); 퇴장 시 servlet 에서 채팅 창에 보내는 메세지*/
      sessions.remove(session);
      bcDao.delete(bChatSessionId); // 퇴장 시 DB에 session id, 대화명 삭제 
   }
   
   @OnMessage
   public void onMessage(String message, Session session) {
      System.out.println("Message from " + session.getId() + " : " + message);
      try {
         final Basic basic = session.getBasicRemote();
         basic.sendText(message);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      String messageMode = message.substring(0, 4);
      if(messageMode.equals("FROM")) { // messageMode 가 FROM 일 때 whisperSessionToMessage 로 message 전달
         System.out.println("==> Class MESSAGE MODE : " +  messageMode);
         whisperSessionToMessage( session, message );
      } else {
         sendAllSessionToMessage( session, message );
      }
      
      System.out.println("==> Class WsServer message : " +  message);

   }
   
   private int sendAllSessionToMessage(Session self, String message) {
      try {
         for ( Session session : WsServer2.sessions) {
            if (! self.getId().equals(session.getId()))
               session.getBasicRemote().sendText("(전체)" + message);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      if(onOpenCheck == 1) { // OnOpen 할 경우 필드값 session id, 대화명 set 설정
         bChatSessionId = self.getId();
         bChatId = message.replace(" 입 장 ", ""); // OnOpen시 전송받은 내용에서 대화명만 남기고 삭제   
         
         System.out.println(">>> Class WsServer 'bChatSessionId' before INSERT : " + bChatSessionId);
         System.out.println(">>> Class WsServer 'bChatId' before INSERT : " + bChatId);   
         bcDao.member(bChatSessionId, bChatId, bChatRoomNum);
      }
      
      this.onOpenCheck = 0; // OnOpen 할 때만 값을 1로 설정해서  DB에 session id, 대화명 저장 
      System.out.println("=> Class WsSserver sendAll 'onOpenCheck' value : " + onOpenCheck);
      return onOpenCheck;
   }
   
   private void whisperSessionToMessage(Session self, String message) {
      try {
         for ( Session session : WsServer2.sessions) {
            if (! self.getId().equals(session.getId()))
               session.getBasicRemote().sendText("(전체)" + message);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   @OnError
   public void onError(Throwable e, Session session) {
   }
}