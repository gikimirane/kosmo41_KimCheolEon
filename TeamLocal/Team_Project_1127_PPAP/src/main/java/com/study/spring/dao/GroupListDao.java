package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.GroupListDto;
import com.study.spring.dto.GroupReplyDto;

public interface GroupListDao {
	// 일반게시판 목록
	public ArrayList<GroupListDto> listDao(int nStart, int nEnd);

	public ArrayList<GroupListDto> listDao0(int nStart, int nEnd, String search);

	public ArrayList<GroupListDto> listDao1(int nStart, int nEnd, String search);

	public ArrayList<GroupListDto> listDao2(int nStart, int nEnd, String search);

	public ArrayList<GroupListDto> listDao3(int nStart, int nEnd, String search);

	public int articleCount();

	public int articleCount0(String search);

	public int articleCount1(String search);

	public int articleCount2(String search);

	public int articleCount3(String search);

	// 일반게시물 상세보기
	public GroupListDto content_view(String strID);

	// 일반게시판 댓글기능
	public void content_reply(String numId, String name, String content);
	public ArrayList<GroupReplyDto> content_reply_view(String numId);
	public GroupReplyDto idcheck(String numId);

	// 댓글 삭제기능
	public void reply_delete(String numId);	
	
	public void writeDao(String bName, String bTitle, String bContent);

	public void modify_view(String bName, String bTitle, String bContent, int bId);

	public void reply_view(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent);

	public void upHit(String bId);

	public void deleteDao(String bId);

}
