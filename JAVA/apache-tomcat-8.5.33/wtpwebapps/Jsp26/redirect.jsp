<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP에서 서블릿쪽으로 호출<br>
	<%
		request.setAttribute("id", "abc1234");
		request.setAttribute("pw", "1234abc");
		
		response.sendRedirect("RequestObj2");
		/* pageContext.forward("RequestObj2"); */
		/* 이거 완전 disparcher 포워드 방식이네. 위에거 쓰면 redirect.jsp
			주소 상태에서 내용이 RequestObj2 내용으로 바뀜*/
	%>

</body>
</html>