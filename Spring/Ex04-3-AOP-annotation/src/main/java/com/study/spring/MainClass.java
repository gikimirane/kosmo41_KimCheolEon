package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext context =
//				new GenericXmlApplicationContext("classpath:beans.xml");
				new GenericXmlApplicationContext("beans.xml");

		// beans.xml 에서 표현식에 의해 Student와 Worker 클래스는
		// JointPoint 로 설정되었기 때문에 해당 클래스의 모든 메서드는 PointCut 지점임.

		// 하단 부분 실행시, 실제로 Student 가 실행되는 것이 아니라
		// logerApp 의 ProceedingJoint -> joint.proceed() 가 실행됨
		Student student = context.getBean("student", Student.class);
		student.getStrudentInfo();

		Worker worker = context.getBean("worker", Worker.class);
		worker.getWorkerInfo();

		// beans 의 advice 지시자 around 에 의해 포인트컷 앞뒤로 기능을 추가할 수 있다.

		context.close();
	}

}
