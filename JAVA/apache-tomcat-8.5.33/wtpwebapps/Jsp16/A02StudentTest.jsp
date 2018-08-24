<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="stu" class="com.study.jsp.BeanStudent" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="stu"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Bean</title>
</head>
<body>
	<%
		stu.setName("name.set");
		stu.setAge(19);
		stu.setGrade(4);
		stu.setStudentNumber(3);
	%>
	
	이름 : <%=stu.getName() %><br>
	나이 : <%=stu.getAge() %><br>
	학년 : <%=stu.getGrade() %><br>
	번호 : <%=stu.getStudentNumber() %><br>
</body>
</html>