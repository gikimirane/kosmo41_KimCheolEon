<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=3JqMeRQ5Uq03soADkuw8&submodules=geocoder"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join-View</title>
<%
	String makerName = (String)session.getAttribute("makerName");
	String userName = null;
	if(session.getAttribute("ValidMem") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
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
							<li><a href=""><span data-hover="로그아웃">로그아웃</span></a></li>
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
 
									<!-- Main Content : event/event-view.html -->
<style type="text/css">body{background-color:#0;background-repeat:repeat;}</style><main id="content" class="event_view" data-event-no="156849">
    <div class="event_skin"  style="overflow:hidden;background-color:#eef2f7;background-repeat:repeat;height:430px;margin-bottom:-429px;"></div>
    <!-- wrapping -->
    <div class="content_wrapping max_width_area">
        <!-- EVENT Summary Infomation -->
        <section class="event_summary">
			<div class="top_area">

				<!-- 부적절한 신고 form  끝 -->
			</div>
			<div class="left_area">
				<!-- event img -->
				<div class="event_thumbnail main_thumbnail">
					<img src="resources/image/${join_view.upload}" name="filename">
				</div>

				<!-- Host Infomation -->
				<div class="host_info_area">

					<!-- 정보 -->
					<ul id="hostInfo" class="host_info active " role="tabpanel"
						aria-labelledby="tabInfo">

					</ul>

					<ul id="moreEvent" class="more_event" role="tabpanel"
						aria-labelledby="tabMore">
						<li class="active">
							<article class="event_area event_more"></article>
						</li>
					</ul>

				</div>
				<!-- 접속자가 관리자일 경우 관리자메뉴 -->
			</div>

			<div class="right_area">
				<h3 class="event_title">${join_view.title}</h3>
				<ul class="event_info_wrap">
					<li>
						<h4 class="label date parse_print">신청기간</h4>
						<p class="description date">${join_view.eventStart} ~ ${join_view.eventEnd}</p>
					</li>
					<li>
						<h4 class="label date parse_print">모임기간</h4>
						<p class="description date">${join_view.wantedStart} ~ ${join_view.wantedEnd}</p>
					</li>
					<li>
						<h4 class="label place parse_print">모임장소</h4>
						<p class="description place">
							<span class="adress">${join_view.address}</span>
							<a type="button" href="#eventMap">지도보기</a>
						</p>
					</li>
					<li>
						<h4 class="label attend parse_print">모집정원</h4>
						<p class="description attend">
							<span class="total">총 <span class="number_txt">${join_view.fixed}</span>명</span> 
							<span class="available">신청자 <span class="number_txt2">${joinapplycount.count}</span>명</span>
						</p>
					</li>
				</ul>

				<!-- 이벤트 요약설명 : 서브 타이틀 -->
				<div class="summary_wrap">
					<p class="summary_txt">
						내용<br />
						 ${join_view.content}
						 <br />
						 <br />
						<button type="button" class="btn_more">모임소개 더보기</button>
				</div>

				<!-- 버튼 CASE 6 -->
				<!-- 작성자여부 확인 -->
				<%
				if(makerName.equals(userName)){
				%>
				
				
				<a href="javascript:void(0);" onclick="join_delete();" type="button" class="btn btn-danger btn-sm">삭제하기</a> 
				
				
				<a href="joinlist.do?page=<%=session.getAttribute("cpage")%>"
					type="button" class="btn btn-secondary btn-sm">목록보기</a>
				
				<!-- 작성자 아닌상태,신청자여부 확인 -->	
				<%
				}else {
				%>
				
				<!-- 모임신청 취소하기 -->
				<!-- <a href="javascript:void(0);" onclick="join_cancel();" type="button" class="btn btn-danger btn-sm">취소하기</a> --> 
					
				<%
					}
				%> 
				<!-- 미 신청자 -->
				<a href="javascript:void(0);" onclick="join_join();" type="button" class="btn btn-primary btn-sm">신청하기</a>
				<a href="javascript:void(0);" onclick="" type="button" class="btn btn-success btn-sm">문자보내기</a>
				<a href="joinlist.do?page=<%=session.getAttribute("cpage")%>"
					type="button" class="btn btn-secondary btn-sm">목록보기</a>
				
			</div>
		</section>

       <!-- event detail -->
		<section class="event_detail">
			<ul class="tab_menu">

				<li><a href="#eventMap">지도 보기</a></li>

			</ul>
			<div id="eventMap" class="pagination justify-content-center">
			<div id="map" style="width: 80%; height: 400px;">
			<script>
					// 줌 버튼 생성
					var map = new naver.maps.Map('map', {
					    zoomControl: true,
					    zoomControlOptions: {
					        position: naver.maps.Position.TOP_RIGHT
					    }
					});
							var myaddress = '${join_view.address}';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
							naver.maps.Service
									.geocode(
											{
												address : myaddress
											},
											function(status, response) {
												if (status !== naver.maps.Service.Status.OK) {
													return alert(myaddress
															+ '의 검색 결과가 없거나 기타 네트워크 에러');
												}
												var result = response.result;
												var myaddr = new naver.maps.Point(
														result.items[0].point.x,
														result.items[0].point.y);
												map.setCenter(myaddr); // 검색된 좌표로 지도 이동
												// 마커 표시
												var marker = new naver.maps.Marker(
														{
															position : myaddr,
															map : map
														});
												// 마커 클릭 이벤트 처리
												naver.maps.Event
														.addListener(
																marker,
																"click",
																function(e) {
																	if (infowindow
																			.getMap()) {
																		infowindow
																				.close();
																	} else {
																		infowindow
																				.open(
																						map,
																						marker);
																	}
																});
												// 마크 클릭시 인포윈도우 오픈
												var infowindow = new naver.maps.InfoWindow(
														{
															content : '<h4> [${join_view.address}]</h4>' // DB에 저장된 주소를 마커에 표시
														});
											});
							
						</script>
				</div>
			</div>
			<!-- 지도 밑에 마커와 지번표시 --> 
			<div class="tab_content">
			<div id="eventMap" class="pagination justify-content-center">
			<div class="place">${join_view.address}</div> 
			</div>
			</div>
		</section>
	</div>
	
	<script>
	var scriptUsername = '<%=userName%>';
	function join_join(){
		   $.ajax({
		      url : 'join_join',
		      type : 'POST',
		      data : 'name=' + scriptUsername + "&numId=" +  ${join_view.numId} + "&fixed=" + ${join_view.fixed} +  "&count=" + ${joinapplycount.count},
		      dataType : 'json',
		      success : function(json) {
		         var result = eval(json);
		         //alert(result[0].desc);
		         $('.number_txt2').text(result[0].desc);
		      }
		   });
		}
	
	function join_delete(){
		   $.ajax({
		      url : 'join_delete',
		      type : 'POST',
		      data : 'name=' + scriptUsername + "&numId=" +  ${join_view.numId}+ "&maker=${join_view.name}" ,
		      dataType : 'json',
		      success : function(json) {
		         var result = eval(json);
		         alert(result[0].desc);
		         
		      }
		   });
		}
	</script>
<!-- =================================== 화면 고유 시작 ===================================  -->
<!-- Plugin -->
<script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.browser.js"></script>
<script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.emailbox.js"></script>
<script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.fancybox-1.3.3.js"></script>
<script src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.qtip-2.1.1.js"></script>
<!-- Script -->
<script src="https://static.onoffmix.com/js/pc/dist/common/jquery.noscroll.js"></script>
<script src="https://static.onoffmix.com/js/pc/dist/common/plugins/map2.js"></script>
<script type="text/javascript" src="https://static.onoffmix.com/js/pc/dist/event/event-view.js"></script>
<!-- =================================== 화면 고유 끝 ===================================  -->


			<!-- PC Common Script -->
    <script src="https://static.onoffmix.com/js/pc/dist/common/common.js"></script>
    <script src="https://static.onoffmix.com/js/pc/dist/common/header.js"></script>
    <script src="https://static.onoffmix.com/js/common/dist/plugins/app/app-ver-chk.js"></script>
    <script src="https://static.onoffmix.com/js/common/dist/log/statistic.js"></script>
	<!-- Script -->
	<script type="text/javascript">window.NREUM||(NREUM={});NREUM.info={"beacon":"bam.nr-data.net","licenseKey":"4d73c0dfa7","applicationID":"119983018","transactionName":"Z1MAZEVWDREHWkEMWl4ZI1NDXgwMSXZzKGpzWQxERVgPDgNLGjpHVVsDQA==","queueTime":0,"applicationTime":222,"atts":"SxQDEg1MHh8=","errorBeacon":"bam.nr-data.net","agent":""}</script></body>
</html>