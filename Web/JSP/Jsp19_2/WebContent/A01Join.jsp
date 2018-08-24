<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery.js"></script>
<title>Insert title here</title>
<script>
	var queryString;

	function form_check() {
		queryString = $('#JoinProcess').serialize();

		alert(queryString);
		submit_ajax();
	}

	function submit_ajax() {
		$.ajax({
			url : '/Jsp19_2/JoinProcess',
			type : 'POST',
			data : queryString,
			dataType : 'json',
			success : function(json) {
				/* alert(json); */
				var result = eval(json);
				/* alert(result[0].result + ":" +result[0].desc); */
				if (result[0].result == "ok") {
					alert("정상 가입되었습니다.");
					window.location.replace("A03Login.jsp");
				} else {
					alert(result[0].desc);
				}
			}
		})
	}
</script>
</head>
<body>
	<form id="JoinProcess">
		아이디 : <input type="text" name="id" size="10"><br> 비밀번호 :
		<input type="text" name="pw" size="10"><br> 이름 : <input
			type="text" name="name" size="10"><br> 전화번호 : <select
			name="phone1">
			<option value="010">010</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
			<option value="011">011</option>
		</select> - <input type="text" name="phone2" size="5"> - <input
			type="text" name="phone3" size="5"><br> 성별구분 : <input
			type="radio" name="gender" value="man">남자 &nbsp; <input
			type="radio" name="gender" value="woman">여자 <br>
		<!-- <input type="button" value="회원가입" onclick="form_check()"> -->
		<input type="button" value="Ajax 폼 전송" onclick="form_check()">
		<input type="reset" value="취소">

	</form>
</body>
</html>