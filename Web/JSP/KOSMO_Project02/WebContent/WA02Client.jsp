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
		
		$(".btnFunc").show();
		
		
		$("#btnCon").click(function(){
			$(".btnFunc").show();
		});
		
		$("#btnDiscon").click(function(){
			$(".btnFunc").hide();
		});
	});
	
	var inUser = "<%=ggName%>";
	
	if(inUser == "null"){
		closeSocket();
		$(".btnFunc").hide();
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

.white_content {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: rgba(0, 0, 0, 0.8);
    opacity:0;
    -webkit-transition: opacity 400ms ease-in;
    -moz-transition: opacity 400ms ease-in;
    transition: opacity 400ms ease-in;
    pointer-events: none;
}
.white_content:target {
    opacity:1;
    pointer-events: auto;
}
.white_content > div {
	position: absolute;
	top: 25%;
	left: 25%;
	width: 40%;
	height: 40%;
	padding: 10px;
	border: 10px solid orange;
	background-color: white;
	overflow: auto;	
}
</style>
<meta charset="UTF-8">
<title>WebSocket Client01</title>
</head>
<body>
	<div>대화창</div>
	<div>
		<textarea id="messages"
			style="background-color: #9bbbd4; width: 80%; height: 400px; resize: none; font-size: 16px;"
			readonly="readonly"></textarea>

		<select id="inusers" name="inusers" size="20"
			style="background-color: #F2F5A9; width: 17%; font-size: 15px;">
		</select>
	</div>
	<div>
		방 목록
		<select id="rommList" name="rommList" size="10"
			style="background-color: #BCA9F5; width: 99%; font-size: 16px;"
			readonly="readonly">
		</select>
	</div>
	<div>
		<span>접속자 : [</span><span style="font-weight: bold;"><%=ggName%></span><span>]</span>
		<span>
			<button type="button" id="btnCon" onclick="openSocket();">접속하기</button>
			<button type="button" id="btnDiscon" onclick="closeSocket();">연결끊기</button>
			<button type="button" onclick="messageDel();">글 지우기</button>
		</span>
	</div>
	<div style="text-align: right;">
    	<button type="button" class="btnFunc" onclick="window.location.href='#open'">방 생성하기</button>
		<button type="button" class="btnFunc" onclick="$('[name=rommList] option').prop('selected', false)">방목록 선택해제</button>
		<button type="button" class="btnFunc" onclick="callRoomList();">방 목록갱신</button>
		<button type="button" class="btnFunc" onclick="roomIn();">방 입장</button>
		<button type="button" class="btnFunc" onclick="roomOut();">방 퇴장</button>
		<button type="button" class="btnFunc" onclick="$('[name=inusers] option').prop('selected', false)">접속자 선택해제</button>
		<button type="button" class="btnFunc" onclick="callInUser();">접속자 목록갱신</button>
	</div>
	<div>
		<textarea id="messageinput"
			style="width: 99%; height: 100px; resize: none;"></textarea>
		<button type="button" class="btnFunc" onclick="send();">메시지 전송(Enter)</button>
	</div>
	<!-- https://hackya.com/kr/css-%EB%A7%8C%EC%9C%BC%EB%A1%9C-%EB%AA%A8%EB%8B%AC%EC%B0%BD-%EB%9D%84%EC%9A%B0%EA%B8%B0/ -->
	<div class="white_content" id="open">
       	<div>
       		<div>
	           	<p style="text-align: right;"><a href="#close" onclick="roomClean();">닫기</a></p>
	           	<br>
	           	<div style="text-align: center;">
	           		<input type="text" id="mkroomTitle" placeholder="방 이름"><br><br>
	            	<input type="radio" name="mkroom_max" value="2"><label>2 명</label>
	            	<input type="radio" name="mkroom_max" value="5"><label>5 명</label>
	            	<input type="radio" name="mkroom_max" value="10"><label>10 명</label>
	            	<input type="radio" name="mkroom_max" value="20"><label>20 명</label>
	           	</div>
	           	<br><br>
	           	<div style="text-align: center;">
	            	<input type="radio" name="mkroom_hidden" value="공개" onclick="mkpw_divEvent();"><label>공개</label>
	            	<input type="radio" name="mkroom_hidden" value="비공개" onclick="mkpw_divEvent();"><label>비공개</label>
	           	</div>
	           	<br><br>
	           	<div style="text-align: center; display: none;" id="mkpw_div" >
	           		<input type="text" id="mkroom_pw" placeholder="비밀번호"><br><br>
	           	</div>
           	</div>
           	<div style="text-align: center;">
           		<input type="button" value="취소" onclick="window.location.href='#close'; roomClean();">
	           	<input type="button" value="확인" onclick="roomCreate(); roomClean();">
       		</div>
       	</div>

   	</div>
	
	<script type="text/javascript">	
		var webSocket;
		var messages = document.getElementById("messages");

		var callAction = "";
		var callInUserData = "";
		var callroomlistData = "";
		var strSplit = null;
		
		function mkpw_divEvent() {
			var divE = $('input:radio[name="mkroom_hidden"]:checked').val();

			if(divE == "비공개"){
				$("#mkpw_div").show();
			}
			if(divE == "공개"){
				$("#mkpw_div").hide();
			}
		}
		
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
				callRoomList();
				
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
		
		
		function roomIn() {
			var selectRoom = $("#rommList option:selected").val();
			if(selectRoom == undefined){
				alert("잘못된 방 입장입니다.");
			} else if(selectRoom == ""){
				alert("잘못된 방 입장입니다.");
			} 
			else{
				selectRoom = selectRoom.replace(/\s/gi, "");
				
				var roomNo = selectRoom.indexOf(".");
				var roomNoEnd = selectRoom.indexOf("]");
				var roomStat = selectRoom.indexOf("상태:비공개");
				/* substr 은 해당 위치에서 다음 인자 갯수 갖고옴 */
				/* substring 은 해당위치부터 다음 위치까지 자름 */
				var NoSub = selectRoom.substring(roomNo+1, roomNoEnd);
				
				if(roomStat != -1){
					var roomPass = prompt("비공개 방입니다.", "")
					if(roomPass == null){
						return;
					}
					webSocket.send("/in " + NoSub + " " + roomPass);
				}else{
					webSocket.send("/in " + NoSub);
				}
			}			
		}
		
		
		function roomCreate() {

			var rcName = $("#mkroomTitle").val();
			var rcMax = $('input:radio[name="mkroom_max"]:checked').val();
			var rcHidden = $('input:radio[name="mkroom_hidden"]:checked').val();
			var rcPass = $("#mkroom_pw").val();
			
			callAction = "rcName=" + rcName + "&rcMax=" + rcMax + 
				"&rcHidden=" + rcHidden + "&rcPass=" + rcPass + "&inUser=" + inUser;
			
			$.ajax({
				url : 'roomCreate.do',
				type : 'POST',
				data : callAction,
				dataType : 'json',
				success : function(json) {
					var result = eval(json);
					if (result[0].result == "ok") {
						alert("생성 성공");
					} else {
						alert(result[0].desc);
					}
				}
			})
			
			window.location.href='#close';
		}
		
		function roomClean() {
			$("#mkroomTitle").val("");
			$("input:radio[name='mkroom_hidden']").prop('checked', false)
			$("input:radio[name='mkroom_max']").prop('checked', false)
			$('[name=mkroom_hidden] option').prop('checked', false)
			$("#mkroom_pw").val("");
		}
		
		
		
		function roomOut() {
			callAction = "inUser=" + inUser;
			
			$.ajax({
				url : 'roomOut.do',
				type : 'POST',
				data : callAction,
				dataType : 'json',
				success : function(json) {
					var result = eval(json);
					if (result[0].result == "ok") {
						alert(result[0].data);
					} else {
						alert(result[0].desc);
					}
				}
			})
		}
		
	</script>

</body>
</html>
