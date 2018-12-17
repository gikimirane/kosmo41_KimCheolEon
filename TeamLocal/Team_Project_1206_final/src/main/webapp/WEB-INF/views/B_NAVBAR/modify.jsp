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
<title>MY pets</title>

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
                  			<li><a href="myPagelist"><span data-hover="마이페이지">마이페이지</span></a></li>
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

	<!-- content-section-starts -->
	<div class="content">
		<div class="main">
			<div class="container">
				<div class="cont span_2_of_3">
					<div class="single">
						<div class="leave">
							<h4>회원정보 수정</h4>
						</div>


						<form action="modifyOk.do" method="post" name="reg_frm">
							<div class="container">
								<table class="table table-striped" width="800">
									<div>
										<tr>
											<td>아이디</td>
											<td><input type="text" name="email" size="20"
												value="<%=email%>" readonly /></td>
										</tr>
										<tr>
											<td>비밀번호</td>
											<td><input type="password" name="pw" size="20"></td>
										</tr>
										<tr>
											<td>비밀번호 확인</td>
											<td><input type="password" name="pw_check" size="20"></td>
										</tr>
										<tr>
											<td>이름</td>
											<td><%=userName%></td>
										</tr>
										<tr>
											<td>핸드폰</td>
											<td><input type="text" name="phone" size="20"></td>
										</tr>
										<tr>

											<td colspan="2" align="right"><input type="button"
												value="수정" onclick="updateInfoConfirm()">&nbsp;&nbsp;&nbsp;
												<input type="reset" value="취소"
												onclick="javascript:window.location='/spring'">
										</tr>
									</div>
								</table>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function updateInfoConfirm() {
			if (document.reg_frm.pw.value == "") {
				alert("패스워드를 입력하세요.")
				document.reg_frm.pw.focus();
				return;
			}

			if (document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
				alert("패스워드가 일치하지 않습니다.")
				reg_frm.pw.focus();
				return;
			}

			document.reg_frm.submit();
		}
	</script>
</body>
</html>