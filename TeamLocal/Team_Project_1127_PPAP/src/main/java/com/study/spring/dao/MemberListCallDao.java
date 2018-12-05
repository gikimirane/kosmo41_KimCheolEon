package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.GroupManagementDto;

public interface MemberListCallDao {
	public ArrayList<GroupManagementDto> memberList(int numId);
}
