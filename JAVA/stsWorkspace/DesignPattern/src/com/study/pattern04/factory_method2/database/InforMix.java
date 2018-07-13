package com.study.pattern04.factory_method2.database;

//<summary>
//C 'ConcreteCreator' class
//</summary>

public class InforMix extends Database {

	public InforMix() {
		name = "InforMix";
		rows = 16;
	}

	// 사실 여기 겁나 복잡한 커넥트.....JSP 기억나지?
	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속했습니다.");
	}
}
