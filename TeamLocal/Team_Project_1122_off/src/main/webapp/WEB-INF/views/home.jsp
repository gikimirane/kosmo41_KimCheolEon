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
<title>Home</title>

<%
	String userName = null;
	if(session.getAttribute("ValidMem") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
<!-- 구글 에드센스 -->
<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script>
  (adsbygoogle = window.adsbygoogle || []).push({
    google_ad_client: "ca-pub-7097424074655074",
    enable_page_level_ads: true
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
<link href="resources/web/css/component.css" rel="stylesheet"
	type="text/css" />
<!-- navigation -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
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

<script type="text/javascript">   
   window.onload = function(){ 
       if (location.href.indexOf('reloaded')==-1) location.replace(location.href+'?reloaded'); 
       //if (parent.location.href.indexOf('reloaded')==-1) parent.location.replace(parent.location.href+'?reloaded'); 
   }
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
					<p>강아지는 개의 새끼를 말한다. 갓 태어난 강아지의 체중은 견종에 따라 크게 차이가 나며 소형 견종들은 100~200g, 대형 견종들은 400~500g, 초대형 견종들은 700g 까지 나간다.[1] 강아지는 성체로 발달하는 과정에 있으므로 자라면서 털색이나 체형 등이 달라질 수 있으며 정서적인 변화를 겪기도 한다. </p>
						<p>고양이(cat)는 식육목 고양이과에 속하는 포유류 동물이다. 일반적으로 "고양이"라 함은 인간에게 길들여진 집고양이(domestic cat)를 말한다. 들고양이(wild cat)는 약 10만 년에서 7만 년 전부터 존재했다. 2007년 기준으로 최근의 연구에 따르면 길들여진 고양이의 기원은 약 1만 년 전 근동지방에서 스스로 숲 속을 나와 사람들이 모여사는 마을에 대담하게 정착하여 길들여진 5마리 정도의 아프리카들고양이(Felis silvestris lybica)로 추측된다.</p>

				</div>
				<div class="col-md-6 images">
					<div class="img1">
						<img src="resources/web/images/a1.jpg" class="img-responsive"
							alt="" />
					</div>
					<div class="img2">
						<img src="resources/web/images/a2.jpg" class="img-responsive"
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
					<h4>파충류에대한설명</h4>
					<p>파충류(Reptilia, 爬蟲類)는 용궁류(Sauropsida) 파충강에 속하는 척추동물이다. 린네식 분류법으로 파충류로 분류 되는 동물들을 뜻하며, 공기로 호흡하고, "냉혈(Cold-Blooded)" 물질대사를 하고, 딱딱한 껍질을 갖고 양막(羊膜, amnion, a kind of membrane)을 지닌 알을 낳는다.{태생을 할 경우에도 비슷한 막(membrane)이라는 시스템을 유지한다.}. 피부는 비늘과 껍질로 이루어져있다. 네개의 다리를 지니거나 네발을 지닌 선조에서 유래한 네발동물(영어: Tetrapod)이며, 배(胚, embryo)가 양막이란 막(membrae)에 의해 둘러쌓인 구조인 양막형 알(amniotic eggs)을 낳는다. 현재의 파충류들은 남극을 제외한 모든 대륙에 분포하며, 네 개의 목(order)으로 분류된다. 최근에는 조강과 함께 용궁류의 분기군(Clade)으로 들어간다. 그러나 일반적인 의미의 파충류는 조강을 제외하고, 거북목을 포함한다.</p>
				</div>
				<div class="col-md-6 about-section-grid text-left">
					<h4>양서류에대한설명</h4>
					<p>양서류(兩棲類) 또는 물뭍동물(--動物)은 척삭동물의 한 강으로 개구리와 도롱뇽 등을 포함한다. 양서류는 어류와 파충류의 중간적 위치에 해당한다고 볼 수 있는데, 실제로는 어류에 더 가까우며, 특히 유생 시대에는 형태적으로나 생리적으로 어류와 비슷한 점이 많다. 양서류의 육상 진출은 척추동물의 진화 역사에서 매우 중요한 전환기가 되었다. 그러나 성체는 허파를 가지기는 하였지만 허파 호흡과 거의 같은 양의 산소를 피부 호흡에 의존하기 때문에 언제나 물 가까이에서 생활해야만 하며, 현재에도 대부분의 번식이 물 속에서 이루어진다. 또한 일반적으로 유생 때는 모두 물 속에서 생활하므로 아가미로 호흡하다가, 변태 후에는 허파가 생겨 물과 육지의 양 지역에서 생활한다. 그러나 북아메리카 남부에 사는 사이렌 등과 같이 겉아가미를 잃지 않고 일생을 물 속에서 지내는 것도 있다. 양서류는 대부분 매우 온순하지만, 두꺼비·독화살개구리류 등에서는 독샘(귀샘)이 발달되어 있다. 보통 난생을 하며 번식 습성이 변화된 것도 있다.</p>
				</div>
				<div class="clearfix"></div>
				</div>
		</div>
		<div class="textimonials-section text-center">
			<div class="container">
					<h5>애완동물(愛玩動物, 영어: pet) 또는 반려동물(伴侶動物, 영어: companion animal)</h5>
					<p>인간이 주로 즐거움을 위해 사육하는 동물을 말한다.</p>
					<a href="" class="btn btn-1 btn-1d">Read Testimonials</a>
			</div>
		</div>
	</div>
	<!-- content-section-ends -->
	<div class="main-map">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3166.230275006728!2d126.87673151571332!3d37.47889197981442!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b61e3354204f9%3A0x12b02f6401815f80!2z7ZWc6rWt7IaM7ZSE7Yq47Juo7Ja07J247J6s6rCc67Cc7JuQ!5e0!3m2!1sko!2skr!4v1542247790804"
			width="600" height="450" frameborder="0" style="border: 0"
			allowfullscreen></iframe>
	</div>

	<!-- footer-section-starts -->
	<div class="footer">
		<div class="container">
			<div class="col-md-5 contact-section">
				<h4>Contact Form</h4>
				<input type="text" class="text" value="Name"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Name';}"> <input
					type="text" class="text" value="Email" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Email';}">
				<textarea onfocus="if(this.value == 'Message') this.value='';"
					onblur="if(this.value == '') this.value='Message';">Message</textarea>
				<input type="submit" value="SEND">
			</div>
			<div class="col-md-7 follow-us">
				<h4>Follow Us</h4>
				<div class="social-icons">
					<i class="facebook"></i> <i class="twitter"></i> <i
						class="pinterest"></i> <i class="googlepluse"></i>
				</div>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
					diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
					erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci
					tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
					consequat. Duis autem vel eum iriure dolor</p>
				<div class="copyright">
					<p>
						Design by <a href="http://w3layouts.com"> W3layouts</a>
					</p>
				</div>
			</div>
			<div class="clearfix"></div>
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
                     
                     $().UItoTop({ easingType: 'easeOutQuart' });
                     
                  });
               </script>
	<a href="#" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>

</body>
</html>