package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOK implements Service {

	public LoginOK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDAO dao = MemberDAO.getInstance();

		int checkNum = dao.userCheck(id, pw);

		if (checkNum == -1) {
			// html 출력
			/*
			 * out.println("<script language=\"javascript\">\r\n" +
			 * "    	alert(\"아이디가 존재하지 않습니다.\");\r\n" + "    	history.go(-1);\r\n" +
			 * "    </script>");
			 */
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

}
