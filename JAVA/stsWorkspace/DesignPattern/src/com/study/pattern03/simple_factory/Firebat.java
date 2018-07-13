package com.study.pattern03.simple_factory;

public class Firebat implements Unit {
	
	public Firebat() {
		// TODO Auto-generated constructor stub
		System.out.println("파이어뱃 생성 !!!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("파이어뱃 이동 !!!");

	}

}
