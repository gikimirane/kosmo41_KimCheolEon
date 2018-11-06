<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
</head>
<style>
	#div_left{
	width:20%;
	height:300px;
	float:left;
	background-color:#819FF7;
	}
	#div_menu{
	width:60%;
	float:left;
	}
	#div_right{
	width:20%;
	height:300px;
	float:right;
	background-color:#C8FE2E;
	}
</style>
<body>

	<!-- 상단 메뉴바 -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
		<a class="navbar-brand">님 안녕하세요.</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="main.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="list.do">게시판</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> 기록관리 </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">기록</a> <a class="dropdown-item"
							href="#">그래프</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link disabled" href="">마이페이지</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="">로그아웃</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" id="div_left"></div>
	
	<!-- 게시판 목록 -->
	<div class="container" id="div_menu">	
		<table class="table table-striped" width="800">
			<thead class="table-dark">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>제목</td>
					<td>날짜</td>
					<td>히트</td>
				</tr>
			</thead>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <a
						href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>

			<tr>
				<!-- 글작성 버튼 -->
				<td colspan="5"><a href="write_view" type="button"
					class="btn btn-secondary btn-sm">글작성</a></td>
			</tr>
			<tr>
				<!-- 페이지항목 부트스트랩 -->
				<td colspan="5">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">

							<li class="page-item"><a class="page-link"
								href="list.do?option=${option}&search=${search}&page=1">[
									&lt;&lt; ]</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?option=${option}&search=${search}&page=${page.curPage - 1}">[
									&lt; ]</a></li>
							<c:forEach var="fEach" begin="${page.startPage}"
								end="${page.endPage}" step="1">
								<li class="page-item"><a class="page-link"
									href="list.do?option=${option}&search=${search}&page=${fEach }">[${fEach}]</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link"
								href="list.do?option=${option}&search=${search}&page=${page.curPage + 1}">[
									&gt; ]</a></li>
							<li class="page-item"><a class="page-link"
								href="list.do?option=${option}&search=${search}&page=${page.totalPage }">[
									&gt;&gt; ]</a></li>
						</ul>
					</nav>
		</table>
		</div>
			<div class="container" id="div_right">
		
		totalCount : ${page.totalCount }<br> listCount : ${page.listCount }<br>
		totalPage : ${page.totalPage }<br> curPage : ${page.curPage }<br>
		pageCount : ${page.pageCount }<br> startPage : ${page.startPage }<br>
		endPage : ${page.endPage }<br>
		</div>
</body>
</html>