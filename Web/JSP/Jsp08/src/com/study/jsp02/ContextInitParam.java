package com.study.jsp02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextInitParam")
public class ContextInitParam extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doGet Method");
		
		String database = getServletContext().getInitParameter("database");
		String connect = getServletContext().getInitParameter("connect");
		String path2 = getServletContext().getInitParameter("path2");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + database + "<br>");
		writer.println("비밀번호 : " + connect + "<br>");
		writer.println("path2 : " + path2 + "<br>");
		writer.println("</body></html>");
	}

}
