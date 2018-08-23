<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String num1, num2, calcradio, Method;
	int pNum1, pNum2;
	int result = 0;%>

	<%
		request.setCharacterEncoding("UTF-8");

		/* num1 = request.getParameter("num1");
		num2 = request.getParameter("num1"); */

		pNum1 = Integer.parseInt(request.getParameter("num1"));
		pNum2 = Integer.parseInt(request.getParameter("num2"));

		calcradio = request.getParameter("calcradio");

		if (calcradio.equals("더하기")) {
			result = pNum1 + pNum2;
		}
		if (calcradio.equals("빼기")) {
			result = pNum1 - pNum2;
		}
		if (calcradio.equals("곱하기")) {
			result = pNum1 * pNum2;
		}
		if (calcradio.equals("나누기")) {
			result = pNum1 / pNum2;
		}
	%>
	
	숫자1 : <%= pNum1 %><br>
	숫자2 : <%= pNum2 %><br>
	결과 : <%=result %>

</body>
</html>