package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.GroupJoinDto;
import com.study.spring.dto.GroupManagementDto;
import com.study.spring.dto.GroupManagementcount;

public interface GroupJoinDao {

	// 모임게시판 목록
	public ArrayList<GroupJoinDto> JoinDao(int nStart, int nEnd);
	public ArrayList<GroupJoinDto> JoinDao0(int nStart, int nEnd, String search);

	public int JoinCount();
	public int JoinCount0(String search);

	// 모임게시물 상세보기
	public GroupJoinDto join_view(String strID);

	public void join_check(String numId);

	// 모임게시물 만들기
	public void jmakeDao(String Name, String Title, String Content, String Address, String Upload, String WANTEDSTART,
			String WANTEDEND, String EVENTSTART, String EVENTEND, String fixed);
	public void jmake_join(int numId, String Name, String Email);

	// 모임게시물 삭제하기
	public void join_delete(String numId);
	public void manegement_delete(String numId);

	// 모임게시물 참가신청
	public void Join_join(String numId, String name, String email);

	// 모임게시물 취소하기
	public void Join_cancel(String numId, String name);

	// 모임게시물 참가인원 확인
	public GroupManagementcount joinapplycount(String numId);

	// 모임게시물 중복참가 확인
	public GroupManagementDto joinapply(String numId, String name);
	
	public ArrayList<GroupManagementDto> groupUser(int numId);
	
	public ArrayList<GroupJoinDto> getgroupBoardNumId(String name);

}
