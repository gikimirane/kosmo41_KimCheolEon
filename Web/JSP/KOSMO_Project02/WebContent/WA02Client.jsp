<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%	
	String id = null;

	if (session.getAttribute("ggEmail") == null){
		out.println(
				"<script> "+
					"alert('로그인이 필요한 컨텐츠입니다.'); "+
					"document.location.href='A01Main.jsp' "+
				"</script>");
		
	} else {
		id = (String) session.getAttribute("ggName");
		/* httpSession */
	}
%>
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		openSocket();
	});
	
	function enter_press(e) {
		
		var enterkey = e.keyCode;
		
		if(enterkey==13){
			send();
		}
	}
</script>
<style type="text/css">
	*{
		margin: 0px;
	}
</style>
<meta charset="UTF-8">
<title>WebSocket Client01</title>
</head>
<body>
	<textarea id="messages"
		class="textarea"
		style="background-color: #9bbbd4;
		width: 99%; height: 600px;
		resize: none;
		font-size: 16px;"
		readonly="readonly">
	</textarea>
	<div>
		<span>접속자 : [</span><span style="font-weight: bold;"><%=id %></span><span>]</span>
	</div>
	<br>
	<div>
		<textarea id="messageinput" onkeypress="enter_press(event);" 
			style="width: 99%; height: 100px"></textarea>
	</div>

	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<button type="button" onclick="send();">Send</button>
		<button type="button" onclick="closeSocket();">Close</button>
	</div>
	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");

		function openSocket() {
			if (webSocket !== undefined
					&& webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			/* 도메인을 localhost가 아니라 ip 줄것. 아마존의 경우 도메인 통째로 
			대상 서버 주소-*/
			webSocket = new WebSocket(
					"ws://localhost:8081/KOSMO_Project02/websocketendpoint2");

			webSocket.onopen = function(event) {
				if (event.data === undefined) {
					return;
				}
				/* 누구님 어서오세요 등 접속메시지 */
				writeResponse(event.data);
			};

			webSocket.onmessage = function(event) {
				/* 서버에서 온 메시지 */
				writeResponse(event.data);
			};

			webSocket.onclose = function(event) {
				/* 보통은 창을 닫아버려서 여기 메시지는 필요없음 */
				writeResponse("Connection closed");
			};
		}

		function send() {
			/* var text = document.getElementById("messageinput").value;
			webSocket.send(text); */
			var id = "<%= id%>";
			var text = document.getElementById("messageinput").value; 
			webSocket.send(id + ":" + text);
			
			/* document.getElementById("messageinput").value=""; */
			$('#messageinput').val('');
		}

		function closeSocket() {
			webSocket.close();
		}

		function writeResponse(text) {
			/* 스크롤이 있어야하고, 100줄 유지 제한시 뒤엣줄 삭제, 밑에 줄 추가 */
			messages.innerHTML += "\n" + text;
			
			var top = $('#messages').prop('scrollHeight'); 
			$('#messages').scrollTop(top);
		}
	</script>

</body>
</html>