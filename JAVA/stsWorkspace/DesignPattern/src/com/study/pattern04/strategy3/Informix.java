package com.study.pattern04.strategy3;

public class Informix extends Database {

	public Informix() {
		
		name = "MySQL";
		rows = 40;
	}

	@Override
	public void connectDatabase() {
		//차후에 이 부분 담당자가 바꿔야 할 영역
		System.out.println(name + "에 접속했습니다.");
	}

}
