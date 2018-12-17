<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>MY pets</title>

<%
	String userName = null;
	if (session.getAttribute("ValidMem") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<!-- 구글 에드센스 -->
<script async
	src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
	(adsbygoogle = window.adsbygoogle || []).push({
		google_ad_client : "ca-pub-7097424074655074",
		enable_page_level_ads : true
	});
</script>

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

<script type="text/javascript">

</script>
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
					} else {
				%>
				<p class="phonenum">
					<a href="login" style="font-size: 20px; color: white;">로그인</a> 해주세요
				</p>
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
	<!-- header-section-ends -->
	<div class="banner">
		<!----->
		<div class="slider" width="100px" height="100px">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="resources/web/images/3.jpg" alt="" />
						<div class="caption">
							<h2>우리 반려동물을 위한 지식!</h2>                                                                                                                                                     
							<a class="more" href="list">더보기</a>
						</div></li>
					<li><img src="resources/web/images/2.jpg" alt="" />
						<div class="caption">
							<h2>반려동물 주인들끼리 모이자!</h2>
							<a class="more" href="joinlist">더보기</a>
						</div></li>
					<li><img src="resources/web/images/1.jpg" alt="" />
						<div class="caption">
							<h2>반려동물 주인들을 위한 커뮤니티</h2>
							<a class="more" href="/spring">더보기</a>
						</div></li>
				</ul>
			</div>
		</div>
		<!----->
	</div>
	<!-- content-section-starts -->
	<div class="content">
		<div class="welcome-section">
			<div class="container">
				<div class="col-md-6 welcome-grid text-center">
					<h3>환영합니다!</h3>
					<h5>나의 반려동물들과 지역을 함께 !!</h5>
					<p>강아지는 개의 새끼를 말한다. 갓 태어난 강아지의 체중은 견종에 따라 크게 차이가 나며 소형 견종들은
						100~200g, 대형 견종들은 400~500g, 초대형 견종들은 700g 까지 나간다. 강아지는 성체로 발달하는
						과정에 있으므로 자라면서 털색이나 체형 등이 달라질 수 있으며 정서적인 변화를 겪기도 한다.</p>
					<p>고양이(cat)는 식육목 고양이과에 속하는 포유류 동물이다. 일반적으로 "고양이"라 함은 인간에게 길들여진
						집고양이(domestic cat)를 말한다. 들고양이(wild cat)는 약 10만 년에서 7만 년 전부터 존재했다.
						2007년 기준으로 최근의 연구에 따르면 길들여진 고양이의 기원은 약 1만 년 전 근동지방에서 스스로 숲 속을 나와
						사람들이 모여사는 마을에 대담하게 정착하여 길들여진 5마리 정도의 아프리카들고양이(Felis silvestris
						lybica)로 추측된다.</p>

				</div>
				<div class="col-md-6 images">
					<div class="img1">
						<img src="resources/web/images/강아지.jpg" class="img-responsive"
							alt="" />
					</div>
					<div class="img2">
						<img src="resources/web/images/강아지2.jpg" class="img-responsive"
							alt="" />
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="about-section text-center">
			<div class="container">
				<h2>My Pet에 관하여</h2>
				<div class="col-md-6 about-section-grid text-left">
					<h4>포유류에대한설명</h4>
					<p>포유류(哺乳類) 또는 젖먹이 동물, 젖먹이 짐승은 척삭동물문의 한 강인 포유강(Mammalia)에 속하는
						동물을 통틀어 부르는 말이다. 암컷에게는 새끼에게 양분을 공급할 젖을 만들어내는 유선이 있다. 대부분 몸에 털이 나
						있고, 털이 변형된 비늘이나 가시가 있는 것들도 있다. 뇌에서 체온과 혈액 순환을 조절하는 온혈동물이다. 생물 분류
						방법에 따라 차이는 있지만, 29목 153과 1200속 약 5400종에 이르는 동물을 포함한다.</p>
				</div>
				<div class="col-md-6 about-section-grid text-left">
					<h4>포유류에대한특징</h4>
					<p>포유류의 가장 큰 특징은 젖샘이 있어서, 수유를 한다. 물론 다른 소수의 동물에게서도 젖샘과 비슷한 것은 있다.
알을 낳는 단공류를 제외한 모든 포유류는 태생이다. 이것을 기준으로 다시 나누어 태반이 없는, 유대류와, 태반이 있는 유태반류로 다시 나눈다.
포유류 외에도 새끼를 낳는 동물이 몇 있다. 열대어 구피, 바닷물고기 망상어, 망치상어가 대표적이다. 그렇지만 이들은 뱃속에서 알을 부화시켜 새끼를 낳는 난태생이므로, 태생을 하는 포유류와는 다르다. 극소수의 동물 중 실러캔스, 진디등이 태생을 하는데, 이것은 매우 드문 예외이다.
모든 포유류가 온혈동물이기는 하지만 조류나 다랑어류도 마찬가지이므로, 이것만으로는 포유류의 정의로 적합하지 않다.
보통은 털로 덮여있으나 유린목은 털이 비늘로 변화하였고, 단공목의 한 종류인 가시두더지와 고슴도치목의 고슴도치는, 털이 가시로 변해 있다. 모든 포유류 - 영장류, 특히 인간-는 두뇌의 의존도가 크고 신체에 비해 커다란 두뇌를 가지고 있다. 예를 들어 같은 크기의 파충류와 비교할 때 포유류의 두뇌는 파충류의 약 네 배에 달한다. 6500만년 전 소행성의 충돌로 공룡이 멸종한 뒤 포유류가 번성했을 때 초기 종들이 야행성이었던 탓에 시각만이 아니라 촉각, 후각, 청각 등의 감각으로 전해지는 정보를 처리하기 위해 더 큰 두뇌가 필요했다. 예를 들면 침팬지는 시각보다 청각적 정보를 통해 추론을 이끌어내는 데 더 능하다.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- content-section-ends -->
		<div class="main-map">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3166.230275006728!2d126.87673151571332!3d37.47889197981442!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b61e3354204f9%3A0x12b02f6401815f80!2z7ZWc6rWt7IaM7ZSE7Yq47Juo7Ja07J247J6s6rCc67Cc7JuQ!5e0!3m2!1sko!2skr!4v1542247790804"
				width="600" height="450" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
		<div class="textimonials-section text-center">
			<div class="container">
				<h5>애완동물(愛玩動物, 영어: pet) 또는 반려동물(伴侶動物, 영어: companion animal)</h5>
				<p>인간이 주로 즐거움을 위해 사육하는 동물을 말한다.</p>
				<a href="" class="btn btn-1 btn-1d">Read Testimonials</a>
			</div>
		</div>
	</div>

	<!-- footer-section-ends -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
			     containerID: 'toTop', // fading element id
			   containerHoverID: 'toTopHover', // fading element hover id
			   scrollSpeed: 1200,
			   easingType: 'linear' 
			 };
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>

</body>
</html>