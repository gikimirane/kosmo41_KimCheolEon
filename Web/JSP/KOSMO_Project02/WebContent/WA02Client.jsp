<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%	
	String ggName = null;

	if (session.getAttribute("ggName") == null){
		out.println(
				"<script language='javascript'> "+
					"alert('로그인이 필요한 컨텐츠입니다.'); "+
					" top.window.opener = top; " + 
					" top.window.open('','_parent', ''); " +
					" top.window.close(); "+
					"</script>");
		
		
	} 
	ggName = (String) session.getAttribute("ggName");
	
	/* httpSession */
%>
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

	/* 페이지 로드되면 바로 socket 열음 */
	$(document).ready(function() {
		openSocket();
	});
	
	var inUser = "<%=ggName%>";
	
	if(inUser === "null"){
		closeSocket();
	}
	
	
	/* 엔터키, 쉬프트+엔터키 처리 */
	$(function() {
		$('#messageinput').on('keydown', function(event){
			if(event.keyCode == 13){
				if(!event.shiftKey){
					event.preventDefault();
					send();
				}
			}
		})
	});

</script>
<style type="text/css">
	*{
		margin: 1px;
	}
</style>
<meta charset="UTF-8">
<title>WebSocket Client01</title>
</head>
<body>
	<div>
		<textarea id="messages"
		class="textarea"
		style="background-color: #9bbbd4;
		width:80%; height: 400px;
		resize: none;
		font-size: 16px;"
		readonly="readonly"></textarea>
		
		<textarea id="inUser"
		class="textarea"
		style="background-color: #F2F5A9;
		width: 17%; height: 400px;
		resize: none;
		font-size: 16px;"
		readonly="readonly"></textarea>
	</div>
	<div>
		<textarea id="rommList"
		class="textarea"
		style="background-color: #BCA9F5;
		width: 99%; height: 100px;
		resize: none;
		font-size: 16px;"
		readonly="readonly"></textarea>
	</div>
	<div>
		<span>접속자 : [</span><span style="font-weight: bold;"><%=ggName %></span><span>]</span>
	</div>
	<div style="text-align: right;">
		<button type="button" onclick="send();">메시지 전송(Enter)</button>
		<button type="button">방 리스트</button>
		<button type="button" onclick="openSocket();">접속하기</button>
		<button type="button" onclick="closeSocket();">연결끊기</button>
	</div>
	<div>
		<textarea id="messageinput" style="width: 99%; height: 100px; resize: none;"></textarea>
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
				/* 입장 겸 강제로 메시지 한번 날림 - webserver 에서 이름만 추출함 */
				webSocket.send(inUser + " 님이 입장하였습니다.");
				
				if (event.data === undefined) {
					return;
				}
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
			
			/*****************************************************************/
			/* 클라이언트의 메세지 전송 */
			var id = "<%= ggName%>";
			var text = document.getElementById("messageinput").value; 
			webSocket.send(id + " : " + text);
			/*****************************************************************/
			
			/* document.getElementById("messageinput").value=""; */
			/* 메시지 입력칸 비우기 */
			$('#messageinput').val("");
		}

		function closeSocket() {
			webSocket.send(inUser + " 님이 퇴장하셨습니다.");
			webSocket.close();
		}

		function writeResponse(text) {
			/* 스크롤이 있어야하고, 100줄 유지 제한시 뒤엣줄 삭제, 밑에 줄 추가 */
			
			messages.innerHTML += "\n" + text;
			
			/* 메시지 표시창 스크롤 자동내리기 */
			var top = $('#messages').prop('scrollHeight'); 
			$('#messages').scrollTop(top);
		}
	</script>

</body>
</html>