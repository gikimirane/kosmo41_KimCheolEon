<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Join</title>

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

<script src="http://code.jquery.com/jquery.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
<script src="https://apis.google.com/js/api:client.js"></script>
<script>
var googleUser = {};
var startApp = function() {
  gapi.load('auth2', function(){
    // Retrieve the singleton for the GoogleAuth library and set up the client.
    auth2 = gapi.auth2.init({
      client_id: '659512930101-so4q2ljivbse86q2pmmm0ln7b27lk51p.apps.googleusercontent.com',
      cookiepolicy: 'single_host_origin',
      // Request scopes in addition to 'profile' and 'email'
      //scope: 'additional_scope'
    });
    attachSignin(document.getElementById('googleSignIn'));
  });
};

function attachSignin(element) {
  console.log(element.id);
  auth2.attachClickHandler(element, {},
      function(googleUser) {
            console.log(googleUser.getBasicProfile().getId());
            console.log(googleUser.getBasicProfile().getName());
            console.log(googleUser.getBasicProfile().getImageUrl());
            console.log(googleUser.getBasicProfile().getEmail());
            
            document.getElementByID("")
      }, function(error) {
        alert(JSON.stringify(error, undefined, 2));
      });
}
</script>

<script>

// https://firebase.google.com/docs/auth/web/start
// https://firebase.google.com/docs/auth/web/manage-users
function firebaseJoin(){
	firebase.auth().createUserWithEmailAndPassword(
			document.reg_frm.eMail.value,
			SHA256(document.reg_frm.pw.value).toUpperCase()
		).then(function(){
			console.log("firebase createUser complete");
			
			if(joinType == 0){
				sendEmail();	
			}
						
		}).catch(function(error) {
		  	errorCode = error.code;
		  	errorMessage = error.message;
			//console.log('ErrorCode : ' + errorCode);
			//console.log('ErrorMessage : ' + errorMessage);
			
			//유효성 검사가 이미 Java Server 에서 끝나는데, 혹시몰라서 남겨놓음
			switch(errorCode){
				case 'auth/operation-not-allowed' :
					alert("올바른 자격이 아닙니다\n" + errorMessage);
					break;
				case 'auth/invalid-email' :
					alert("올바른 Email 형식이 아닙니다.\n" + errorMessage);
					break;
				case 'auth/wrong-password' :
					alert("올바른 패스워드가 아닙니다.\n" + errorMessage);
					break;
				case 'auth/email-already-in-use' :
					alert("이미 등록된 Email 입니다.\n" + errorMessage);
					
					var re_verified = confirm("이메일 인증을 재 시도 할까요?")
					if(re_verified){
						reverified();
					} else {
					}
					
					break;
				default :
					alert("에러가 발생하였습니다.\n관리자에게 연락해주세요.");
			}
			return;		
	});
}

function sendEmail(){
	user = firebase.auth().currentUser;
	
	user.updateProfile({
		  displayName: document.reg_frm.name.value,
		}).then(function() {
		  // Update successful.
		}).catch(function(error) {
		  // An error happened.
		});

	firebase.auth().onAuthStateChanged(function (user) {
	    if (user) {
	        if (user.emailVerified == false) {
	        	user.sendEmailVerification().then(function() {
	        		  // Email sent.
	        		  console.log("Email sent...");
	        		  alert("인증 메일 발송 완료");
	        		  
	        		  document.reg_frm.submit();
	        		  
	        		}).catch(function(error) {
	        		  // An error happened.
	        			console.log('code:' + error.code + '\n[message]\n' + error.message);
	        			alert('code:' + error.code + '\n[message]\n' + error.message);
	        		});
	        }
	    } else {
	    	
	    }
	});
}

</script>

<script type="text/javascript">
function reverified(){
	firebase.auth().signInWithEmailAndPassword(document.reg_frm.eMail.value, SHA256(document.reg_frm.pw.value).toUpperCase());
	user = firebase.auth().currentUser;
	
	user.sendEmailVerification().then(function() {
		  // Email sent.
			alert("발송 하였습니다.");
		  
			window.location.href = "login";
		}).catch(function(error) {
		  // An error happened.
		});			
	
	firebase.auth().signOut().then(function() {
		  // Sign-out successful.
		}).catch(function(error) {
		  // An error happened.
		});
}

</script>

<script type="text/javascript">
function loginFacebook(){
	var provider = new firebase.auth.FacebookAuthProvider();
	
	// https://developers.facebook.com/docs/facebook-login/permissions
	provider.addScope('email');
	
	firebase.auth().signInWithPopup(provider).then(function(result) {
		  // This gives you a Facebook Access Token. You can use it to access the Facebook API.
		  var token = result.credential.accessToken;
		  // The signed-in user info.
		  var user = result.user;
		  // ...
		}).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  // The email of the user's account used.
		  var email = error.email;
		  // The firebase.auth.AuthCredential type that was used.
		  var credential = error.credential;
		  // ...
		});
}


