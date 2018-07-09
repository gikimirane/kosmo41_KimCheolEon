package com.study.pattern.singleton;

public class ClassOne {
	
	//생성자 밖에서 만들었더니 syso 오류남. 최소한 생성자안에서 해야함
	public ClassOne() {
		//new 로 만들면 안됨. 내가 만드는게 아니라 가져가야함
		//이제 getInstance 를 부르면 i 는 어디든지 공용으로 쓸 수 있음
		MySingletonClass single = MySingletonClass.getInstance();
		System.out.println("ClassOne");
		int num = single.getI();
		System.out.println(num);
		
		single.setI(200);
		System.out.println("i = " + single.getI());	
	}
}
