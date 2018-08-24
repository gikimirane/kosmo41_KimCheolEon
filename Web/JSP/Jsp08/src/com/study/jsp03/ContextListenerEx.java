package com.study.jsp03;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class ContextListenerEx implements ServletContextListener {

	public ContextListenerEx() {

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed called!!");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized called!!");
	}

}
