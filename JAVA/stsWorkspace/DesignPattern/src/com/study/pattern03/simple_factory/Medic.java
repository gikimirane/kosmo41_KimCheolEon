package com.study.pattern03.simple_factory;

public class Medic implements Unit {
	
	public Medic() {
		// TODO Auto-generated method stub
		System.out.println("메딕 생성 !!!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("메딕 이동 !!!");
	}

}
