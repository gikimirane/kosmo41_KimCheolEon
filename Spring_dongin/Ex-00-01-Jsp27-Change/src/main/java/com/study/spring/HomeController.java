package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.dao.IDao;
import com.study.spring.dto.BPageInfo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	int listCount = 10;
	int pageCount = 10;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model) {
		System.out.println("/list()");
		
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		}catch (Exception e) {
		}
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int nTotalPage = dao.articleCount();
		BPageInfo pinfo = articlePage(nPage, nTotalPage);
		
		model.addAttribute("page",pinfo);
		
		nPage = pinfo.getCurPage();
		
		int nStart = (nPage - 1) * listCount +1;
		int nEnd = (nPage - 1) * listCount + listCount;
		
		model.addAttribute("list",dao.listDao(nStart, nEnd));
		
		return "/list";
	}
	
	@RequestMapping("/write_view")
	public String writeForm() {
		
		return "/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("bName"),request.getParameter("bTitle"),request.getParameter("bContent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view",dao.content_view(request.getParameter("bId")));
		
		return "/content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view",dao.content_view(request.getParameter("bId")));
		
		return "/modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify_view( request.getParameter("bName") ,request.getParameter("bTitle") ,request.getParameter("bContent"),Integer.parseInt(request.getParameter("bId")));
		model.addAttribute("content_view",dao.content_view(request.getParameter("bId")));
		return "/content_view";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("reply_view",dao.content_view(request.getParameter("bId")));
		
		return "/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bStep = Integer.parseInt(request.getParameter("bStep")+1);
		int bIndent = Integer.parseInt(request.getParameter("bIndent")+1); 
		dao.reply_view( request.getParameter("bName") ,request.getParameter("bTitle") ,
		request.getParameter("bContent"),Integer.parseInt(request.getParameter("bGroup")),bStep,bIndent);
		
		return "redirect:list";
	}
	
	public BPageInfo articlePage(int curPage, int nTotalCount) {
		// 총 페이지 수
		int totalPage = nTotalCount / listCount;
		if (nTotalCount % listCount > 0)
			totalPage++;

		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;

		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;

		BPageInfo pinfo = new BPageInfo();
		pinfo.setTotalCount(nTotalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(myCurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}
}
