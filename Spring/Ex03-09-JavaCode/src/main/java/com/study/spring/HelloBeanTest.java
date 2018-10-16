package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {

		// 1. IoC 컨테이너 생성
//		ApplicationContext context = 
//				new GenericXmlApplicationContext(configLocation);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		// 2. Hello Bean 가져오기
		Hello helloA = (Hello) context.getBean("hello");
		helloA.print();

		// 3. Hello Bean 가져오기
		Hello helloB = (Hello) context.getBean("hello1");
		helloB.print();

		// 4. PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		helloA.setPrinter(printer);
		helloA.print();

		// 5. 싱글톤인지 확인
		// new 가 서로 달라서 다른 객체 - false
		System.out.println(helloA == helloB);

		context.close();
//		https://stackoverflow.com/questions/14423980/how-to-close-a-spring-applicationcontext
//		((GenericXmlApplicationContext) context).close();
	}
}
