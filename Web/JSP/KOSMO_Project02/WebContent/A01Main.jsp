<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.study.jsp.google.*"%>
<!DOCTYPE html>
<html>
<head>
<title>KOSMO Project02-Main</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="448134969775-n2cpnokuosg0kjcvbk2m90cota6o5beq.apps.googleusercontent.com">
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>

<script>
	var ggID;
	var ggName;
	var ggImageURL;
	var ggEmail;
	var queryStringIN = "";
	var queryStringOUT = "";
	<%
		if(session.getAttribute("ggID") == null) {
	%>
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log('ID: ' + profile.getId());
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());

		ggID = profile.getId();
		ggName = profile.getName();
		ggImageURL = profile.getImageUrl()
		ggEmail = profile.getEmail();
		queryStringIN = "ggID=" + ggID + "&ggName=" + ggName + "&ggImageURL="
				+ ggImageURL + "&ggEmail=" + ggEmail;

		/* alert(queryString); */

		$('#my-signin2').css('display', 'none');
		$('#logout').css('display', 'block');
		$('#upic').attr('src', profile.getImageUrl());
		$('#uname').html('[ ' + profile.getName() + ' ]');

		/* localStorage.setItem("loginID",profile.getId()); */
		/* 		sessionStorage.setItem("loginID", profile.getId());
		 alert(sessionStorage.getItem('loginID')); */
		/* alert(ggID);
		alert(ggName);
		alert(ggImageURL);
		alert(ggEmail); */
		login_submit_ajax();
	}
	<%
		}
	%>
	
	function onFailure(error) {
		alert("접속 중 에러가 발생하였습니다.");
	}
	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function() {
			console.log('User signed out.');

			$('#my-signin2').css('display', 'block');
			$('#logout').css('display', 'none');
			$('#upic').attr('src', '');
			$('#uname').html('');

			/* localStorage.removeItem("loginID"); */
			/* sessionStorage.removeItem("loginID"); */
			logout_submit_ajax();
		});
	}
	
	$(document).ready(function() {
		/* alert("로딩완료"); */
	});
	

	var auth2; // The Sign-In object.
	var googleUser; // The current user.

	/**
	 * Calls startAuth after Sign in V2 finishes setting up.
	 */
	var appStart = function() {
	  gapi.load('auth2', initSigninV2);
	};

	/**
	 * Initializes Signin v2 and sets up listeners.
	 */
	var initSigninV2 = function() {
	  auth2 = gapi.auth2.init({
	      client_id: 'CLIENT_ID.apps.googleusercontent.com',
	      scope: 'profile'
	  });

	  // Listen for sign-in state changes.
	  auth2.isSignedIn.listen(signinChanged);

	  // Listen for changes to current user.
	  auth2.currentUser.listen(userChanged);

	  // Sign in the user if they are currently signed in.
	  if (auth2.isSignedIn.get() == true) {
	    auth2.signIn();
	  }

	  // Start with the current live values.
	  refreshValues();
	};

	/**
	 * Listener method for sign-out live value.
	 *
	 * @param {boolean} val the updated signed out state.
	 */
	var signinChanged = function (val) {
	  console.log('Signin state changed to ', val);
	  document.getElementById('signed-in-cell').innerText = val;
	};

	/**
	 * Listener method for when the user changes.
	 *
	 * @param {GoogleUser} user the updated user.
	 */
	var userChanged = function (user) {
	  console.log('User now: ', user);
	  googleUser = user;
	  updateGoogleUser();
	  document.getElementById('curr-user-cell').innerText =
	    JSON.stringify(user, undefined, 2);
	};

	/**
	 * Updates the properties in the Google User table using the current user.
	 */
	var updateGoogleUser = function () {
	  if (googleUser) {
	    document.getElementById('user-id').innerText = googleUser.getId();
	    document.getElementById('user-scopes').innerText =
	      googleUser.getGrantedScopes();
	    document.getElementById('auth-response').innerText =
	      JSON.stringify(googleUser.getAuthResponse(), undefined, 2);
	  } else {
	    document.getElementById('user-id').innerText = '--';
	    document.getElementById('user-scopes').innerText = '--';
	    document.getElementById('auth-response').innerText = '--';
	  }
	};

	/**
	 * Retrieves the current user and signed in states from the GoogleAuth
	 * object.
	 */
	var refreshValues = function() {
	  if (auth2){
	    console.log('Refreshing values...');

	    googleUser = auth2.currentUser.get();

	    document.getElementById('curr-user-cell').innerText =
	      JSON.stringify(googleUser, undefined, 2);
	    document.getElementById('signed-in-cell').innerText =
	      auth2.isSignedIn.get();

	    updateGoogleUser();
	  }
	}

	/*************************************************************/

	function login_submit_ajax() {
		$.ajax({
			url : 'acclogin.do',
			type : 'POST',
			data : queryStringIN,
			dataType : 'json',
			success : function(json) {
				var result = eval(json);
				if (result[0].result == "ok") {
					/* alert("setOK"); */
				} else {
					alert(result[0].desc);
				}
			}
		})
	}

	function logout_submit_ajax() {
		$.ajax({
			url : 'acclogout.do',
			type : 'POST',
			data : queryStringOUT,
			dataType : 'json',
			success : function(json) {
				var result = eval(json);
				if (result[0].result == "ok") {
					alert("delOK");
				} else {
					alert(result[0].desc);
				}
			}
		})
	}
</script>




</head>
<body>
	<div class="container-fluid bg-primary">
		<h3>Cheol-Eon Kim's Record</h3>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Portfolio</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="A01Main.jsp">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="list.do">WebBoard</a></li>
					<li><a href='#'
						onclick='javascript:window.open("http://www.naver.com","name99", "width=500px,height=650px,left=100px,top=100px");'>testNaver</a></li>
				</ul>


				<ul class="nav navbar-nav navbar-right">
					<div id="login" class="g-signin2" data-onsuccess="onSignIn"></div>

					<div id="logout" style="display: none;">
						<input type="button" onclick="signOut();" value="로그아웃" /><br>

						<img id="upic" src=""><br> <span id="uname"></span>
					</div>
				</ul>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class="container bg-3 text-center">
			<h1>My Portfolio</h1>
			<p>Some text that represents "Me"...</p>
		</div>
	</div>
	<div class="container-fluid bg-3 text-center">
		<div class="row">
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
		</div>
	</div>
	<br>

	<div class="container-fluid bg-3 text-center">
		<div class="row">
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
			<div class="col-sm-3">
				<p>Some text..</p>
				<img src="https://placehold.it/150x80?text=IMAGE"
					class="img-responsive" style="width: 100%" alt="Image">
			</div>
		</div>
	</div>
	<br>
	<br>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>
