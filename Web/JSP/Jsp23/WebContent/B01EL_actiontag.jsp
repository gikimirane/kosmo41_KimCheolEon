<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="com.study.jsp.TestDTO" scope="page"></jsp:useBean>    
<%-- ${member.name =  "홍길동" };
${member.id =  "abc" };
${member.pw =  "123" }; --%>
<!-- 값을 넣고 찍어버림(출력) -->

<!-- setProperty 는 el 이 없음.... 나중에 추가된... EL3.0 265p-->
<jsp:setProperty name="member" property="name" value="홍길동"></jsp:setProperty>
<jsp:setProperty name="member" property="id" value="abc"></jsp:setProperty>
<jsp:setProperty name="member" property="pw" value="123"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <jsp:getProperty property="name" name="member"/><br>
	아이디 : <jsp:getProperty property="id" name="member"/><br>
	비밀번호 : <jsp:getProperty property="pw" name="member"/><br>
	
	<hr>
	
	이름 : ${member.name}<br>
	아이디 : ${member.id}<br>
	비밀번호 : ${member.pw}<br>  

</body>
</html>