<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JoinList</title>

<%
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
<link rel="stylesheet"
	href="https://static.onoffmix.com/css/common/pc/common-pc.css">
<!-- Common Script -->
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-1.10.2.js"></script>
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-ui-1.10.4.custom.js"></script>
<script
	src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.dotdotdot-1.5.0.js"></script>

<!-- =================================== 공통 끝 ===================================  -->

<!-- =================================== 화면 고유 시작 ===================================  -->
<!-- OFM Style -->
 <link rel="stylesheet"
	href="https://static.onoffmix.com/css/pc/event/event-search.css">
<!-- =================================== 화면 고유 끝 ===================================  -->
<noscript>
	<iframe src="//www.googletagmanager.com/ns.html?id=GTM-TMSKZ8"
		height="0" width="0" style="display: none; visibility: hidden"></iframe>
</noscript>
<script>
	(function(w, d, s, l, i) {
		w[l] = w[l] || [];
		w[l].push({
			'gtm.start' : new Date().getTime(),
			event : 'gtm.js'
		});
		var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l='
				+ l
				: '';
		j.async = true;
		j.src = '//www.googletagmanager.com/gtm.js?id=' + i + dl;
		f.parentNode.insertBefore(j, f);
	})(window, document, 'script', 'dataLayer', 'GTM-TMSKZ8');
</script>

</head>
<body class="onoffmix">

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
				<p class="phonenum"><%=userName %> 님 안녕하세요</p>
				<%
                  }else{
                  %>
                  <p class="phonenum">로그인 해주세요</p>
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
                  			<li><a href="recordcheck"><span data-hover="기록관리">기록관리</span></a></li>
                  			<li><a href=""><span data-hover="마이페이지">마이페이지</span></a></li>
							<li><a href="logout"><span data-hover="로그아웃">로그아웃</span></a></li>
							<%
                 			 } 
                 			 %>
						</nav>
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

	<!-- Main Content : event/event-search.html -->
	<main id="content" class="event_search"> <!-- wrapping -->
	<div class="content_wrapping max_width_area">
		<!-- event list -->
		<section class="event_main_area">
			<div class="title_bar">
				<h2 class="main_title">모임</h2>
			</div>
			<ul class="event_lists">
				<c:forEach items="${clublist}" var="join">
					<li>
						<article class='event_area event_state'>
							<a href='join_view.do?numId=${join.numId}'>
								<div class='event_thumbnail'>
									<img src="resources/image/${join.upload}" name="filename">
								</div>
								<div class='event_info_area'>
									<!-- 타이틀 -->
									<div class='title_area'>
										<h5 class='numId ellipsis'>글번호 : ${join.numId}</h5>
										<br />
										<h5 class='Name ellipsis'>작성자 : ${join.name}</h5>
										<br />
										<h5 class='Title ellipsis'>제목 : ${join.title}</h5>
										<br />
										<h5 class='Address ellipsis'>주소 : ${join.address}</h5>
									</div>

								</div>
							</a>
						</article>
					</li>
				</c:forEach>
			</ul>
			<br/>
			<br/>
			<ul class="pagination justify-content-center">
				<tr >
					<!-- 글작성 버튼 -->
					<td colspan="5" class="" width="100%">
					<a href="jmake_view.do"
						type="button" class="btn btn-secondary btn-sm">모임만들기</a></td>
				</tr>
			</ul>
			<br/>
			<!-- 페이지항목 부트스트랩 -->
			<td colspan="5">
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">

						<li class="page-item"><a class="page-link"
							href="joinlist.do?option=${option}&search=${search}&page=1">[
								&lt;&lt; ]</a></li>
						<li class="page-item"><a class="page-link"
							href="joinlist.do?option=${option}&search=${search}&page=${page.curPage - 1}">[
								&lt; ]</a></li>
						<c:forEach var="fEach" begin="${page.startPage}"
							end="${page.endPage}" step="1">
							<li class="page-item"><a class="page-link"
								href="joinlist.do?option=${option}&search=${search}&page=${fEach }">[${fEach}]</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="joinlist.do?option=${option}&search=${search}&page=${page.curPage + 1}">[
								&gt; ]</a></li>
						<li class="page-item"><a class="page-link"
							href="joinlist.do?option=${option}&search=${search}&page=${page.totalPage }">[
								&gt;&gt; ]</a></li>
					</ul>
				</nav>
		</section>
		
		
		
		
		<!-- 광고창 -->
        <section class="keyword_search_area">
            <h2 class="hidden">모임 검색</h2>
                
                                <!-- search -->
                <fieldset class="search_area">
                    <label for="keywordSearch" class="title">모임제목 / 본문</label>
                    <input type="text" id="keywordSearch" name="sub_search" class="keyword_search" placeholder="키워드로 모임을 검색하세요" title="키워드로 모임을 검색하세요">
                    <button type="button" class="btn_search">검색</button>
                </fieldset>
            </section>
                
                
                
	</div>
	</main>
	<!-- =================================== 화면 고유 시작 ===================================  -->
	<!-- Plugin  -->
	<script
		src="/static_html/js/pc/dist/common/plugins/jquery.ui.doubleDatepicker.js"></script>
	<!-- Script -->
	<script src="/static_html/js/pc/dist/event/event-search.js"></script>
	<!-- =================================== 화면 고유 끝 ===================================  -->

	<!-- PC Common Script -->
	<script src="https://static.onoffmix.com/js/pc/dist/common/common.js"></script>
	<script src="https://static.onoffmix.com/js/pc/dist/common/header.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/plugins/app/app-ver-chk.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/log/statistic.js"></script>
	<!-- Script -->
	<script type="text/javascript">
		window.NREUM || (NREUM = {});
		NREUM.info = {
			"beacon" : "bam.nr-data.net",
			"licenseKey" : "4d73c0dfa7",
			"applicationID" : "119983018",
			"transactionName" : "Z1MAZEVWDREHWkEMWl4ZI1NDXgwMSXZzKGpzWQxERVgPDgNLGjpHVVsDQA==",
			"queueTime" : 0,
			"applicationTime" : 424,
			"atts" : "SxQDEg1MHh8=",
			"errorBeacon" : "bam.nr-data.net",
			"agent" : ""
		}
	</script>
</body>
</html>