package com.study.spring.signup.dao;

import com.study.spring.signup.dto.signupDto;

public interface signupDao {
	public void signup(String eMail, String pw, String name, String phone);
	
//	public void updateSign(String eMail, String eMail2, String sHA256_pw, String name, String phone);
	
	public void updateVerified(String pass, String eMail);

	public signupDto idcheck(String id);
	
}
