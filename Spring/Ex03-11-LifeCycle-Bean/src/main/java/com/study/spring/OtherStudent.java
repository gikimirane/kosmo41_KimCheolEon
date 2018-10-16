package com.study.spring;

import javax.annotation.*;

public class OtherStudent {

	private String name;
	private int age;

	public OtherStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// import javax.annotation.*;
	// import 단축키로 안올라감	
	
	// Construct 후에
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherStudent : initMethod()");
	}

	// Destroy 전에
	@PreDestroy
	public void destroyMethod() {
		System.out.println("OtherStudent : destroyMethod()");
	}

}
