package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		// 파라미터 있으면 받고 없으면 페이지 1 상태

		HttpSession session = null;
		session = request.getSession();
//		session.setAttribute("curpage", nPage);
		session.setAttribute("cpage", nPage);

		BDao dao = BDao.getInstance();
		ArrayList<BDto> dtos = dao.list(nPage);
//		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos);

//		int curPage = 1;
//		if (session.getAttribute("page") != null) {
//			curPage = (int) session.getAttribute("page");
//		} else {
//			session.setAttribute("page", curPage);
//		}
		
		
		// dto는 아닌데 페이지의 정보에 대한 빈즈가 필요함
		BPageInfo pInfo = dao.articlePage(nPage);
		request.setAttribute("page", pInfo);

	}

}
