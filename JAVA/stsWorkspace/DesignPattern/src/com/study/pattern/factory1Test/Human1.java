package com.study.pattern.factory1Test;

public class Human1 implements Interfaces {

	public Human1() {
		// TODO Auto-generated constructor stub
		System.out.println("Human1 등장!!!");
	}

	@Override
	public void eye() {
		// TODO Auto-generated method stub
		System.out.println("눈 입니다.");
	}

	@Override
	public void nose() {
		// TODO Auto-generated method stub
		System.out.println("코 입니다.");

	}

	@Override
	public void mouth() {
		// TODO Auto-generated method stub
		System.out.println("입 입니다.");

	}

}
