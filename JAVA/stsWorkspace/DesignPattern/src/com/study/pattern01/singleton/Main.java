package com.study.pattern01.singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//이거 단독 하나만으로 생성자를 부르기때문에 내부가 실행됨
		ClassOne class1 = new ClassOne();
		
		ClassTwo class2 = new ClassTwo();
	}
}
