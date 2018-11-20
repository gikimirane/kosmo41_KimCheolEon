<%@page import="com.study.spring.dto.ConnectDB3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   ConnectDB3 connectDB = ConnectDB3.getInstance();

   String email = request.getParameter("email");

   String returns = connectDB.connectionDB(email);

   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>
</body>
</html>