<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket Client01</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (id == null) {
	%>
	<jsp:forward page="Login.jsp"></jsp:forward>
	<%
		} else {
			session.setAttribute("uid", id);
			/* httpSession */
		}
	%>

	<div>
		사용자 아이디 : <%=id %>
	</div>
	
	<div>
		<input type="text" id="messageinput">
	</div>

	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<button type="button" onclick="send();">Send</button>
		<button type="button" onclick="closeSocket();">Close</button>
	</div>

	<div id="messages"></div>

	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");

		function openSocket() {
			if (webSocket !== undefined
					&& webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			/* 도메인을 localhost가 아니라 ip 줄것. 아마존의 경우 도메인 통째로 */
			webSocket = new WebSocket(
					"ws://localhost:8081/WebSocket01/websocketendpoint2");

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
		}

		function closeSocket() {
			webSocket.close();
		}

		function writeResponse(text) {
			/* 스크롤이 있어야하고, 100줄 유지 제한시 뒤엣줄 삭제, 밑에 줄 추가 */
			messages.innerHTML += "<br>" + text;
		}
	</script>

</body>
</html>