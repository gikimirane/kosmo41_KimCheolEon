<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EYE-TOUCH</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="Login_style.css">
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans:400,600'>
</head>

<body>
<div class="header">
		<img src="teamLogo.png">
	</div>
	<div class="card">
			<main role="main">
			  <button class="popup-trigger btn" id="popup-trigger"><span>이용을 원하세요?<i class="fa fa-plus-square-o"></i></span></button>
			</main>
			<div class="overlay" id="overlay">
			  <div class="overlay-background" id="overlay-background"></div>
			  <div class="overlay-content" id="overlay-content">
			    <div class="fa fa-times fa-lg overlay-close" id="overlay-close"></div>
			    <h1 class="main-heading">EYE-TOUCH</h1>
			    <h3 class="blurb">회원 전용입니다.</h3><span class="blurb-tagline">본인의 계정을 입력하세요.</span>
			    <form class="signup-form" action="loginCheck.jsp" method="post" novalidate="novalidate">
			      <label for="login-id">UserID</label>
			      <input type="text" required="required" name="id" autocomplete="off"/>
			      <label for="login-password">Password</label>
			      <input type="password" required="required" name="password" autocomplete="off"/>
			      <input type="submit" value="Log-in">
			    </form>
					<br>
					<h1 class="main-heading">계정이 없으세요?!</h1>
			    <h3 class="blurb">계정은 가입은 무료입니다.</h3><span class="blurb-tagline">사용하실 아이디와 비밀번호를 등록하세요.</span>
			    <form class="signup-form" action="joinOK.jsp" method="post" novalidate="novalidate">
			      <label for="signup-id">UserID</label>
			      <input id="signup-name" type="text" required="required" name="id" autocomplete="off"/>
			      <label for="signup-password">Password</label>
			      <input id="signup-email" type="password" required="required" name="password" autocomplete="off"/>
			      <label for="signup-phone">Phone Number</label>
			      <input id="signup-cpw" type="text" required="required" name="phone" autocomplete="off"/>
			      <span><input type="submit" value="Register"></span>
			    </form>
			  </div>
			</div>
	  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	    <script src="index.js"></script>
	</div>
</body>
</html>