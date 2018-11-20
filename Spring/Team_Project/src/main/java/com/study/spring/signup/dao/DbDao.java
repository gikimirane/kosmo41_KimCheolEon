package com.study.spring.signup.dao;

import com.study.spring.signup.dto.signupDto;

public interface DbDao {
	public signupDto connectionDB(String email);
	
	public void runningtime(String email, String starttime, String endtime, String move, String upload);
}
