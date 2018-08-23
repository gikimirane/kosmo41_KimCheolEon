<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw, name;
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		
		out.println("<script>alert('id : " + id + "');</script>");
		out.println("<script>alert('pw : " + pw + "');</script>");
		out.println("<script>alert('name : " + name + "');</script>");
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("name", name);
		
		session.setMaxInactiveInterval(3000);		
	%>
	
	<a href="B01LoginGet.jsp">Session 확인하기</a>
</body>
</html>