<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String userName = (String) session.getAttribute("userName");
	String email = (String) session.getAttribute("email");
%> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify</title>
<script language="javaScript" src="member.js"></script>
</head>
<body>
	<form action="modifyOk.do" method="post" name="reg_frm">
			아이디 : <%=email %><br> 
			비밀번호 : <input type="text" name="pw" size="20"><br> 
			비밀번호 확인 : <input type="text" name="pw_check" size="20"><br> 
			이름 : <%=userName %><br> 
			메일 : <input type="text" name="eMail" size="20" value="<%=email %>"><br>  
			<input type="button" value="수정" onclick="updateInfoConfirm()">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소" onclick="javascript:window.location='list.do'">
	</form>
</body>
</html>