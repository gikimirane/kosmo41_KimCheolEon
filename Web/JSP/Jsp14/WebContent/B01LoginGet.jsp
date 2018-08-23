<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		Object obj1 = session.getAttribute("id");
		String sessionID = (String)obj1;
		out.println(sessionID + "<br>");
		
		Object obj2 = session.getAttribute("pw");
		String sessionPW = (String)obj2;
		out.println(sessionPW + "<br>");
		
		Object obj3 = session.getAttribute("name");
		String sessionNAME = (String)obj3;
		out.println(sessionNAME + "<br>");
		
		if(sessionID == null){
			response.sendRedirect("B01Login.html");
		}else{
			out.println(sessionID + " 님 안녕하세요");
		}
	%>
	<br><br>
	<%
		String sName;
		String sValue;
		
		Enumeration enumeration = session.getAttributeNames();
		
		while(enumeration.hasMoreElements()){
			sName = enumeration.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			
			out.println("Name : " + sName + "<br>");
			out.println("Value : " + sValue + "<br>");
		}
		
		String sessionIDvalue = session.getId();
		out.println("sessionIDvalue : " + sessionIDvalue + "<br>");
		int sessionInter = session.getMaxInactiveInterval();
		out.println("sessionInter : " + sessionInter + "<br>");
	%>
	<br>
	
	<a href="B01LogOut.jsp">Session 로그아웃</a>
</body>
</html>