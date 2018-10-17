<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<%-- 
	이름 : ${member.name } <br />
	아이디 : ${member.id } <br />
	비밀번호 : ${member.pw } <br />
	메일 : ${member.email }
	 --%>
	 
	<!-- http://localhost:8081/spring05/member/join?name=test11&id=test22&pw=test33&email=test44 -->
	이름 : ${memberInfo.name } <br />
	아이디 : ${memberInfo.id } <br />
	비밀번호 : ${memberInfo.pw } <br />
	메일 : ${memberInfo.email }
</body>
</html>