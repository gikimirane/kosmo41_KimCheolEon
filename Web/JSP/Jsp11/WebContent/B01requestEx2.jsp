<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B01requestEx2 JSP</title>
</head>
<body>
	<%!
		int age;
	%>
	
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
		
		if(age >= 20){
			response.sendRedirect("B01requestEx3_pass.jsp?age=" + age);
		}else{
			response.sendRedirect("B01requestEx4_ng.jsp?age=" + age);
		}
	%>
	

</body>
</html>