package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifyOK implements Service {

	public ModifyOK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
