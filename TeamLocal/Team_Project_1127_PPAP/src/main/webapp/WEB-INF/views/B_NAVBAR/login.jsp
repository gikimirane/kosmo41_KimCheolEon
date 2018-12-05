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

<title>MY pets</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/sign.css" rel="stylesheet" type="text/css" media="screen">

<script src="http://code.jquery.com/jquery.js"></script>

<script language="JavaScript" src="resources/member.js"></script>

<script src="https://www.gstatic.com/firebasejs/5.5.7/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.5.7/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyDdmIGAdjx_x464LjmOCxtrjO-RuwzgBr8",
    authDomain: "kosmo-teamproject-aee81.firebaseapp.com",
    databaseURL: "https://kosmo-teamproject-aee81.firebaseio.com",
    projectId: "kosmo-teamproject-aee81",
    storageBucket: "kosmo-teamproject-aee81.appspot.com",
    messagingSenderId: "383919202732"
  };
  firebase.initializeApp(config);
</script>

</head>

<script type="text/javascript">

function loginAccess(){
	
	firebase.auth().signInWithEmailAndPassword(
			document.login_frm.email.value,
			SHA256(document.login_frm.pw.value).toUpperCase()
			).then(function(){				
				user = firebase.auth().currentUser;
				
				if(user.emailVerified == false){
					alert("이메일 미인증 상태입니다.");
					
				} else {
					alert("이메일 인증이 완료된 상태입니다.");
					updateVerifySessionName();
					window.location.href = "/spring";
				}
			}).catch(function(error) {
			  	// Handle Errors here.
			  	errorCode = error.code;
			  	errorMessage = error.message;
			  	// ...
			  	alert('code:' + error.code + '\n[message]\n' + error.message);
			 	return;
			});
}

function enterkey() {
    if (window.event.keyCode == 13) {
    	loginAccess();
    }
}

function updateVerifySessionName(){
	$.ajax({
		url : 'updateVerify',
		type : 'POST',
		data : 'Ajax_updateEmail=' + document.login_frm.email.value + "&userName=" + user.displayName,
		dataType : 'json',
		success : function(json) {
			var result = eval(json);

			if (result[0].result == "OK") {
				alert(result[0].desc);
			} else {
				alert(result[0].desc);
			}
		}
	});
}

</script>

<body class="text-center">
	<form action="loginOk" class="form-signin" method="post" name="login_frm">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">id</label> <input
			type="text" name="email" class="form-control"
			placeholder="Email" required="" autofocus=""
			value=""
			onkeyup="enterkey();"><br>
		<label for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="pw" class="form-control" placeholder="Password"
			required=""
			onkeyup="enterkey();"><br>
		<p>
		<div class="checkbox mb-3">
			<!-- 
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label> 
			-->
		</div>
		<!-- <button class="btn btn-sm btn-primary btn-block" type="submit">로그인</button> -->
		<input class="btn btn-sm btn-primary btn-block" type="button" value="로그인" onclick="loginAccess();"/>
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