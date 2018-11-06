<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
<script language="JavaScript" src="resources/member.js"></script>

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
function test(){
firebase.auth().createUserWithEmailAndPassword('kchy1234@naver.com', 'coffee').catch((error) => {
    console.log('code:' + error.code + 'message' + error.message);
});
firebase.auth().onAuthStateChanged(function (user) {
    if (user) {
        if (user.emailVerified == false) {
            user.sendEmailVerification().then(() => {
                console.log('sent email');
            }, (error) => {
                console.log('code:' + error.code + 'message' + error.message);
            });
        }
    } else {  }

});
}
</script>

</head>
<body>

	<form action="joinOK" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" size="20"><br>
		비밀번호 : <input type="password" name="pw" size="20"><br>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
		이름 : <input type="text" name="name" size="20"><br>
		메일 : <input type="text" name="eMail" size="20"><br>
		<input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="로그인" onclick="javascript:window.location='login'">
	</form>
	<input type="button" onClick="test()" value="tt">


</body>
</html>