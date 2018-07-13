package com.study.pattern02.strategy3;

public class Oracle extends Database {

	public Oracle() {
		
		name = "Oracle";
		rows = 10;
	}

	@Override
	public void connectDatabase() {
		//차후에 이 부분 담당자가 바꿔야 할 영역
		System.out.println(name + "에 접속했습니다.");
	}

}
