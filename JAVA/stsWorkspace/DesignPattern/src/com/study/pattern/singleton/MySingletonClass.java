package com.study.pattern.singleton;

public class MySingletonClass {
	
//	public static MySingletonClass sc = new MySingletonClass();
	// 상수와 마찬가지
	private static MySingletonClass sc = null;
	
	//얘를 공통 전역변수로 쓰고자 함
	private int i = 0;
	
	private MySingletonClass() {
		//외부 생성 차단
	}
	
	//다른데서 mySingletonClass.getInstance 로 생길것?
	public static MySingletonClass getInstance() {
		//객체 리턴시켜야한다?
		if(sc == null) {
			sc = new MySingletonClass();
		}
		
		return sc;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
}
