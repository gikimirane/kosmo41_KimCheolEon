<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<title>WebBoard - List</title>

</head>
<body>
	<div class="container mx-auto">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">제목</th>
					<th scope="col">날짜</th>
					<th scope="col">히트</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list }" var="dto">
					<tr>
						<th scope="row">${dto.bId }</th>
						<td>${dto.bName }</td>
						<td><c:forEach begin="1" end="${dto.bIndent }">re:</c:forEach>
							<!-- 옛날방식이라고 함 아래. --> <%-- <a href="content_view.do?bId=${dto.bId}&page=${page.curPage}">${dto.bTitle }</a></td> --%>
							<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<div class="col-3">
				<a class="btn btn-primary" href="write_view.do" role="button">글작성</a>
			</div>
			<div class="col-9 mx-auto">
				<!-- 처음버튼 -->
				<c:choose>
					<c:when test="${(page.curPage)-1 < 1}">
					[ &lt;&lt; ]		
				</c:when>
					<c:otherwise>
						<a href="list.do?page=1">[ &lt;&lt; ]</a>
					</c:otherwise>
				</c:choose>
				<!-- 이전버튼 -->
				<c:choose>
					<c:when test="${(page.curPage)-1 < 1}">
					[ &lt; ]
				</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage-1}">[ &lt; ]</a>
					</c:otherwise>
				</c:choose>
				<!------------------------------------------------------------------>

				<!-- 개별페이지 -->
				<c:forEach var="fEach" begin="${page.startPage}"
					end="${page.endPage}" step="1">
					<c:choose>
						<c:when test="${page.curPage == fEach}">
						[ ${fEach} ]&nbsp;
					</c:when>
						<c:otherwise>
							<a href="list.do?page=${fEach}">[ ${fEach} ]</a>&nbsp;		
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<!------------------------------------------------------------------>


				<!-- 다음버튼 -->
				<c:choose>
					<c:when test="${(page.curPage)+1 > page.totalPage}">
					[ &gt; ]		
				</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage+1}">[ &gt; ]</a>
					</c:otherwise>
				</c:choose>
				<!-- 끝버튼 -->
				<c:choose>
					<c:when test="${page.curPage == page.totalPage}">
					[ &gt;&gt; ]
				</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.totalPage}">[ &gt;&gt; ]</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>



</body>
</html>