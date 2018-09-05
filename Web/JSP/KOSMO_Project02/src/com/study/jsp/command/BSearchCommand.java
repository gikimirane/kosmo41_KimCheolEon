package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BSearchCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("BSearchCommand 진입!!");
		
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		// 파라미터 있으면 받고 없으면 페이지 1 상태
		
		String select = request.getParameter("select");
		String word = request.getParameter("word");
		
//		System.out.println(select);
//		System.out.println(word);
		
		BDao dao = BDao.getInstance();
		
		// dto는 아닌데 페이지의 정보에 대한 빈즈가 필요함
		BPageInfo pInfo = dao.search_articlePage(nPage, select, word);
		request.setAttribute("page", pInfo);
		request.setAttribute("select", select);
		request.setAttribute("word", word);
		
		
		nPage = pInfo.getCurPage();
			
		HttpSession session = null;
		session = request.getSession();
//		session.setAttribute("curpage", nPage);
		session.setAttribute("cpage", nPage);
		session.setAttribute("select", select);
		session.setAttribute("word", word);

		
//		ArrayList<BDto> dtos = dao.list(nPage);
//		ArrayList<BDto> dtos = dao.list();
		ArrayList<BDto> dtos2 = dao.searchList(nPage, select, word);
		request.setAttribute("list", dtos2);
	}

}
