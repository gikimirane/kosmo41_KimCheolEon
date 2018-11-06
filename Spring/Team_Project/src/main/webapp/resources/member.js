function infoConfirm() {
	if (document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수사항입니다.");
		reg_frm.id.focus();
		return;
	}

	if (document.reg_frm.id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		reg_frm.id.focus();
		return;
	}

	if (document.reg_frm.pw.value.length == 0) {
		alert("비밀번호는 필수사항입니다.");
		reg_frm.pw.focus();
		return;
	}

	if (document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}

	/*
	//	http://ibulkamgodoldol.tistory.com/20
	var UserPassword = document.reg_frm.pw;
	if (UserPassword.value.length < 8) {
		alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
		return false;
	}
	if (!UserPassword.value
			.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
		alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
		return false;
	}
	*/
	/*
	if (document.reg_frm.phone.value.substr(0,3) != "010") {
		alert(document.reg_frm.phone.value.substr(0,3));
		alert("올바른 휴대전화 번호를 입력해주세요");
		reg_frm.id.focus();
		return;
	}
	
	if (document.reg_frm.phone.value.length != 11){
		alert("휴대전화 번호 11 자리를 입력해주세요");
		reg_frm.id.focus();
		return;
	}
	*/

	if (document.reg_frm.name.value.length == 0) {
		alert("이름은 필수사항입니다.");
		reg_frm.name.focus();
		return;
	}

	if (document.reg_frm.eMail.value.length == 0) {
		alert("메일은 필수사항입니다.");
		reg_frm.eMail.focus();
		return;
	}
	
	//document.reg_frm.submit();
	
	//	http://roydest.tistory.com/entry/alert-confirm-prompt
	/* confirm(문자열, 초기값) */
	var check = confirm("입력하신 이메일 주소로 인증메일이 발송됩니다. 계속 하시겠습니까?");
	/* if(check == true) else false */
	if(check){
		alert("이메일을 확인하여 인증을 완료해주세요.");
		document.reg_frm.submit();
	}else 
		alert("취소되었습니다.");
}