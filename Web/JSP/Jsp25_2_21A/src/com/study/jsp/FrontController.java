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

		if (command.equals("/JoinOK.do")) {
			System.out.println("JoinOK");
			JoinOK(request, response);
			
		}
		if (command.equals("/LoginOK.do")) {
			System.out.println("LoginOK");
			LoginOK(request, response);
		}
		if (command.equals("/ModifyOK.do")) {
			System.out.println("Modify");
			ModifyOK(request, response);
		}
		if (command.equals("/LogOUT.do")) {
			System.out.println("LogOUT");
			LogOutOK(request, response);
		}
	}
	
	private void JoinOK(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDTO dto = new MemberDTO();
		
//		request.getParameter("id");
//		request.getParameter("pw");
//		request.getParameter("name");
//		request.getParameter("eMail");
//		request.getParameter("address");
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));
		
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		MemberDAO dao = MemberDAO.getInstance();
		
		
		if (dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT) {
			out.println("<script language='javascript'>");
			out.println("alert('아이디가 이미 존재 합니다.');");
			out.println("history.back();");
			out.println("</script>");
		
		} else {
			int ri = dao.insertMember(dto);
			if(ri == MemberDAO.MEMBER_JOIN_SUCCESS){
								
				HttpSession session = request.getSession();
				session.setAttribute("id", dto.getId());
				
				out.println("<script language='javascript'>");
				out.println("alert('회원가입을 축하합니다.');");
				out.println("document.location.href='A03Login.jsp'");
				out.println("</script>");
				
			} else{
				out.println("<script language='javascript'>");
				out.println("alert('회원가입에 실패했습니다.');");
				out.println("document.location.href='A03Login.jsp'");
				out.println("</script>");
			}
		}
		
		out.close();
	}

	private void LoginOK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDAO dao = MemberDAO.getInstance();

		int checkNum = dao.userCheck(id, pw);

		if (checkNum == -1) {
			// html 출력
			/*out.println("<script language=\"javascript\">\r\n" + 
					"    	alert(\"아이디가 존재하지 않습니다.\");\r\n" + 
					"    	history.go(-1);\r\n" + 
					"    </script>");*/
			out.println("<script language='javascript'>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			
		} else if (checkNum == 0) {
			// html 출력
			out.println("<script language='javascript'>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			
		} else if (checkNum == 1) {
			MemberDTO dto = dao.getMember(id);

			if (dto == null) {
				// html 출력
				out.println("<script language='javascript'>");
				out.println("alert('존재하지 않는 회원입니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				
			} else {
				String name = dto.getName();
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("A05Main.jsp");

				// 19장 login 참고
//				HttpSession session = request.getSession();
//				session.setAttribute("name", name);
//				session.setAttribute("id", id);
//				session.setAttribute("pw", pw);
			}
		}
		
		out.close();
	}

	private void ModifyOK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		MemberDTO dto = new MemberDTO();
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		dto.setId(id);
		
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));
		
		MemberDAO dao = MemberDAO.getInstance();
				
		int ri = dao.updateMember(dto);

		if (ri == 1) {
			out.println("<script language='javascript'>");
			out.println("alert('정보가 수정되었습니다.');");
			out.println("document.location.href='A05Main.jsp'");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('정보수정에 실패했습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}
		
		out.close();
	}
	
	private void LogOutOK(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("A03Login.jsp");
		
	}

}
