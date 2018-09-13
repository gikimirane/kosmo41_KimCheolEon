<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String ggName = null;

	if (session.getAttribute("ggName") == null) {
		out.println(
				"<script language='javascript'> " + "alert('로그인이 필요한 컨텐츠입니다.'); " + " top.window.opener = top; "
						+ " top.window.open('','_parent', ''); " + " top.window.close(); " + "</script>");

	}
	ggName = (String) session.getAttribute("ggName");

	/* httpSession */
%>
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

	/* 페이지 로드되면 실행 */
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
* {
	margin: 1px;
}
</style>
<meta charset="UTF-8">
<title>WebSocket Client01</title>
</head>
<body>
	<div>
		<textarea id="messages"
			style="background-color: #9bbbd4; width: 80%; height: 400px; resize: none; font-size: 16px;"
			readonly="readonly"></textarea>

		<select id="inusers" name="inusers" size="20"
			style="background-color: #F2F5A9; width: 17%; font-size: 15px;">
		</select>
	</div>
	<div>
		<select id="rommList" name="rommList" size="10"
			style="background-color: #BCA9F5; width: 99%; font-size: 16px;"
			readonly="readonly">
		</select>
	</div>
	<div>
		<span>접속자 : [</span><span style="font-weight: bold;"><%=ggName%></span><span>]</span>
		<span>
			<button type="button" onclick="openSocket();">접속하기</button>
			<button type="button" onclick="closeSocket();">연결끊기</button>
			<button type="button" onclick="messageDel();">글 지우기</button>
		</span>
	</div>
	<div style="text-align: right;">
		<button type="button" onclick="callRoomList();">방 리스트</button>
		<button type="button" onclick="$('[name=inusers] option').prop('selected', false)">접속자 선택해제</button>
		<button type="button" onclick="callInUser();">접속자 목록갱신</button>
	</div>
	<div>
		<textarea id="messageinput"
			style="width: 99%; height: 100px; resize: none;"></textarea>
		<button type="button" onclick="send();">메시지 전송(Enter)</button>
	</div>
	<script type="text/javascript">	
		var webSocket;
		var messages = document.getElementById("messages");

		var callAction = "";
		var callInUserData = "";
		var callroomlistData = "";
		var strSplit = null;
		
		function openSocket() {
			
			if (webSocket !== undefined
					&& webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("이미 접속중인 상태입니다.");
				return;
			}
			
			/* 도메인을 localhost가 아니라 ip 줄것. 아마존의 경우 도메인 통째로 
			대상 서버 주소-*/
			webSocket = new WebSocket(
					"ws://localhost:8081/KOSMO_Project02/websocketendpoint2");

			webSocket.onopen = function(event) {
				/* 입장 겸 강제로 메시지 한번 날림 - webserver 에서 이름만 추출함 */
				webSocket.send(inUser + " 님이 입장하였습니다.");
				callInUser();
				
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
				writeResponse("접속 해제");
			};
			
			
			splitData(callInUserData);
		}

		function send() {
			/* var text = document.getElementById("messageinput").value;
			webSocket.send(text); */
			
			/*****************************************************************/
			/* 클라이언트의 메세지 전송 */
			var id = "<%=ggName%>";
			var text = document.getElementById("messageinput").value;
			var select = $("#inusers option:selected").val();
			
			if(select == undefined){
				webSocket.send(id + " : " + text);		
			} else if(select == ""){
				webSocket.send(id + " : " + text);
				alert("잘못된 대상입니다");
			} else{
				webSocket.send(id + " : " + text + "t@o@" + select);
			}
			
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

		/***************************************************************************/
		function messageDel() {
			$('#messages').html("");
		}
		
		
		
		function callInUser() {
			$.ajax({
				url : 'chatUsercall.do',
				type : 'POST',
				data : callAction,
				dataType : 'json',
				success : function(json) {
					var result = eval(json);
					if (result[0].result == "ok") {
						$('#inusers').html("");
						/* $('#inusers').append(result[0].data); */
						callInUserData = result[0].data;
						splitData(callInUserData);
					} else {
						alert(result[0].desc);
					}
				}
			})
		}
		
		function splitData(data) {
			strSplit = data.split('|');
			
			for(var i in strSplit){
				$("#inusers").append("<option value='"+strSplit[i]+"'>"+strSplit[i]+"</option>");
			}
		}
		
		function splitData2(data) {
			strSplit = data.split('|');
			
			for(var i in strSplit){
				$("#rommList").append("<option value='"+strSplit[i]+"'>"+strSplit[i]+"</option>");
			}
		}
		
		
		function callRoomList() {
			$.ajax({
				url : 'roomListcall.do',
				type : 'POST',
				data : callAction,
				dataType : 'json',
				success : function(json) {
					var result = eval(json);
					if (result[0].result == "ok") {
						/* alert(result[0].data); */ 
						$('#rommList').html("");
						callroomlistData = result[0].data;
						splitData2(callroomlistData);
					} else {
						alert(result[0].desc);
					}
				}
			})
		}
	</script>

</body>
</html>