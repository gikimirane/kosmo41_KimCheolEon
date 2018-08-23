package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hserv")
public class HelloServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
//    public helloServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
//		System.out.println("Hello Servlet! <br>Hello Servlet!!! <br>");
		out.println("Hello Servlet!!<br> From Apach!!!!");
		System.out.println("Test Message");
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
