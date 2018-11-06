<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<script src="http://code.jquery.com/jquery.js"></script>

<title>Login</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/sign.css" rel="stylesheet" type="text/css" media="screen">

</head>

<body class="text-center">
	<form action="loginOk.go" class="form-signin" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">id</label> <input
			type="text" name="id" class="form-control"
			placeholder="ID" required="" autofocus=""
			value=""><br>
		<label for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="pw" class="form-control" placeholder="Password"
			required=""><br>
		<p>
		<div class="checkbox mb-3">
			<!-- 
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label> 
			-->
		</div>
		<button class="btn btn-sm btn-primary btn-block" type="submit">로그인</button>
		<a href="join" class="btn btn-sm btn-primary btn-block" type="submit">회원가입</a>
		
		<div id="my-signin2"></div>
	
	    <img id="upic" src=""><br>
	    <span id="uname"></span>
	    </div>

				<p class="mt-5 mb-3 text-muted">© 2018 KOSMO41-TeamProject</p>
		</form>
		


	<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>