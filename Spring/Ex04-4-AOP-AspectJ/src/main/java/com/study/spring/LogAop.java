package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	@Pointcut("bean(*ker)")
	private void pointcutMethod() {
	}

	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint jointpoint) throws Throwable {
		String signatureStr = jointpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");

		long st = System.currentTimeMillis();

		try {
			Object obj = jointpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();

			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}
	
	@Before("pointcutMethod()")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}

}
