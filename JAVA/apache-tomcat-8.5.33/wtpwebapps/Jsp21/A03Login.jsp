<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	if(session.getAttribute("ValidMem") != null) {
    %>
    	<jsp:forward page="A05Main.jsp"></jsp:forward>
    <%
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="A04LoginOK.jsp" method="post">
		아이디 : <input type="text" name="id" 
					value="<%
								if(session.getAttribute("id") != null){
									out.println(session.getAttribute("id"));
								}
							%>"><br>
		비밀번호 : <input type="password" name="pw"><br><p>
		<input type="submit" value="로그인"> &nbsp;&nbsp;
		<input type="button" value="회원가입" onclick="javascript:window.location='A01Join.jsp'">
	</form>

</body>
</html>