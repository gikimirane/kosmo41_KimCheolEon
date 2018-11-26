package com.study.spring.Joinapply.dao;

import java.util.ArrayList;

import com.study.spring.dto.Joinapply;

public interface JoinapplyDao {
	public ArrayList<Joinapply> memberList(int numId);
}
