package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.BPageInfo;
import com.study.spring.dto.ContentDto;

public interface IDao {
	public ArrayList<ContentDto> listDao(int nStart, int nEnd);

	public int articleCount();

	public void writeDao(String bName, String bTitle, String bContent);

	public ContentDto content_view(String strID);

	public void modify_view(String bName, String bTitle, String bContent, int bId);

	public void reply_view(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent);

	public void upHit(String bId);

	public void deleteDao(String bId);
}
