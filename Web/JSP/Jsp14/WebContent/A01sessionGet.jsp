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
		Object obj1 = session.getAttribute("mySessionName");
		String mySessioName = (String)obj1;
		
		out.println(mySessioName + "<br>");
		
		Object obj2 = session.getAttribute("myNum");
		Integer myNum = (Integer)obj2;
		out.println(myNum + "<br>");
		
		out.println("**********************************<br>");
		
		String sName;
		String sValue;
		
		Enumeration enumeration = session.getAttributeNames();
		
		while(enumeration.hasMoreElements()){
			sName = enumeration.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			
			out.println("Name : " + sName + "<br>");
			out.println("Value : " + sValue + "<br>");
		}
		
		out.println("**********************************<br>");
		
		String sessionID = session.getId();
		out.println("sessionID : " + sessionID + "<br>");
		int sessionInter = session.getMaxInactiveInterval();
		out.println("sessionInter : " + sessionInter + "<br>");
		
		out.println("**********************************<br>");
		
		session.removeAttribute("mySessioName");
		Enumeration enumeration2 = session.getAttributeNames();
		while(enumeration2.hasMoreElements()){
			sName = enumeration2.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			out.println("Name : " + sName + "<br>");
			out.println("Value : " + sValue + "<br>");
		}
		
		out.println("**********************************<br>");
		
		session.invalidate();
		if(request.isRequestedSessionIdValid()){
			out.println("session valid");
		}else{
			out.println("session invalid");
		}
	%>
	
</body>
</html>