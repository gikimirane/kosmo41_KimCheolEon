package com.study.spring.signup.dao;

import com.study.spring.signup.dto.signupDto;

public interface signupDao {
	public void singup(String id, String pw, String name, String phone, String eMail);

	public signupDto idcheck(String id);
}
