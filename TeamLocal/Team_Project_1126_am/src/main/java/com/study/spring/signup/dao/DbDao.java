package com.study.spring.signup.dao;

import java.util.ArrayList;

import com.study.spring.dto.Joinapply;
import com.study.spring.signup.dto.RecordDto;
import com.study.spring.signup.dto.searchDto;
import com.study.spring.signup.dto.signupDto;

public interface DbDao {

	// 아이디 로그인 접속확인
	public signupDto connectionDB(String email);

	// 앱에서 기록저장시 디비에 저장
	public void runningtime(String email, String starttime, String endtime, String move, String upload, String map1,
			String map2, String map3, String map4, String map5);

	public void keyupdate(String token, String email);

	public ArrayList<searchDto> runningsearch(String email);

	// 저장된 기록 출력
	public ArrayList<RecordDto> recordlist(int nStart, int nEnd, String eMail);
	public ArrayList<RecordDto> recordlist0(int nStart, int nEnd, String eMail, String search);

	public int RecordCount(String email);
	public int RecordCount0(String email, String search);
	
	// 기록관리 게시물 상세보기
	public RecordDto recordcheck_view(String startTime);

	// 정보수정하기
	public void modifyOk(String phone, String email);

	// 마이페이지
	public ArrayList<Joinapply> mypagelist(int nStart, int nEnd, String userName);

	public int mypageCount(String userName);
}
