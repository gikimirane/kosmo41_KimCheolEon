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
		Cookie[] cookies = request.getCookies();
	
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("id")){
				String id = cookies[i].getValue();
				out.println(id + " 님 안녕하세요. <br>");
			}
		}
	%>
	<a href="A01LogOut.jsp">로그아웃</a><br><p>
	
	<a href="A02cookietest.jsp">쿠키 테스트</a>
</body>
</html>