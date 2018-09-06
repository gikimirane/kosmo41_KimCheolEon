<%@page import="javax.websocket.Session"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>KOSMO Project02-WebBoard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function search_check() {
		var select = $("#search_select option:selected").val();
		var word = $("#search_word").val();
		alert(select);
		alert(word);
		
		if(select != "" && word!= ""){
			alert("둘다 내용 있음");	
			document.getElementById('search_form').submit();
		}
	}

</script>


<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

/****************************************************************************/
th, td {
	padding: 10px;
}
</style>
</head>
<body>
	<div class="container-fluid bg-primary">
		<h3>Cheol-Eon Kim's Record</h3>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Portfolio</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="A01Main.jsp">Home</a></li>
					<li><a href="#">About</a></li>
					<li class="active"><a href="list.do">WebBoard</a></li>
					<li><a href='#'
						onclick='javascript:window.open("http://www.naver.com","name99", "width=500px,height=650px,left=100px,top=100px");'>testNaver</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Join</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div>
		<br>
		<div>
			<table width="90%" border="1" style="margin: auto;">
				<tr>
					<td align="center">번호</td>
					<td align="center">이름</td>
					<td align="center">제목</td>
					<td align="center">날짜</td>
					<td align="center">히트</td>
				</tr>

				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.bId }</td>
						<td>${dto.bName }</td>
						<td><c:forEach begin="1" end="${dto.bIndent }">re:</c:forEach>
							<!-- 옛날방식이라고 함 아래. --> <%-- <a href="content_view.do?bId=${dto.bId}&page=${page.curPage}">${dto.bTitle }</a></td> --%>
							<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						<div style="text-align: right;">
							<button type="button" class="btn btn-primary"
								onclick="window.location.href='write_view.do'">글작성</button>
						</div>
						<form id="search_form" action="search.do" method="post">
							<div style="text-align: center;">
							<select id="search_select" name="select">
								<option selected="selected" value="bname">이름</option>
								<option name="word" value="btitle">제목</option>
							</select>
							<input type="text" placeholder="검색어" id="search_word" name="word">
							<input type="button" value="검색" onclick="search_check()">
						</div>
						</form>
						
					</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: center;">
						<!-- 처음버튼 --> <c:choose>
							<c:when test="${(page.curPage)-1 < 1}">
					[ &lt;&lt; ]		
				</c:when>
							<c:otherwise>
								<a href="list.do?page=1&select=${select}&word=${word}">[ &lt;&lt; ]</a>
							</c:otherwise>
						</c:choose> <!-- 이전버튼 --> <c:choose>
							<c:when test="${(page.curPage)-1 < 1}">
					[ &lt; ]
				</c:when>
							<c:otherwise>
								<a href="list.do?select=${select}&word=${word}&page=${page.curPage-1}">[ &lt; ]</a>
							</c:otherwise>
						</c:choose> <!------------------------------------------------------------------>

						<!-- 개별페이지 --> <c:forEach var="fEach" begin="${page.startPage}"
							end="${page.endPage}" step="1">
							<c:choose>
								<c:when test="${page.curPage == fEach}">
						[ ${fEach} ]&nbsp;
					</c:when>
								<c:otherwise>
									<a href="list.do?select=${select}&word=${word}&page=${fEach}">[ ${fEach} ]</a>&nbsp;		
					</c:otherwise>
							</c:choose>
						</c:forEach> <!------------------------------------------------------------------>


						<!-- 다음버튼 --> <c:choose>
							<c:when test="${(page.curPage)+1 > page.totalPage}">
					[ &gt; ]		
				</c:when>
							<c:otherwise>
								<a href="list.do?select=${select}&word=${word}&page=${page.curPage+1}">[ &gt; ]</a>
							</c:otherwise>
						</c:choose> <!-- 끝버튼 --> <c:choose>
							<c:when test="${page.curPage == page.totalPage}">
					[ &gt;&gt; ]
				</c:when>
							<c:otherwise>
								<a href="list.do?select=${select}&word=${word}&page=${page.totalPage}">[ &gt;&gt; ]</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	
	<br> totalCount : ${page.totalCount }
	<br> listCount : ${page.listCount }
	<br> totalPage : ${page.totalPage }
	<br> curPage : ${page.curPage }
	<br> pageCount : ${page.pageCount }
	<br> startPage : ${page.startPage }
	<br> endPage : ${page.endPage }
	<br> select : ${select }
	<br> word : ${word }

</body>
</html>
