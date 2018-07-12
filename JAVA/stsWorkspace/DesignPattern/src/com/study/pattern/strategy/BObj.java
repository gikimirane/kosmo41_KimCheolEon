package com.study.pattern.strategy;

public class BObj {
	
	AInterface ainter;
	
	public BObj() {
		// TODO Auto-generated constructor stub
		ainter = new AImplements();
	}
	
	public void SomeFunc() {
		// TODO Auto-generated method stub
		
		// 다음 기능이 필요합니다 ㅠㅠ 만들어주세요
		// 이렇게 기능 구현을 위임 - Delegate 했다
//		System.out.println("AAA");
//		System.out.println("AAA");
//		System.out.println("AAA");
//		System.out.println("AAA");
		
		//Delegate 사용
		ainter.funcA();
		ainter.funcA();
		ainter.funcA();
		ainter.funcA();
	}

}
