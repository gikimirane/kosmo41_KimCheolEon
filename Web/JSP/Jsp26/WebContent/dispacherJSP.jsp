<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	자바 서블릿에서 JSP 쪽으로 호출<br>
	dispacherJSP.jsp
	<hr>
	
	id : <%=request.getAttribute("id") %><br>
	pw : <%=request.getAttribute("pw") %>
	
</body>
</html>