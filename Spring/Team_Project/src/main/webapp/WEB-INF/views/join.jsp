<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Join</title>

<script language="JavaScript" src="resources/member.js"></script>
<script src="resources/naveridlogin_js_sdk_2.0.0.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>


<!-- FireBase 초기화 Script -->
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
  console.log("Object : " + element.id);
  auth2.attachClickHandler(element, {},
      function(googleUser) {
	  		
	  		alert("메일인증이 생략되었습니다. 회원가입을 진행해주세요.");
	  		joinType = 1;
	  		signOut();
            
      }, function(error) {
        //alert(JSON.stringify(error, undefined, 2));
        console.log(JSON.stringify(error, undefined, 2));
      });
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
    	console.log("구글 로그아웃");
    });
}
</script>


<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '289612378561007',
      cookie     : true,
      xfbml      : true,
      version    : 'v3.1'
    });

    FB.getLoginStatus(function(response) {
    	console.log(response);
      statusChangeCallback(response);
    });
  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  function statusChangeCallback(response) {
    if (response.status === 'connected') {
      getINFO();
    } 
  }
	  
  function fbLogin () {
    FB.login(function(response){
      statusChangeCallback(response);
    }, {scope: 'public_profile, email'});
    console.log("fbLoginJson : " + JSON.stringify(response));
  }

  function fbLogout () {
    FB.logout(function(response) {
      statusChangeCallback(response);
    });
  }

  function getINFO() {
    FB.api('/me?fields=id,name,picture.width(100).height(100).as(picture_small)', function(response) {
      console.log(response);
      
      if(response != null){
    	alert("확인되었습니다. 이메일 인증을 생략합니다. \n회원가입을 진행해주세요.");
    	joinType = 1;
    	fbLogout();
      }     
      
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
			} else{
				joinType = 0;
				
				emailNotSendsignUp();				
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
//https://firebase.google.com/docs/auth/web/start
function emailNotSendsignUp(){
	firebase.auth().signInWithEmailAndPassword(document.reg_frm.eMail.value, SHA256(document.reg_frm.pw.value).toUpperCase());
	
	
	firebase.auth().onAuthStateChanged(function(user) {
		  if (user) {
		    var uid = user.uid;
		    // ...
		    
		    $.ajax({
				url : 'firebaseAdmin',
				type : 'POST',
				data : 'uid=' + uid + "&displayName=" + document.reg_frm.name.value,
				dataType : 'json',
				success : function(json) {
					var result = eval(json);
					console.log(result[0].result+"\n"+result[0].desc);
				}
			});
		  } else {
		    // User is signed out.
		    // ...
		    alert("Error or Signed Out...");
		  }
	});	
	
	document.reg_frm.submit();
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
	
	//페이지가 로딩된 후 실행해야 되는 코드를 추가한다.
	/* window.onload=function(){
	    
	} */
</script>


</head>
<body>

	<div class="signup-form">
    <form action="joinOK" method="post" name="reg_frm">
		<h2>회원 가입</h2>
		<p class="hint-text">Sign up with your social media account or email address</p>
		<div class="social-btn text-center">
      		<a href="javascript:void(0);" id="googleSignIn"><img src="resources/logo/google.png" width=64px height=64px"></a>
      		<!-- signOut(); -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick="fbLogin();"><img src="resources/logo/facebook.png" width=64px height=64px"></a>
			<!-- fbLogout(); -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0);" id="naverIdLogin"></a>
			<script type="text/javascript">
				var naverLogin = new naver.LoginWithNaverId(
					{
						clientId: "N6E4tO46bXuqCKpVOWzX",
						callbackUrl: "http://localhost:8081/spring/join",
						isPopup: false, /* 팝업을 통한 연동처리 여부 */
						loginButton: {color: "green", type: 1, height: 60} /* 로그인 버튼의 타입을 지정 */
					}
				);
				
				/* 설정정보를 초기화하고 연동을 준비 */
				naverLogin.init();
				
				window.addEventListener('load', function () {
					naverLogin.getLoginStatus(function (status) {
						if (status) {
							/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고
							   사용자 정보를 출력합니다. */
							   alert("로그인 true");
							setLoginStatus();
						}
						naverLogin.logout();
					});
				});
				
				function setLoginStatus() {
					console.log(naverLogin.user);
					var uid = naverLogin.user.getId();
					var profileImage = naverLogin.user.getProfileImage();
					var uName = naverLogin.user.getName();
					var nickName = naverLogin.user.getNickName();
					var eMail = naverLogin.user.getEmail();
					
					alert("eMail : " + eMail);
					
			
				}
			</script>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:loginWithKakao()"><img src="resources/logo/kakao.png" width=64px height=64px"></a>
			<a href="http://developers.kakao.com/logout"></a>
		    <script type='text/javascript'>
			  //<![CDATA[
			    // 사용할 앱의 JavaScript 키를 설정해 주세요.
			    Kakao.init('7250fe59c67796c065d918c7499d5b5f');
			    function loginWithKakao() {
			      // 로그인 창을 띄웁니다.
			      Kakao.Auth.login({
			        success: function(authObj) {
			          alert(JSON.stringify(authObj));
			        },
			        fail: function(err) {
			          alert(JSON.stringify(err));
			        }
			      });
			    };
			  //]]>
			</script>
		</div>
		<br/>

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