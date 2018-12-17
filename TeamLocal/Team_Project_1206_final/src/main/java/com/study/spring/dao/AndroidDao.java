package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.GroupManagementDto;
import com.study.spring.dto.GroupRunningDto;
import com.study.spring.dto.GroupSignupDto;

public interface AndroidDao {

	// 아이디 로그인 접속확인
	public GroupSignupDto connectionDB(String email);

	// 앱에서 기록저장시 디비에 저장
	public void runningtime(String email, String starttime, String endtime, String move, String upload, String map1,
			String map2, String map3, String map4, String map5);

	public void keyupdate(String token, String email);

	public ArrayList<GroupRunningDto> runningsearch(String email);

	// 정보수정하기
	public void modifyOk(String phone, String email);

}
