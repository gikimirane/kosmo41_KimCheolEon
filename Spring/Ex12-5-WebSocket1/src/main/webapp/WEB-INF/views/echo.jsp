<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Echo JSP</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#sendBtn').click(function () {
			sendMessage();
		});
	});
	
	var wsocket;
	function sendMessage(){
		wsocket = new WebSocket("ws://localhost:8081/spring1251/echo-ws");
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		wsocket.onopen = function(){
			wsocket.send($('#message').val());
		};
	}
	
	function onMessage(evt){
		var data = evt.data;
		alert("서버에서 데이터 받음 : " + data);
		wsocket.close();
	}
	
	function onClose(evt){
		alert("연결 끊김");
	}
</script>
</head>
<body>
	<input type="text" id="message">
	<input type="button" id="sendBtn" value="전송">
</body>
</html>