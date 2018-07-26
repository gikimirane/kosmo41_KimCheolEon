package com.study.pattern04.strategy3;

public class MySQL extends Database {

	public MySQL() {
		
		name = "MySQL";
		rows = 20;
	}

	@Override
	public void connectDatabase() {
		//차후에 이 부분 담당자가 바꿔야 할 영역
		System.out.println(name + "에 접속했습니다.");
	}

}
