package com.study.jsp05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("Hello World!!");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		System.out.println();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>2018년 8월 21일 18시 08분...... </h1>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();

	}

}

