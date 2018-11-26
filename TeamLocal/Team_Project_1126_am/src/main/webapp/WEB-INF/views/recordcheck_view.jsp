<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>recordCheck_view</title>

<%
	String userName = null;
	if (session.getAttribute("ValidMem") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String jsonMap = (String)request.getAttribute("map");
	
	JSONArray jsonarray = new JSONArray(jsonMap);
	JSONObject jsonObject;
	
	String getLat = "";
	String getLong = "";
	
	JSONObject firstCenter =  jsonarray.getJSONObject(0);
%>

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
<script type="text/javascript" src="resources/web/js/move-top.js"></script>
<script type="text/javascript" src="resources/web/js/easing.js"></script>

<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=3JqMeRQ5Uq03soADkuw8&submodules=geocoder"></script>

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
	href="https://static.onoffmix.com/css/pc/event/event-view.css">
<!-- =================================== 화면 고유 끝 ===================================  -->
<script>
	dataLayer = [ {
		uid : "990343"
	} ]
</script>
<noscript>
	<iframe src="//www.googletagmanager.com/ns.html?id=GTM-TMSKZ8"
		height="0" width="0" style="display: none; visibility: hidden"></iframe>
</noscript>
<script>
	(
					function(w, d, s, l, i) {
						w[l] = w[l] || [];
						w[l].push({
							'gtm.start' : new Date().getTime(),
							event : 'gtm.js'
						});
						var f = d.getElementsByTagName(s)[0], j = d
								.createElement(s), dl = l != 'dataLayer' ? '&l='
								+ l
								: '';
						j.async = true;
						j.src = '//www.googletagmanager.com/gtm.js?id=' + i
								+ dl;
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


	<!-- Main Content : event/event-view.html -->
	<style type="text/css">
body {
	background-color: #0;
	background-repeat: repeat;
}
</style>
	<main id="content" class="event_view" data-event-no="156849">
	<div class="event_skin"
		style="overflow: hidden; background-color: #eef2f7; background-repeat: repeat; height: 430px; margin-bottom: -429px;"></div>
	<!-- wrapping -->
	<div class="content_wrapping max_width_area">
		<!-- EVENT Summary Infomation -->
		<section class="event_summary">
			<div class="top_area">

				<!-- 부적절한 신고 form  끝 -->
			</div>

			<div class="right_area">
				<h3 class="event_title">${recordcheck_view.eMail}님의활동기록</h3>
				<ul class="event_info_wrap">
					<li>
						<h4 class="label date parse_print">활동시작 시간</h4>
						<p class="description date">${recordcheck_view.startTime}</p>
					</li>
					<li>
						<h4 class="label date parse_print">활동종료 시간</h4>
						<p class="description date">${recordcheck_view.endTime}</p>
					</li>
					<li>
						<h4 class="label place parse_print">총 활동시간</h4>
						<p class="description place">
							<span class="adress">${recordcheck_view.moveTime}</span> <a
								type="button" href="#eventMap">활동 지도보기</a>
						</p>
					</li>
				</ul>

			</div>
		</section>

		<!-- event detail -->
		<section class="event_detail">
			<ul class="tab_menu">

				<li><a href="#eventMap">활동 지도보기</a></li>

			</ul>
			<div id="eventMap" class="pagination justify-content-center">
				<div id="map" style="width: 80%; height: 400px;">

					<script>

						var map = new naver.maps.Map('map', {
							center : new naver.maps.LatLng(
								<%=firstCenter.getString("lat")%>, <%=firstCenter.getString("long")%>),
							zoom :10
						});
							var polyline = new naver.maps.Polyline({
								map : map,
								startIcon : naver.maps.PointingIcon.CIRCLE,
								endIcon : naver.maps.PointingIcon.OPEN_ARROW,
								path : [
									<%for (int i = 0; i < jsonarray.length(); i++) {
										jsonObject = jsonarray.getJSONObject(i);
										getLat = jsonObject.getString("lat");
										getLong = jsonObject.getString("long");
									%>
										new naver.maps.LatLng(<%=getLat%>, <%=getLong%>),
									<%}%>
										
								]
							});
						
					</script>

				</div>
			</div>
		</section>
	</div>
	<!-- =================================== 화면 고유 시작 ===================================  -->
	<!-- Plugin --> <script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.browser.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.emailbox.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.fancybox-1.3.3.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.qtip-2.1.1.js"></script>
	<!-- Script --> <script
		src="https://static.onoffmix.com/js/pc/dist/common/jquery.noscroll.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/map2.js"></script>
	<!-- =================================== 화면 고유 끝 ===================================  -->


	<!-- PC Common Script --> <script
		src="https://static.onoffmix.com/js/pc/dist/common/common.js"></script>
	<script src="https://static.onoffmix.com/js/pc/dist/common/header.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/plugins/app/app-ver-chk.js"></script>
	<script
		src="https://static.onoffmix.com/js/common/dist/log/statistic.js"></script>
	<!-- Script --> <script type="text/javascript">
		window.NREUM || (NREUM = {});
		NREUM.info = {
			"beacon" : "bam.nr-data.net",
			"licenseKey" : "4d73c0dfa7",
			"applicationID" : "119983018",
			"transactionName" : "Z1MAZEVWDREHWkEMWl4ZI1NDXgwMSXZzKGpzWQxERVgPDgNLGjpHVVsDQA==",
			"queueTime" : 0,
			"applicationTime" : 222,
			"atts" : "SxQDEg1MHh8=",
			"errorBeacon" : "bam.nr-data.net",
			"agent" : ""
		}
	</script>
</body>
</html>