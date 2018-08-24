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
		queryString = $('#LoginProcess').serialize();

		alert(queryString);
		submit_ajax();
	}

	function submit_ajax() {
		$.ajax({
			url : '/Jsp19_2/LoginProcess',
			type : 'POST',
			data : queryString,
			dataType : 'json',
			success : function(json) {
				/* alert(json); */
				var result = eval(json);
				/* alert(result[0].result + ":" +result[0].desc); */
				if (result[0].result == "ok") {
					alert("정상 로그인.");
					window.location.replace("A04LoginResult.jsp");
				} else {
					alert(result[0].desc);
				}
			}
		})
	}
</script>
</head>
<body>
	<form id="LoginProcess">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		<input type="button" value="로그인" onclick="form_check()">
	</form>
</body>
</html>