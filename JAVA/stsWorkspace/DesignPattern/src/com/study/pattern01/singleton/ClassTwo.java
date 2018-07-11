package com.study.pattern01.singleton;

public class ClassTwo {

	//ClassOne 과 동일
	public ClassTwo() {
		
		MySingletonClass single = MySingletonClass.getInstance();
		System.out.println("ClassTwo");
		
		System.out.println("i = " + single.getI());	
	}

}
