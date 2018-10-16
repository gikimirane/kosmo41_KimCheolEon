package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:/beans.xml");
		
		Student studen1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + studen1.getName());
		System.out.println("나이 : " + studen1.getAge());
		
		System.out.println("------------------------------------------------");
		
		Student studen2 = ctx.getBean("student", Student.class);
		studen2.setName("전우치");
		studen2.setAge(22);
		
		System.out.println("이름 : " + studen1.getName());
		System.out.println("나이 : " + studen1.getAge());
		
		System.out.println("------------------------------------------------");
		
		// 객체가 저장하는 Value 비교
		if(studen1.equals(studen2)) {
			System.out.println("studen1 == student2");
		}else {
			System.out.println("studen1 != student2");
		}
		
		// 객체 자체 비교
		System.out.println(studen1 == studen2);

	}

}
