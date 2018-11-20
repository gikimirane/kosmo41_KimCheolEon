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
	
	String main = request.getParameter("start");
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
				<p class="phonenum"><%=userName %> 님 안녕하세요</p>
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
	<!-- header-section-ends -->
	<div class="banner">
		<!----->
		<div class="slider" width="100px" height="100px">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="resources/web/images/3.jpg" alt="" />
						<div class="caption">
							<h2>Until one has loved an animal a part of one's soul
								remains unawakened.</h2>
							<a class="more" href="#">READ MORE</a>
						</div></li>
					<li><img src="resources/web/images/2.jpg" alt="" />
						<div class="caption">
							<h2>A dog is the only thing on earth that loves you more
								than you love yourself.</h2>
							<a class="more" href="#">READ MORE</a>
						</div></li>
					<li><img src="resources/web/images/1.jpg" alt="" />
						<div class="caption">
							<h2>Money can buy you a fine dog, but only love can make him
								wag his tail.</h2>
							<a class="more" href="#">READ MORE</a>
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
					<h3>Welcome</h3>
					<h5>Duis autem vel eum iriure dolor in hendrerit in vulputa</h5>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud
						exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea
						commodo consequat.</p>
					<p>Claritas est etiam processus dynamicus, qui sequitur
						mutationem consuetudium lectorum. Mirum est notare quam littera
						gothica, quam nunc putamus parum claram Claritas est etiam
						processus dynamicus, qui sequitur mutationem consuetudium
						lectorum. littera gothica.</p>
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
				<h2>About</h2>
				<div class="col-md-6 about-section-grid text-left">
					<h4>Mirum est notare quam littera</h4>
					<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation
						ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
						consequat. Duis autem vel eum iriure dolor in hendrerit in
						vulputate velit esse molestie consequat, vel illum dolore eu
						feugiat nulla facilisis at vero eros et accumsan et iusto odio</p>
				</div>
				<div class="col-md-6 about-section-grid text-left">
					<h4>Mirum est notare quam littera</h4>
					<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation
						ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
						consequat. Duis autem vel eum iriure dolor in hendrerit in
						vulputate velit esse molestie consequat, vel illum dolore eu
						feugiat nulla facilisis at vero eros et accumsan et iusto odio</p>
				</div>
				<div class="clearfix"></div>
				<a href="about.html" class="btn btn-1 btn-1c">read more</a>
			</div>
		</div>
		<div class="textimonials-section text-center">
			<div class="container">
				<img src="resources/web/images/t.png" alt="" />
				<h5>Claritas est etiam processus dynamicus, qui sequitur
					mutationem consuetudium lectorum. Mirum est notare quam littera
					gothica, quam nunc putamus parum claram</h5>
				<p>Duis autem vel eum iriure dolor</p>
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