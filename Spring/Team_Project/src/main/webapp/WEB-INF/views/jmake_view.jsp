<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JMake_View</title>
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
<%
	String userName = null;
	if(session.getAttribute("ValidMem") == null) {
%>
	<jsp:forward page="login.jsp"/>
<%
	}else{
		userName = (String)session.getAttribute("userName");
	}
%>
<

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
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=3JqMeRQ5Uq03soADkuw8&submodules=geocoder"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
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
	href="https://static.onoffmix.com/css/pc/event/event-add.css">
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

<script type="text/javascript">

	function noAddress() {
		var placeNoneID = document.getElementById("placeNone");
		var placeNoneChecked = placeNoneID.checked;
		
		if(placeNoneChecked){
			document.getElementById("sample4_roadAddress").disabled = true;
			document.getElementById("sample4_roadAddress").value = "장소 미정";
			document.getElementById("addressSearch").disabled = true;
		}else{
			alert("주소찾기를 클릭해주세요.");
			document.getElementById("sample4_roadAddress").disabled = false;
			document.getElementById("sample4_roadAddress").value = "";
			document.getElementById("addressSearch").disabled = false;
		}
	}

</script>

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

	<!-- header : 마지막 수정일 20180306 -->
	<header id="header">
		<main id="content" class="event_add"> <!-- wrapping -->
		<div class="content_wrapping max_width_area">
			<div class="top_area">
				<h2 class="main_title">개설하기</h2>
			</div>
			<section class="main_area">

				<form  action="jmake" method="post" enctype="multipart/form-data">
				<div class="event_input_area">
					<div class="edit_wrap">
						<div class="right_wrap">
							<fieldset class="edit_title">
								<legend>
									<h3 class="title">모임명 <span class="required_txt">(필수)</span></h3>
								</legend>
								<div class="edit">
									<div class="write_wrap">
										<input id="title" type="text" name="title" class="title_input"
											required data-parsley-applydatecheck
											placeholder="모임명을 입력해 주세요." value="" maxlength="64"
											autofocus="autofocus" >
									</div>

									<div class="tip_txt">
										<span class="entities">*</span> 개설하고자 하는 모임과 어울리는 이름으로 입력하면
										모임을 찾기가 쉬워집니다.
									</div>
								</div>
							</fieldset>

							<fieldset class="edit_date">
								<legend>
									<h3 class="title">모임일시 <span class="required_txt">(필수)</span></h3>
								</legend>
								<div class="edit">
									<!-- 날짜 및 시간표기법 참고 -->
									<!-- 시작 일시 -->
									<div class="start_time" id="edit_date_start_time">
										<div class="write_wrap">
											<input type="date" id="startEventDate" name="JoinStart_date"
												required data-parsley-applydatecheck
												data-parsley-class-handler="#edit_date_start_time"
												data-parsley-required-message="모임 시작 일시를 입력해주세요."> <select
												class="timebox" id="startEventTime" name="JoinStart_time">
												<option value='00:00'>00:00</option>
												<option value='00:30'>00:30</option>
												<option value='01:00'>01:00</option>
												<option value='01:30'>01:30</option>
												<option value='02:00'>02:00</option>
												<option value='02:30'>02:30</option>
												<option value='03:00'>03:00</option>
												<option value='03:30'>03:30</option>
												<option value='04:00'>04:00</option>
												<option value='04:30'>04:30</option>
												<option value='05:00'>05:00</option>
												<option value='05:30'>05:30</option>
												<option value='06:00'>06:00</option>
												<option value='06:30'>06:30</option>
												<option value='07:00'>07:00</option>
												<option value='07:30'>07:30</option>
												<option value='08:00'>08:00</option>
												<option value='08:30'>08:30</option>
												<option value='09:00'>09:00</option>
												<option value='09:30'>09:30</option>
												<option value='10:00'>10:00</option>
												<option value='10:30'>10:30</option>
												<option value='11:00'>11:00</option>
												<option value='11:30'>11:30</option>
												<option value='12:00'>12:00</option>
												<option value='12:30'>12:30</option>
												<option value='13:00'>13:00</option>
												<option value='13:30'>13:30</option>
												<option value='14:00'>14:00</option>
												<option value='14:30'>14:30</option>
												<option value='15:00'>15:00</option>
												<option value='15:30'>15:30</option>
												<option value='16:00'>16:00</option>
												<option value='16:30'>16:30</option>
												<option value='17:00'>17:00</option>
												<option value='17:30'>17:30</option>
												<option value='18:00'>18:00</option>
												<option value='18:30'>18:30</option>
												<option value='19:00'>19:00</option>
												<option value='19:30'>19:30</option>
												<option value='20:00'>20:00</option>
												<option value='20:30'>20:30</option>
												<option value='21:00'>21:00</option>
												<option value='21:30'>21:30</option>
												<option value='22:00'>22:00</option>
												<option value='22:30'>22:30</option>
												<option value='23:00'>23:00</option>
												<option value='23:30'>23:30</option>
											</select> <span class="pd_txt">부터</span>
										</div>
									</div>
									<!-- 끝 일시 -->
									<div class="end_time" id="edit_date_end_time">
										<div class="write_wrap">
											<!-- 모임기간이 하루이상일때 #endEventDate block 됨 -->
											<input type="date" id="endEventDate" name="JoinEnd_date"
												required data-parsley-applydatecheck
												data-startdate="#startEventDate"
												data-starttime="eventStartDateTime_time"
												data-endtime="eventEndDateTime_time"
												data-parsley-class-handler="#edit_date_end_time"
												data-parsley-required-message="모임 종료 일시를 입력해주세요."> <select
												class="timebox" id="endEventTime" name="JoinEnd_time" >
												<option value='00:00'>00:00</option>
												<option value='00:30'>00:30</option>
												<option value='01:00'>01:00</option>
												<option value='01:30'>01:30</option>
												<option value='02:00'>02:00</option>
												<option value='02:30'>02:30</option>
												<option value='03:00'>03:00</option>
												<option value='03:30'>03:30</option>
												<option value='04:00'>04:00</option>
												<option value='04:30'>04:30</option>
												<option value='05:00'>05:00</option>
												<option value='05:30'>05:30</option>
												<option value='06:00'>06:00</option>
												<option value='06:30'>06:30</option>
												<option value='07:00'>07:00</option>
												<option value='07:30'>07:30</option>
												<option value='08:00'>08:00</option>
												<option value='08:30'>08:30</option>
												<option value='09:00'>09:00</option>
												<option value='09:30'>09:30</option>
												<option value='10:00'>10:00</option>
												<option value='10:30'>10:30</option>
												<option value='11:00'>11:00</option>
												<option value='11:30'>11:30</option>
												<option value='12:00'>12:00</option>
												<option value='12:30'>12:30</option>
												<option value='13:00'>13:00</option>
												<option value='13:30'>13:30</option>
												<option value='14:00'>14:00</option>
												<option value='14:30'>14:30</option>
												<option value='15:00'>15:00</option>
												<option value='15:30'>15:30</option>
												<option value='16:00'>16:00</option>
												<option value='16:30'>16:30</option>
												<option value='17:00'>17:00</option>
												<option value='17:30'>17:30</option>
												<option value='18:00'>18:00</option>
												<option value='18:30'>18:30</option>
												<option value='19:00'>19:00</option>
												<option value='19:30'>19:30</option>
												<option value='20:00'>20:00</option>
												<option value='20:30'>20:30</option>
												<option value='21:00'>21:00</option>
												<option value='21:30'>21:30</option>
												<option value='22:00'>22:00</option>
												<option value='22:30'>22:30</option>
												<option value='23:00'>23:00</option>
												<option value='23:30'>23:30</option>
											</select> <span>까지</span>
										</div>
									</div>
								</div>
							</fieldset>

							<fieldset class="edit_apply_date">
								<legend>
									<h3 class="title">접수기간 <span class="required_txt">(필수)</span></h3>
								</legend>
								<div class="edit">
									<!-- 시작 기간 -->
									<div class="start_time" id="edit_apply_date_start_time">
										<div class="write_wrap">
											<input type="date" id="startAcceptDate" name="Start_date"
												required data-parsley-applydatecheck
												data-parsley-class-handler="#edit_apply_date_start_time"
												data-parsley-required-message="접수 시작 일시를 입력해주세요."> <select
												class="timebox" id="startAcceptTime" name="Start_time" >
												<option value='00:00'>00:00</option>
												<option value='00:30'>00:30</option>
												<option value='01:00'>01:00</option>
												<option value='01:30'>01:30</option>
												<option value='02:00'>02:00</option>
												<option value='02:30'>02:30</option>
												<option value='03:00'>03:00</option>
												<option value='03:30'>03:30</option>
												<option value='04:00'>04:00</option>
												<option value='04:30'>04:30</option>
												<option value='05:00'>05:00</option>
												<option value='05:30'>05:30</option>
												<option value='06:00'>06:00</option>
												<option value='06:30'>06:30</option>
												<option value='07:00'>07:00</option>
												<option value='07:30'>07:30</option>
												<option value='08:00'>08:00</option>
												<option value='08:30'>08:30</option>
												<option value='09:00'>09:00</option>
												<option value='09:30'>09:30</option>
												<option value='10:00'>10:00</option>
												<option value='10:30'>10:30</option>
												<option value='11:00'>11:00</option>
												<option value='11:30'>11:30</option>
												<option value='12:00'>12:00</option>
												<option value='12:30'>12:30</option>
												<option value='13:00'>13:00</option>
												<option value='13:30'>13:30</option>
												<option value='14:00'>14:00</option>
												<option value='14:30'>14:30</option>
												<option value='15:00'>15:00</option>
												<option value='15:30'>15:30</option>
												<option value='16:00'>16:00</option>
												<option value='16:30'>16:30</option>
												<option value='17:00'>17:00</option>
												<option value='17:30'>17:30</option>
												<option value='18:00'>18:00</option>
												<option value='18:30'>18:30</option>
												<option value='19:00'>19:00</option>
												<option value='19:30'>19:30</option>
												<option value='20:00'>20:00</option>
												<option value='20:30'>20:30</option>
												<option value='21:00'>21:00</option>
												<option value='21:30'>21:30</option>
												<option value='22:00'>22:00</option>
												<option value='22:30'>22:30</option>
												<option value='23:00'>23:00</option>
												<option value='23:30'>23:30</option>
											</select> <span class="pd_txt"> 부터</span>
										</div>
									</div>
									<!-- 끝 기간 -->
									<div class="end_time" id="edit_apply_date_end_time">
										<div class="write_wrap">
											<input type="date" id="endAcceptDate" name="End_date"
												required data-parsley-applydatecheck
												data-startdate="#startAcceptDate"
												data-starttime="recruitStartDateTime_time"
												data-endtime="recruitEndDateTime_time"
												data-parsley-class-handler="#edit_apply_date_end_time"
												data-parsley-required-message="접수 종료 일시를 입력해주세요."
												data-parsley-eventdatecheck-message="접수기간의 종료시간은 시작시간보다 '이후'여야 합니다.">
											<select class="timebox" id="endAcceptTime" name="End_time">
												<option value='00:00'>00:00</option>
												<option value='00:30'>00:30</option>
												<option value='01:00'>01:00</option>
												<option value='01:30'>01:30</option>
												<option value='02:00'>02:00</option>
												<option value='02:30'>02:30</option>
												<option value='03:00'>03:00</option>
												<option value='03:30'>03:30</option>
												<option value='04:00'>04:00</option>
												<option value='04:30'>04:30</option>
												<option value='05:00'>05:00</option>
												<option value='05:30'>05:30</option>
												<option value='06:00'>06:00</option>
												<option value='06:30'>06:30</option>
												<option value='07:00'>07:00</option>
												<option value='07:30'>07:30</option>
												<option value='08:00'>08:00</option>
												<option value='08:30'>08:30</option>
												<option value='09:00'>09:00</option>
												<option value='09:30'>09:30</option>
												<option value='10:00'>10:00</option>
												<option value='10:30'>10:30</option>
												<option value='11:00'>11:00</option>
												<option value='11:30'>11:30</option>
												<option value='12:00'>12:00</option>
												<option value='12:30'>12:30</option>
												<option value='13:00'>13:00</option>
												<option value='13:30'>13:30</option>
												<option value='14:00'>14:00</option>
												<option value='14:30'>14:30</option>
												<option value='15:00'>15:00</option>
												<option value='15:30'>15:30</option>
												<option value='16:00'>16:00</option>
												<option value='16:30'>16:30</option>
												<option value='17:00'>17:00</option>
												<option value='17:30'>17:30</option>
												<option value='18:00'>18:00</option>
												<option value='18:30'>18:30</option>
												<option value='19:00'>19:00</option>
												<option value='19:30'>19:30</option>
												<option value='20:00'>20:00</option>
												<option value='20:30'>20:30</option>
												<option value='21:00'>21:00</option>
												<option value='21:30'>21:30</option>
												<option value='22:00'>22:00</option>
												<option value='22:30'>22:30</option>
												<option value='23:00'>23:00</option>
												<option value='23:30'>23:30</option>
											</select> <span>까지</span>
										</div>
									</div>

									<p class="tip_txt">
										<span class="entities">*</span> 신청 기간에만 모임에 참여 신청 / 취소를 할 수
										있습니다.
									</p>
								</div>
							</fieldset>

							<!--  에러시 fieldset.edit_place 에  .error 넣어주세요-->
							<fieldset class="edit_place">
								<legend>
									<h3 class="title">
										모임장소<span class="required_txt">(필수)</span>
									</h3>
								</legend>

								<div class="edit">


									<!-- .write_wrap 다음 요소 에러메세지 임시 -->
									<!-- <ul class="parsley-errors-list check_msg">
                                        <li>장소명, 주소를 검색하거나 지도에서 선택해 주세요.</li>
                                    </ul> -->

									<input type="text" id="sample4_roadAddress" style="width: 50%" name="address" placeholder="도로명주소" readonly /> 
									<input type="button" onclick="sample4_execDaumPostcode()" value="주소찾기" id="addressSearch">
									<!-- 장소없음 체크시 .place_detail none 처리 -->
									<div class="check_txt">
										<input type="checkbox" id="placeNone" onclick="noAddress();">
										<label for="placeNone">장소 미정</label>
									</div>
									<span id="guide" style="color: #999"></span>
									<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
									<script>
										//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
										function sample4_execDaumPostcode() {
											new daum.Postcode(
													{
														oncomplete : function(
																data) {
															// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

															// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
															// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
															var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
															var extraRoadAddr = ''; // 도로명 조합형 주소 변수

															// 법정동명이 있을 경우 추가한다. (법정리는 제외)
															// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
															if (data.bname !== ''
																	&& /[동|로|가]$/g
																			.test(data.bname)) {
																extraRoadAddr += data.bname;
															}
															// 건물명이 있고, 공동주택일 경우 추가한다.
															if (data.buildingName !== ''
																	&& data.apartment === 'Y') {
																extraRoadAddr += (extraRoadAddr !== '' ? ', '
																		+ data.buildingName
																		: data.buildingName);
															}
															// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
															if (extraRoadAddr !== '') {
																extraRoadAddr = ' ('
																		+ extraRoadAddr
																		+ ')';
															}
															// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
															if (fullRoadAddr !== '') {
																fullRoadAddr += extraRoadAddr;
															}

															// 도로명 주소 정보를 해당 필드에 넣는다.
															document.getElementById('sample4_roadAddress').value = fullRoadAddr;
															mapLoad(fullRoadAddr);
															// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
															if (data.autoRoadAddress) {
																//예상되는 도로명 주소에 조합형 주소를 추가한다.
																var expRoadAddr = data.autoRoadAddress
																		+ extraRoadAddr;
																document
																		.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
																		+ expRoadAddr
																		+ ')';

															} else if (data.autoJibunAddress) {
																var expJibunAddr = data.autoJibunAddress;
																document
																		.getElementById('guide').innerHTML = '(예상 지번 주소 : '
																		+ expJibunAddr
																		+ ')';

															} else {
																document
																		.getElementById('guide').innerHTML = '';
															}
														}
													}).open();
										}
									</script>
									<!-- event detail -->
									<section class="event_detail">
										<div id="eventMap">
											<div id="map" style="width: 80%; height: 400px;">
												<script>
													// default 값
													fullRoadAddr = "서울특별시 금천구 가산디지털2로 123";
													window.onload = mapLoad(fullRoadAddr);

													function mapLoad(fullRoadAddr) {
														
														// 줌 버튼 생성
														var map = new naver.maps.Map(
																'map',
																{
																	zoomControl : true,
																	zoomControlOptions : {
																		position : naver.maps.Position.TOP_RIGHT
																	}
																});
														var myaddress = fullRoadAddr;// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
														naver.maps.Service
																.geocode(
																		{
																			address : myaddress
																		},
																		function(
																				status,
																				response) {
																			if (status !== naver.maps.Service.Status.OK) {
																				return alert(myaddress
																						+ '의 검색 결과가 없거나 기타 네트워크 에러');
																			}
																			var result = response.result;
																			var myaddr = new naver.maps.Point(
																					result.items[0].point.x,
																					result.items[0].point.y);
																			map
																					.setCenter(myaddr); // 검색된 좌표로 지도 이동
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
																							function(
																									e) {
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
													};
												</script>
											</div>
										</div>
									</section>
								</div>
							</fieldset>
						</div>

						<!--  에러시 fieldset.edit_summary 에  .error 넣어주세요-->
						<fieldset class="edit_summary">
							<legend>
								<h3 class="title">
									모임소개 입력<span class="required_txt">(필수)</span>
								</h3>
							</legend>
							<div class="edit">
								<div class="write_wrap">
									<textarea placeholder="모임 내용을 간단히 소개해주세요." name="content"
										required data-parsley-class-handler=".edit_summary"
										data-parsley-required-message="간단한 모임 소개를 입력해주세요."></textarea>
								</div>
							</div>
						</fieldset>
						<fieldset class="edit_summary">
							<legend>
								<h3 class="title">
									정원설정<span class="required_txt">(필수)</span>
								</h3>
							</legend>
							<div class="edit">
								<div class="write_wrap">
									<textarea placeholder="정원설정 해주세요." name="fixed"
										required data-parsley-class-handler=".edit_summary"
										data-parsley-required-message="정원설정 해주세요."
										style="width: 20%"></textarea>
								</div>
							</div>
						</fieldset>
						<fieldset class="edit_summary">
							<legend>
								<h3 class="title">모임소개 이미지</h3>
							</legend>
							<!-- 썸네일 업로드 버튼 -->
							<!-- 파입업로드가 되면 클래스 .upload 붙음 -->
							<input type="file" name="upload" title="모임 사진 업로드">
						</fieldset>
						<!-- 버튼영역 -->
						<div class="bottom_btn_area">
							<div class="btn_wrap">
								<input type="submit" value="개설완료" class="btn_submit">
							</div>
						</div>
					</div>
				</div>
				</form>
			</section>
		</div>
		</main>
	</header>
	<!-- =================================== 화면 고유 시작 ===================================  -->
	<!-- Plugin -->
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.browser.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.selectmenu.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.emailbox.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.timebox.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.ui.doubleDatepicker.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery-ui-autocompleteBox.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.tmpl.min.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.qtip-2.1.1.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.fancybox-1.3.3.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.caret.min.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.tag-editor.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.fileupload.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.fileupload-validate.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/jquery.iframe-transport.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/webeditor/SE2.3.4.O10204/js/HuskyEZCreator.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/parsley.min.js"></script>
	<!-- Script -->
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/jquery.noscroll.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/common/plugins/map2.js"></script>
	<script src="https://static.onoffmix.com/js/pc/dist/common/ko.js"></script>
	<script src="https://static.onoffmix.com/js/pc/dist/event/event-add.js"></script>
	<script
		src="https://static.onoffmix.com/js/pc/dist/event/event-add-parsley.js"></script>
	<!-- =================================== 화면 고유 끝 ===================================  -->

	<script>
			$(".today_page_no").on("click", function(event) {
				var page = $(".today_page_no").attr("rel");
				// console.log(page);
				today_events(page);
			});
			$(".today_page_total").on("click", function(event) {
				var page = $(".today_page_total").attr("rel");
				// console.log(page);
				today_events(page);
			});

			function today_events(page) {
				var page_total = $(".page_total").attr("rel");

				if (page > page_total) {
					return;
				}

				$.ajax({
					crossDomain : true,
					type : 'GET',
					async : true,
					cache : false,
					url : "/event/detail/today_events",
					//data:postDate,

					data : {
						"page" : page,
						"type" : "json",
					},
					dataType : 'json',
					success : function(data) {
						$('.page_now').html(data.page_now);
						$('.event_seen').html(data.today_list);
						$('.today_page_no').attr('rel',
								(parseInt(data.page_now) - 1))
						$('.today_page_total').attr('rel',
								(parseInt(data.page_now) + 1))
						// console.log(data);

					},

				});
			}
		</script>
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
				"applicationTime" : 229,
				"atts" : "SxQDEg1MHh8=",
				"errorBeacon" : "bam.nr-data.net",
				"agent" : ""
			}
		</script>
</body>
</html>

