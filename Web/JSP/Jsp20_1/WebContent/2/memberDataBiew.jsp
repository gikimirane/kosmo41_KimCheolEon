<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    	Connection con;
    	PreparedStatement pstmt;
    	ResultSet resultSet;
    	
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_1-2 TEST</title>
</head>
<body>
	<%
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			String query;
		} catch (Exception e){
			
		}
	%>

</body>
</html>