<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="WebSocketEx.BCDao"%>
<%@page import="WebSocketEx.BCDto"%>
<%@page import="java.util.ArrayList"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <style>
   * {
         background-color: black;
         font-size: large; font-family: fantasy; 
         color: pink;
      }
      
   /* textarea {background-color:black; border:0; overflow-x:hidden; overflow-y:auto; padding-top:1; padding-right:5; padding-bottom:5; padding-left:5;} */   
   </style>
</head>
<body>
   <%
      BCDao cdao = BCDao.getInstance();
      ArrayList<BCDto> cdtos = cdao.list();
      request.setAttribute("userList", cdtos);   
      
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");   
      
      if (id == null) {
   %>
   <jsp:forward page="list_chat.jsp" />
   <%
      } else {
         /* session.setAttribute("uid", id); */
      }
   %>
   <div>
      사용자 아이디 : <%=id %>
   </div>
   
   <textarea id="messages" cols="60" rows="10" style="overflow-x:hidden; overflow-y:auto;"></textarea>
   <script src="http://code.jquery.com/jquery-1.7.js"></script>
   <script>
      
      /* var a = $(function(){
         $('#messageinput').keypress(function(e) { 
             if(e.which == 13) {
                if(e.which != 16) {
                    $(this).blur(); 
                    $('#send').focus().click();                 
                    $('#messageinput').focus()
                     e.preventDefault();
                    }
               } 
            });   
         });
      

      var w = $(function(){
         $('#whisperinput').keypress(function(e) { 
             if(e.which == 13) {
                if(e.which != 16) {
                    $(this).blur(); 
                    $('#send').focus().click();                 
                    $('#whisperinput').focus()
                     e.preventDefault();
                    }
               } 
            });
         }); */
      
         

      var id = "<%= id %>";
      
      var webSocket;
      var messages = document.getElementById("messages");
      
      function openSocket() {
         if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
            writeResponse("이미 입장 되어 있음");            
            return;
         }
         
         webSocket = new WebSocket("ws://localhost:8081/jsp28_Board/websocketendpoint2");         
         
         webSocket.onopen = function(event) {
            webSocket.send( id + " 입 장 " );
            
            if(event.data === undefined)
               return;                
               writeResponse(event.data);
            };
         
         webSocket.onmessage = function(event) {
            writeResponse(event.data);
         };
         
         webSocket.onclose = function(event) {
            writeResponse("Connection closed");
         };
      }
      
      function send(){
         var text = document.getElementById("messageinput").value;
         webSocket.send(id + " : " + text);
         messageinput.value="";
         
      }
      
      function Wsend(){
         var text = document.getElementById("whisperinput").value;
         webSocket.send( "FROM <"+ uList + id + "> : " + text);
         whisperinput.value="";
         
      }
         
      function closeSocket() {
         webSocket.send(id + " 퇴장 ");
         webSocket.close();
      }
      
      function whisperMode() {
         var whisperinput = document.getElementById("input");
         var   whispertext = '<input type="text" id="whisperinput" size="50" style="height:50px; background-color: #e2e2e2; color: black;" placeholder="귓속말메시지를 입력하세요" onkeypress="if(event.keyCode==13) {Wsend(); return false;}">';
            whisperinput.innerHTML = whispertext;
         
         var send = document.getElementById("send");
         var inputmode = document.getElementById("mode");
         
         var sendChange = '<button type="button" onclick="Wsend();" id="send">/Send To.&nbsp;</button> &nbsp;&nbsp;'
                        + '<select id="uList">'
                           + '<c:forEach items="${ userList }" var="cdto">'
                              + '<th scope="row" style="line-heigh: 10px;"><option value="">${ cdto.bChatId }</option></th>'
                           + '</c:forEach>'
                        + '</select>';
         var modeChange = '<button type="button" onclick="sendAllMode();" id="mode" style="background-color: pink; color: black;">SendAll</button>';
            send.outerHTML = sendChange;
            inputmode.outerHTML = modeChange;
            
      }
      
      function sendAllMode() {
         var whisperinput = document.getElementById("input");
         var   whispertext = '<input type="text" id="messageinput" size="50" style="height:50px;" placeholder="메시지를 입력하세요" onkeypress="if(event.keyCode==13) {send(); return false;}">';
            whisperinput.innerHTML = whispertext;
         
         var send = document.getElementById("send");
         var inputmode = document.getElementById("mode");
         var uList = document.getElementById("uList");
         
         var sendChange = '<button type="button" onclick="send();" id="send">Send</button>'; 
         var modeChange = '<button type="button" onclick="whisperMode();" id="mode">Whisper</button>';
            send.outerHTML = sendChange;
            inputmode.outerHTML = modeChange;
            uList.outerHTML = "";
      }
         
      
      function writeResponse(text) {
         messages.innerHTML += text + "\n";      

         var scroll = document.getElementById("messages");
            scroll.scrollTop = scroll.scrollHeight;
      }      
      
      <% String uList = request.getParameter("uList"); %>
      var uList = "<%= uList %>";
   </script>
     
   <div id="input">
      <input type="text" id="messageinput" size="50" style="height:50px;" placeholder="메시지를 입력하세요" onkeypress="if(event.keyCode==13) {send(); return false;}">   
   </div>
   <div id="button">
      <button type="button" onclick="openSocket();">Open</button> &nbsp;
      <button type="button" onclick="closeSocket();">Close</button> &nbsp;
      
      <button type="button" onclick="whisperMode();" id="mode">Whisper</button> &nbsp;
      <button type="button" onclick="send();" id="send">Send</button> &nbsp;   
   </div>
   
</body>
</html>