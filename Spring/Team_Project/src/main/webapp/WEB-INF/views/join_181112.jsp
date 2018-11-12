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

<script>

// https://firebase.google.com/docs/auth/web/start
// https://firebase.google.com/docs/auth/web/manage-users
function firebaseJoin(){
	firebase.auth().createUserWithEmailAndPassword(
			document.reg_frm.eMail.value,
			SHA256(document.reg_frm.pw.value).toUpperCase()
		).catch(function(error) {
		  	errorCode = error.code;
		  	errorMessage = error.message;
			//console.log('ErrorCode : ' + errorCode);
			//console.log('ErrorMessage : ' + errorMessage);
			
			//유효성 검사가 이미 Java Server 에서 끝나는데, 혹시몰라서 남겨놓음
			switch(errorCode){
				case 'auth/email-already-in-use' :
					alert("이미 연결된 계정입니다. / " + errorMessage);
					break;
				case 'auth/operation-not-allowed' :
					alert("올바른 자격이 아닙니다 / " + errorMessage);
					break;
				case 'auth/invalid-email' :
					alert("올바른 Email 형식이 아닙니다. / " + errorMessage);
					break;
				case 'auth/wrong-password' :
					alert("올바른 패스워드가 아닙니다. / " + errorMessage);
					break;
				case 'email-already-in-use' :
					alert("이미 등록된 Email 입니다. / " + errorMessage);
					break;
			}
			return;		
	});
	
	user = firebase.auth().currentUser;

	firebase.auth().onAuthStateChanged(function (user) {
	    if (user) {
	        if (user.emailVerified == false) {
	        	user.sendEmailVerification().then(function() {
	        		  // Email sent.
	        		  console.log("Email sent...");
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

function idCheck() {
	if (emailCheckState == 0) {
		$.ajax({
			url : 'emailCheck',
			type : 'POST',
			data : 'Ajax_emailCheck=' + document.reg_frm.eMail.value,
			dataType : 'json',
			success : function(json) {
				var result = eval(json);
				// result[0].result
				// NULL - 미입력
				// FAIL - 중복아이디
				// OK - 사용가능한 아이디

				if (result[0].result == "OK") {
					alert(result[0].desc);
					// 트리거 변환 : 회원가입버튼 사용가능
					emailCheckState = 1;
				} else if (result[0].result == "NOPASS") {
					alert(result[0].desc);
					var re_verified = confirm("재인증을 위해 Email을 재발송할까요?");
					if (re_verified) {		
						repw = result[0].pw;		
						reverified();
					} else {
					}
				} else {
					alert(result[0].desc);
				}
			}
		});
	} else {
		alert("이미 확인된 Email 입니다. 회원가입을 진행해주세요.");
	}
}
</script>

<script type="text/javascript">
function reverified(){
	firebase.auth().signInWithEmailAndPassword(document.reg_frm.eMail.value, repw);
	user = firebase.auth().currentUser;
	
	user.sendEmailVerification().then(function() {
		  // Email sent.
			alert("발송 하였습니다.");
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
	
	
	.idcheck-btn {
		text-align: center;
		border-color: #007bff;
		transition: all 0.4s;
	}
	.idcheck-btn:hover {
		background: #007bff;
		opacity: 0.8;
	}
</style>

<script src="http://code.jquery.com/jquery.js"></script>
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
			<a href="#" class="btn btn-primary btn-lg"><i class="fa fa-facebook"></i> Facebook</a>
			<!-- <a href="#" class="btn btn-info btn-lg"><i class="fa fa-twitter"></i> Twitter</a> -->
			<a href="#" class="btn btn-danger btn-lg"><i class="fa fa-google"></i>Google</a>
			<br/>
		</div>
		<div class="or-seperator"><b>or</b></div>
        <div class="form-group" align="right">
        	<input type="email" class="form-control input-lg" name="eMail" placeholder="이메일 주소" required="required" size="20" onchange="emailCheckState=0;">
        	<input type="button" class="btn btn-primary idcheck-btn" name="eMail_check" value="중복확인" onclick="idCheck();">
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
            <input type="button" class="btn btn-success btn-lg btn-block signup-btn" value="회원가입" onclick="emailCheckPass();">
        </div>
    </form>
    <div class="text-center" style="font-size: 20px">Already have an account? <a href="login">Login here</a></div>
</div>

</body>
</html>