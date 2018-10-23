package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;

public interface IDao {
	public ArrayList<ContentDto> listDao();

	public void writeDao(String bName, String bTitle, String bContent);

	public ContentDto content_view(String bId);

	public void modify(String bName, String bTitle, String bContent, int bId);

	public void deleteDao(String bId);

	public ContentDto reply_view(String bId);

	public void reply(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent);

	public void replyShape(String strGroup, String strStep);

	public void upHit(String bId);
}