</script>

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	body {
		background: #dfe7e9;
		font-family: 'Roboto', sans-serif;
	}
    .form-control {
		font-size: 16px;
		transition: all 0.4s;
		box-shadow: none;
	}
	.form-control:focus {
        border-color: #5cb85c;
    }
    .form-control, .btn {
        border-radius: 50px;
		outline: none !important;
    }
	.signup-form {
		width: 480px;
    	margin: 0 auto;
		padding: 30px 0;
	}
    .signup-form form {
		border-radius: 5px;
    	margin-bottom: 20px;
        background: #fff;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 40px;
    }
	.signup-form a {
		color: #5cb85c;
	}    
	.signup-form h2 {
		text-align: center;
		font-size: 34px;
		margin: 10px 0 15px;
	}
	.signup-form .hint-text {
		color: #999;
		text-align: center;
		margin-bottom: 20px;
	}
	.signup-form .form-group {
		margin-bottom: 20px;
	}
    .signup-form .btn {        
        font-size: 18px;
		line-height: 26px;
        font-weight: bold;
		text-align: center;
    }
	.signup-btn {
		text-align: center;
		border-color: #5cb85c;
		transition: all 0.4s;
	}
	.signup-btn:hover {
		background: #5cb85c;
		opacity: 0.8;
	}
    .or-seperator {
        margin: 50px 0 15px;
        text-align: center;
        border-top: 1px solid #e0e0e0;
    }
    .or-seperator b {
        padding: 0 10px;
		width: 40px;
		height: 40px;
		font-size: 16px;
		text-align: center;
		line-height: 40px;
		background: #fff;
		display: inline-block;
        border: 1px solid #e0e0e0;
		border-radius: 50%;
        position: relative;
        top: -22px;
        z-index: 1;
    }
    .social-btn .btn {
		color: #fff;
        margin: 10px 0 0 15px;
		font-size: 15px;
		border-radius: 50px;
		font-weight: normal;
		border: none;
		transition: all 0.4s;
    }	
	.social-btn .btn:first-child {
		margin-left: 0;
	}
	.social-btn .btn:hover {
		opacity: 0.8;
	}
	.social-btn .btn-primary {
		background: #507cc0;
	}
	.social-btn .btn-info {
		background: #64ccf1;
	}
	.social-btn .btn-danger {
		background: #df4930;
	}
	.social-btn .btn i {
		float: left;
		margin: 3px 10px;
		font-size: 20px;
	}
	
	
</style>

<script>
	/* $( document ).ready(function() {
	    alert( "ready!" );
	}); */
</script>


</head>
<body>

	<div class="signup-form">
    <form action="joinOK" method="post" name="reg_frm">
		<h2>회원 가입</h2>
		<p class="hint-text">Sign up with your social media account or email address</p>
		<div class="social-btn text-center">
			<!-- <a href="javascript:void(0);" class="btn btn-primary btn-lg" onclick=""><i class="fa fa-facebook"></i>Facebook</a>
			<a href="#" class="btn btn-primary btn-lg"><i class="fa fa-facebook"></i> Facebook</a>
			<a href="#" class="btn btn-info btn-lg"><i class="fa fa-twitter"></i> Twitter</a>
			<a href="#" class="btn btn-danger btn-lg"><i class="fa fa-google"></i>Google</a>
			<a href="javascript:void(0);" class="btn btn-danger btn-lg" onclick="loginGoogle();"><i class="fa fa-google"></i>Google</a> -->
      		<a href="javascript:void(0);" id="googleSignIn"><img src="resources/logo/google.png" width=64px height=64px"></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick=""><img src="resources/logo/facebook.png" width=64px height=64px"></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick=""><img src="resources/logo/naver.png" width=64px height=64px"></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick=""><img src="resources/logo/kakao.png" width=64px height=64px"></a>
			<br/>
		</div>
		<div class="or-seperator"><b>or</b></div>
        <div class="form-group" align="right">
        	<input type="email" class="form-control input-lg" name="eMail" placeholder="이메일 주소" required="required" size="20">
        </div>
        <div class="form-group">
            <input type="password" class="form-control input-lg" name="pw" placeholder="비밀번호" required="required" size="20">
        </div>
		<div class="form-group">
            <input type="password" class="form-control input-lg" name="pw_check" placeholder="비밀번호 확인" required="required" size="20">
        </div>
        <div class="form-group">
        	<input type="text" class="form-control input-lg" name="name" placeholder="이름" required="required" size="10">
        </div>
        <div class="form-group">
        	<input type="text" class="form-control input-lg" name="phone" placeholder="휴대전화 번호(번호만)" required="required" maxlength="11" 
        		onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
        </div>  
        <div class="form-group">
            <input type="button" class="btn btn-success btn-lg btn-block signup-btn" value="회원가입" onclick="infoConfirm();">
        </div>
    </form>
    <div class="text-center" style="font-size: 20px">Already have an account? <a href="login">Login here</a></div>
</div>
<div id="name"></div>
<script>startApp();</script>
</body>
</html>