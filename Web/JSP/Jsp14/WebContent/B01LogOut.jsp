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
		session.invalidate();
		if (request.isRequestedSessionIdValid()) {
			out.println("session valid <br>");
		} else {
			out.println("session invalid <br>");
		}
	%>
	<h3>이하, include LoginGet</h3>
	<jsp:include page="B01LoginGet.jsp"></jsp:include>
</body>
</html>