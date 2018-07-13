package com.study.pattern04.factory_method2.database;

//<summary>
//B 'ConcreteCreator' class
//</summary>

public class Oracle extends Database {

	public Oracle() {
		name = "Oracle";
		rows = 33;
	}

	// 사실 여기 겁나 복잡한 커넥트.....JSP 기억나지?
	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속했습니다.");
	}
}
