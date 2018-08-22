package com.study.jsp;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleEx")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
	public LifeCycleEx() {
		super();
		System.out.println("생성");
	}

	// Override 되고있음.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Test : init()");
	}

	public void destroy() {
		System.out.println("Test : destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Test : doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("Test : doPost()");
	}
	
	//////////////////////////////////////////////////////////////////////////////
	// 수동으로 추가했음
	
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("Test : initPostConstruct()");
	}
	
	@PreDestroy
	private void destroyPreDestroy() {
		System.out.println("Test : destroyPreDestroy()");
	}
	

}
