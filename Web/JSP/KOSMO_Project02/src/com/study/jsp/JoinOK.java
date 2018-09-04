package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JoinOK implements Service {

	public JoinOK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		MemberDTO dto = new MemberDTO();

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
			if (ri == MemberDAO.MEMBER_JOIN_SUCCESS) {

				HttpSession session = request.getSession();
				session.setAttribute("id", dto.getId());

				out.println("<script language='javascript'>");
				out.println("alert('회원가입을 축하합니다.');");
				out.println("document.location.href='A03Login.jsp'");
				out.println("</script>");

			} else {
				out.println("<script language='javascript'>");
				out.println("alert('회원가입에 실패했습니다.');");
				out.println("document.location.href='A03Login.jsp'");
				out.println("</script>");
			}
		}

		out.close();

	}

}
