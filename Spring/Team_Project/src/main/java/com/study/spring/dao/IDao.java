package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;
import com.study.spring.dto.JoinDto;
import com.study.spring.dto.Joinapply;
import com.study.spring.dto.Joinapplycount;

public interface IDao {
	// 일반게시판 목록
	public ArrayList<ContentDto> listDao(int nStart,int nEnd);
	public int articleCount();
	
	// 일반게시물 상세보기
	public ContentDto content_view(String strID);
		
	
	// 모임게시판 목록
	public ArrayList<JoinDto> JoinDao(int nStart,int nEnd);
	public int JoinCount();
	
	// 모임게시물 상세보기
	public JoinDto join_view(String strID);
	
	// 모임게시물 만들기
	public void jmakeDao(String Name, String Title, String Content, String Address, String Upload, String WANTEDSTART, String WANTEDEND, String EVENTSTART, String EVENTEND, String fixed);
	public void jmake_join(String Name);
	
	// 모임게시물 삭제하기
	public void join_delete(String numId);
	
	// 모임게시물 참가신청
	public void Join_join(String numId, String name);
	
	// 모임게시물 참가인원 확인
	public Joinapplycount joinapplycount(String numId);
	
	// 모임게시물 중복참가 확인
	public Joinapply joinapply(String numId,String name);
	
	public void writeDao(String bName,String bTitle,String bContent);
	public void modify_view(String bName, String bTitle, String bContent,int bId);
	public void reply_view(String bName,String bTitle,String bContent,int bGroup,int bStep,int bIndent);
	public void upHit(String bId);
	public void deleteDao(String bId);
	
}
