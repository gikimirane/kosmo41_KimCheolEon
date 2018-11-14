
/////////////////////////////////////////////////////////////////////////////////////////////////
// Initialize Firebase
var config = {
	apiKey : "AIzaSyDdmIGAdjx_x464LjmOCxtrjO-RuwzgBr8",
	authDomain : "kosmo-teamproject-aee81.firebaseapp.com",
	databaseURL : "https://kosmo-teamproject-aee81.firebaseio.com",
	projectId : "kosmo-teamproject-aee81",
	storageBucket : "kosmo-teamproject-aee81.appspot.com",
	messagingSenderId : "383919202732"
};
firebase.initializeApp(config);

/////////////////////////////////////////////////////////////////////////////////////////////////


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

/////////////////////////////////////////////////////////////////////////////////////////////////

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
  
/////////////////////////////////////////////////////////////////////////////////////////////////
  
//https://firebase.google.com/docs/auth/web/start
//https://firebase.google.com/docs/auth/web/manage-users
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

/////////////////////////////////////////////////////////////////////////////////////////////////

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

/////////////////////////////////////////////////////////////////////////////////////////////////

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