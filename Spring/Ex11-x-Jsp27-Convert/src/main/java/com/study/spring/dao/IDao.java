package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.BDto;

public interface IDao {
	public ArrayList<BDto> listDao();

	public void writeDao(String mWriter, String mContent);

	public BDto viewDao(String strID);

	public void deleteDao(String bId);
}
