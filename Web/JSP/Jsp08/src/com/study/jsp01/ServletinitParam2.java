package com.study.jsp01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ServletinitParam2")
@WebServlet(urlPatterns = { "/ServletinitParam2" }, 
initParams = { 
		@WebInitParam(name = "id", value = "abcdef"),
		@WebInitParam(name = "pw", value = "12341234"), 
		@WebInitParam(name = "path", value = "C:\\java\\SourcTree") })
public class ServletinitParam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet Method");

		request.setCharacterEncoding("UTF-8");

		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();

		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br>");
		writer.println("비밀번호 : " + pw + "<br>");
		writer.println("path : " + path + "<br>");
		writer.println("</body></html>");
	}

}
