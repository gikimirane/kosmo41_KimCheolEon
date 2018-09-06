package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.*;

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

		System.out.println("actionDo called!");

		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		BCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("command : " + com);

		Service service = null;

		HttpSession session = null;
		session = request.getSession();
		int curPage = 1;
		if (session.getAttribute("cpage") != null) {
			curPage = (int) session.getAttribute("cpage");
		}

		if (com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";

		} else if (com.equals("/write.do")) {
			command = new BWriteCommamd();
			command.execute(request, response);
			viewPage = "list.do";

		} else if (com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";

		} else if (com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";

		} else if (com.equals("/modify_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";

		} else if (com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);

//			문서를 수정한다음에 자기 페이지로 돌아가야하는데, 파라미터를 받으면서 가야함
			command = new BContentCommand();
			command.execute(request, response);
//			"content_view.do" 로 쏴도 비슷하긴 한데, 조금 다름
//			viewPage = "content_view.do";
			viewPage = "content_view.jsp";

		} else if (com.equals("/delete.do")) {
			System.out.println("curPage : " + curPage);
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;

		} else if (com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";

		} else if (com.equals("/reply.do")) {
			System.out.println("curPage : " + curPage);
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;

		}
		/////////////////////////////////////////////////////
		
		else if (com.equals("/search.do")) {
			command = new BSearchCommand();
			command.execute(request, response);
			viewPage = "list2_search.jsp";
		}else if (com.equals("/list2_search.do")) {
			command = new BSearchCommand();
			command.execute(request, response);
			viewPage = "list2_search.jsp";
		}
		
		////////////////////////////////////////////////////////////////////

		if (com.equals("/JoinOK.do")) {
			System.out.println("JoinOK");
			service = new JoinOK();
			service.execute(request, response);
//			viewPage = 
		}
		if (com.equals("/LoginOK.do")) {
			System.out.println("LoginOK");
			service = new LoginOK();
			service.execute(request, response);
		}
		if (com.equals("/ModifyOK.do")) {
			System.out.println("Modify");
			service = new ModifyOK();
			service.execute(request, response);
		}
		if (com.equals("/LogOUT.do")) {
			System.out.println("LogOUT");
			LogOutOK(request, response);
		}

//		여기가 로그인때는 필요없는데 null 교체되서 죽는 부분
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	private void LogOutOK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("A03Login.jsp");

	}

}
