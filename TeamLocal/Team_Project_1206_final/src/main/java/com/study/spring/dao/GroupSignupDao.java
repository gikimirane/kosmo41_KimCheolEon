package com.study.spring.dao;

import com.study.spring.dto.GroupSignupDto;

public interface GroupSignupDao {
	public void signup(String eMail, String pw, String name, String phone);
	
//	public void updateSign(String eMail, String eMail2, String sHA256_pw, String name, String phone);
	
	public void updateVerified(String pass, String eMail);

	public GroupSignupDto idcheck(String id);
	
	public GroupSignupDto tokenGet(String userName);
	
}
