
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
	  		
	  		var profile = googleUser.getBasicProfile();
	  		
//	  		console.log("ID: " + profile.getId()); // Don't send this directly to your server!
//	        console.log('Full Name: ' + profile.getName());
//	        console.log('Given Name: ' + profile.getGivenName());
//	        console.log('Family Name: ' + profile.getFamilyName());
//	        console.log("Image URL: " + profile.getImageUrl());
//	        console.log("Email: " + profile.getEmail());
	  
	  		alert("구글 계정 호출");
	  		joinType = 1;
	  		
	  		document.reg_frm.eMail.setAttribute("disabled", true);
			document.reg_frm.name.setAttribute("disabled", true);
			
			document.reg_frm.eMail.value = "";
			document.reg_frm.name.value = "";
			document.reg_frm.eMail.value = profile.getEmail();
			document.reg_frm.name.value = profile.getName();

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

function kakaoSignIn(authObj) {
    //console.log(authObj);
	Kakao.API.request({
        url: '/v2/user/me',
        success: function(res) {
            console.log(res);

//            console.log(res.id.properties.nickname);
//           	alert(res.id.properties.kakao_account.email);
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