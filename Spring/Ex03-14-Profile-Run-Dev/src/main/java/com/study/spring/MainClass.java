package com.study.spring;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String config = null;
		Scanner scan = new Scanner(System.in);
		String str = scan.next();

		if (str.equals("dev")) {
			config = "dev";
		} else if (str.equals("run")) {
			config = "run";
		}
		scan.close();

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.getEnvironment().setActiveProfiles(config);
		
		// src/main/resources 가 classpath 의 root 위치
		// 위치 지정 안해도 .load 할때 default 로 불러옴
		// classpath:beans.xml  했었던거.
		context.load("beans_dev.xml", "beans_run.xml");

		ServerInfo info = context.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());

		context.close();
	}

}
