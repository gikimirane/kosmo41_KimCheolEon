<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="varName" value="varValue"></c:set>
	varName : <c:out value="${varName }"></c:out>
	<br>
	<c:remove var="varName"/>
	varName : <c:out value="${varName }"></c:out>
	
	<hr>
	
	<c:catch var="error11">
		<%=2/0 %>
	</c:catch>
	<br>
	<c:out value="${error11 }"></c:out>
	<!-- catch 에러 이름을 가진 친구의 Exception 내용을 뱉어내는군.  -->
	
	<hr>
	
	<c:if test="${1+2 == 3 }">
		1 + 2 = 3
	</c:if>
	<br>
	<c:if test="${1+2 != 4 }">
		1 + 2 != 4
	</c:if>
	
	<hr>
	
	<c:forEach var="fEach" begin="0" end="30" step="3">
		${fEach }
	</c:forEach>
	

</body>
</html>