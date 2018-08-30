<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	/* if(request.getParameter("curPage") != null){
		curPage = Integer.parseInt(request.getParameter("curPage"));
	} */
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="800" cellpadding="0" cellpadding="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td><c:forEach begin="1" end="${dto.bIndent }">re:</c:forEach>
					<a href="content_view.do?bId=${dto.bId}&page=${page.curPage }">${dto.bTitle }</a></td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글작성</a></td>
		</tr>

		<tr>
			<td>
				<a href="list.do?curPage=1">[처음]</a>
				<a href="list.do?curPage=${page.curPage - 1}">[이전]</a>
			
			
				<a href="list.do?curPage=${page.curPage + 1}">[다음]</a>
				<a href="list.do?curPage=${page.totalPage }">[끝]</a>
			
			</td>
		</tr>

	</table>

	totalCount : ${page.totalCount }
	<br> listCount : ${page.listCount }
	<br> totalPage : ${page.totalPage }
	<br> curPage : ${page.curPage }
	<br> pageCount : ${page.pageCount }
	<br> startPage : ${page.startPage }
	<br> endPage : ${page.endPage }


</body>
</html>