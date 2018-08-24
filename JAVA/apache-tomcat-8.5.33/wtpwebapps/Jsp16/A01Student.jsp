<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="stu" class="com.study.jsp.BeanStudent" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Bean</title>
</head>
<body>
	<jsp:setProperty property="name" name="stu" value="홍길동"/>
	<jsp:setProperty property="age" name="stu" value="13"/>
	<jsp:setProperty property="grade" name="stu" value="6"/>
	<jsp:setProperty property="studentNumber" name="stu" value="7"/>
	
	이름 : <jsp:getProperty property="name" name="stu"/><br>
	나이 : <jsp:getProperty property="age" name="stu"/><br>
	학년 : <jsp:getProperty property="grade" name="stu"/><br>
	번호 : <jsp:getProperty property="studentNumber" name="stu"/><br>
</body>
</html>