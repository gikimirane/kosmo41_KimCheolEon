package com.study.spring.signup.dao;

import com.study.spring.signup.dto.signupDto;

public interface signupDao {
	public void singup(String eMail, String pw, String name, String phone);

	public signupDto idcheck(String id);
}
