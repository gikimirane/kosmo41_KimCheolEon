<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content_view</title>


<%
	String content_view_makerName = (String)session.getAttribute("content_view_makerName");
	String userName = null;
	if(session.getAttribute("ValidMem") != null){
	userName = (String)session.getAttribute("userName");
	}
%>

<!-- 웹페이지 메인 -->
<link href="resources/web/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/web/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="resources/web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!-- navigation -->
<link href="resources/web/css/component.css" rel="stylesheet" type="text/css"  />
<!-- navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<script src="resources/web/js/responsiveslides.min.js"></script>
 <script>
    $(function () {
      $("#slider").responsiveSlides({
         auto: true,
         speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
  <script type="text/javascript" src="resources/web/js/move-top.js"></script>
<script type="text/javascript" src="resources/web/js/easing.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
	<!-- =================================== 공통 시작 ===================================  -->
    <!-- OFM Common Style -->
    <link rel="stylesheet" href="https://static.onoffmix.com/css/common/pc/common-pc.css">
    <!-- Common Script -->
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-1.10.2.js"></script>
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-ui-1.10.4.custom.js"></script>
    <script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.dotdotdot-1.5.0.js"></script>
    <!-- =================================== 공통 끝 ===================================  -->

    <!-- =================================== 화면 고유 시작 ===================================  -->
    <!-- OFM Style -->
    <link rel="stylesheet" href="https://static.onoffmix.com/css/pc/event/event-view.css">
    <!-- =================================== 화면 고유 끝 ===================================  -->
<script>dataLayer=[{uid:"990343"}]</script>	<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-TMSKZ8"
	                  height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
			new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
			j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
			'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
		})(window,document,'script','dataLayer','GTM-TMSKZ8');</script>
		
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
                  if(session.getAttribute("ValidMem") != null){
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
                  			if(session.getAttribute("ValidMem") != null){
                  			%>
                  			<li><a href="recheck"><span data-hover="기록관리">기록관리</span></a></li>
                  			<li><a href="mem_modify"><span data-hover="마이페이지">마이페이지</span></a></li>
							<li><a href="logout"><span data-hover="로그아웃">로그아웃</span></a></li>
							<%
                 			 } 
                 			 %>
						</nav>s
					</ul>
				</div>
				<!-- script for menu -->
				<script>
            $( "span.menu" ).click(function() {
              $( ".top-menu" ).slideToggle( "slow", function() {
                // Animation complete.
              });
            });
         </script>
				<!-- script for menu -->
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
   
   	<!-- Main Content : event/event-view.html -->
    <!-- wrapping -->
    <div class="content_wrapping max_width_area">
        <!-- EVENT Summary Infomation -->
        <section class="event_summary">
			<div class="top_area">

				
			</div>
			<div class="center_area">

				<h3 class="event_title">${content_view.bTitle }</h3>
				<ul class="event_info_wrap">
					<li>
						<i class="fas fa-calendar"> 글번호</i>
						<p class="description bId">${content_view.bId}</p>
					</li>
		
					<li>
						<i class="fas fa-thumbs-up"> 조회수</i>
						<p class="description bHit">${content_view.bHit}</p>
					</li>
				
					<li>
						<i class="fas fa-address-card"> 작성자</i>
						<p class="description place">
							<span class="bName">${content_view.bName }</span>
						</p>
					</li>
				
					<li>
						<i class="fas fa-comment-dots"> 내용</i>
					</li>
				</ul>

				<!-- 이벤트 요약설명 : 서브 타이틀 -->
				<div class="summary_wrap">
					<p class="summary_txt">
						 ${content_view.bContent}
				</div>
			</div>
			<br/>
			<br/>
			
			<!-- 스크립트 안에서 alert -->
			<%-- <script>
				var nameTest='<%=content_view_makerName%>';
				alert(nameTest);
			</script> --%>
			
			
			<div class="bottom_area" align="right">
				<a href="list.do?page=<%=session.getAttribute("cpage")%>" class="badge badge-pill badge-info">목록보기</a>&nbsp;&nbsp;
				
				
				<!-- 작성자와 열람자 동일여부 확인 동일인일시 수정,삭제 활성화 -->
				<% if(content_view_makerName.equals(userName)) {%>
				
				<a href="modify_view.do?bId=${content_view.bId }" class="badge badge-pill badge-warning">수정</a>&nbsp;&nbsp;
				<a href="delete.do?bId=${content_view.bId }" class="badge badge-pill badge-danger">삭제</a>&nbsp;&nbsp;
				
				<%} %>
				
				<a href="reply_view.do?bId=${content_view.bId}" class="badge badge-pill badge-success">답변</a>
			</div>
		</section>
	</div>
</body>
</html>