package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		
//		String configLocation = "classpath:beans.xml";
		
		// 1. 스프링 설정이 클래스패스 루트가 아닌 다른 곳에 위치한다.
		// 루트를 기준으로 경로 형식 입력
//		String configLocation = "classpath:config/beans.xml";
//		String configLocation = "classpath:/config/beans.xml";
//		동일함
		
		// 2. 클래스패스가 아닌 파일시스템에서 설정파일을 읽어 오기
//		String configLocation = "file:src/main/resources/beans.xml";
		
		// 3. 특정 경로에 있는 모든 xml 파일을 설정파일로 사용하고 싶은 경우
//		String configLocation = "classpath:/beans*.xml";
		
		// 4. IoC 컨테이너 생성
//		GenericXmlApplicationContext context = 
//				new GenericXmlApplicationContext(configLocation);
//		ApplicationContext context = 
//				new GenericXmlApplicationContext(configLocation);
		
		// 4. 1개 이상의 설정 파일 경로를 값으로 전달 가능 : 가변 인자 형태
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:/beans.xml",
				"classpath:config/beans2.xml");
		
		
		// 2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
		// 3. PrinterB Bean 가져오기
//		Printer printer = context.getBean("printerB", Printer.class);
//		hello.setPrinter(printer);
//		hello.print();
		
//		context.close();
//		https://stackoverflow.com/questions/14423980/how-to-close-a-spring-applicationcontext
		((GenericXmlApplicationContext)context).close();
	}
}
