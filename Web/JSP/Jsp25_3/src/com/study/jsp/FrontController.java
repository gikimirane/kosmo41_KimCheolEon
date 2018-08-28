package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/FrontController")
@WebServlet("*.do")

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");

		System.out.println("actionDo called!");

		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);

		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);

		///////////////////////////////////////////////////////

//		MemberDTO dto = new MemberDTO();
//		MemberDAO dao = MemberDAO.getInstance();

		///////////////////////////////////////////////////////

		Service service = null;
		if (command.equals("/JoinOK.do")) {
			System.out.println("JoinOK");
//			Service service = new JoinOK();
			service = new JoinOK();
			service.execute(request, response);

		}
		if (command.equals("/LoginOK.do")) {
			System.out.println("LoginOK");
//			Service service = new LoginOK();
			service = new LoginOK();
			service.execute(request, response);
		}
		if (command.equals("/ModifyOK.do")) {
			System.out.println("Modify");
//			Service service = new ModifyOK();
			service = new ModifyOK();
			service.execute(request, response);
		}
		if (command.equals("/LogOUT.do")) {
			System.out.println("LogOUT");
			LogOutOK(request, response);
		}
	}

	private void LogOutOK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("A03Login.jsp");

	}

}
