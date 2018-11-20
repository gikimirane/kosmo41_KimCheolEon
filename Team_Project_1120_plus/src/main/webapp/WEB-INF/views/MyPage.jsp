<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String userName = (String) session.getAttribute("userName");
	String email = (String) session.getAttribute("email_id");
	session.setAttribute("email1", email);
	if (session.getAttribute("ValidMem") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	} else {
		userName = (String) session.getAttribute("userName");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify</title>

<!-- 웹페이지 메인 -->
<link href="resources/web/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/web/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="resources/web/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- Custom Theme files -->
<!-- navigation -->
<link href="resources/web/css/component.css" rel="stylesheet"
	type="text/css" />
<!-- navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
		
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	 

</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<script src="resources/web/js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<script type="text/javascript" src="resources/web/js/move-top.js"></script>
<script type="text/javascript" src="resources/web/js/easing.js"></script>

<script language="javaScript" src="member.js"></script>
</head>
<body>

	<!-- header-section-starts -->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<p class="location">
					<i class="location"></i>한국소프트웨어인재개발원
				</p>
				<%
					if (session.getAttribute("ValidMem") != null) {
				%>
				<p class="phonenum"><%=userName%>님 안녕하세요　　　<a href="mem_modify" style="font-size: 20px; color: white;">정보수정</a></p>
				<%
                  }else{
                  %>
				<p class="phonenum"><a href="login" style="font-size: 20px; color: white;">로그인</a> 해주세요</p>
                  <%
                  }
                  %>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
				<div class="logo">
					<a href="/spring"><img src="resources/web/images/logo.png"
						alt="" /></a>
				</div>
				<span class="menu"></span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-5">
							<li><a class="active" href="/spring"><span
									data-hover="Home">Home</span></a></li>
							<li><a href="list"><span data-hover="일반게시판">일반게시판</span></a></li>
							<li><a href="joinlist"><span data-hover="모임게시판">모임게시판</span></a></li>
							<%
								if (session.getAttribute("ValidMem") != null) {
							%>
							<li><a href="recheck"><span data-hover="기록관리">기록관리</span></a></li>
                  			<li><a href="myPage"><span data-hover="마이페이지">마이페이지</span></a></li>
							<li><a href="logout"><span data-hover="로그아웃">로그아웃</span></a></li>
							<%
                 			 } 
                 			 %>
						</nav>
					</ul>
				</div>
				<!-- script for menu -->
				<script>
					$("span.menu").click(function() {
						$(".top-menu").slideToggle("slow", function() {
							// Animation complete.
						});
					});
				</script>
				<!-- script for menu -->
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!-- 게시판 목록 -->
	<div class="container">
		<table class="table table-striped" width="600">
			<tr>
				<td>모임번호</td>
				<td>참가신청 시간</td>
				<td>이름</td>
				<td>상태</td>
			</tr>
			<c:forEach items="${mypage}" var="dto">
				<tr>
					<td><a href='join_view.do?numId=${dto.numId_FK}'>${dto.numId_FK}</td>
					<td>${dto.timeinfo}</td>
					<td>${dto.userName}</a></td>
					<td>${dto.state}</td>
				</tr>
			</c:forEach>
			<tr>
				<!-- 페이지항목 부트스트랩 -->
				<td colspan="5" align="center">
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
</body>
</html>