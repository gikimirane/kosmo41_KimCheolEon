package com.study.pattern.factory1;

public class Marine implements Unit {
	
	//Marine Ctrl+space constructor
	public Marine() {
		// TODO Auto-generated constructor stub
		System.out.println("마린 생성 !!!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("마린 이동 !!!");
	}

}
