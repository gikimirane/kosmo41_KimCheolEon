package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.GroupManagementDto;
import com.study.spring.dto.GroupRunningDto;
import com.study.spring.dto.GroupSignupDto;

public interface GroupRunningDao {


	// 저장된 기록 출력
	public ArrayList<GroupRunningDto> recordlist(int nStart, int nEnd, String eMail);
	public ArrayList<GroupRunningDto> recordlist0(int nStart, int nEnd, String eMail, String search);

	public int RecordCount(String email);
	public int RecordCount0(String email, String search);
	
	// 기록관리 게시물 상세보기
	public GroupRunningDto recordcheck_view(String startTime);

	// 마이페이지
	public ArrayList<GroupManagementDto> mypagelist(int nStart, int nEnd, String userName);

	public int mypageCount(String userName);
}
