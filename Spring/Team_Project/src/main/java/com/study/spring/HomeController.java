package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.study.spring.dto.ContentDto;
import com.study.spring.signup.dao.signupDao;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	int listCount = 10;
	int pageCount = 10;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/join")
	public String join() {
		return "/join";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list()");

		session = request.getSession();
		int nPage = 1;

		try {
			if (request.getParameter("page") != null) {
				String sPage = request.getParameter("page");
				nPage = Integer.parseInt(sPage);
			} else {
				if (session.getAttribute("cpage") != null) {
//					nPage = Integer.parseInt((String) session.getAttribute("cpage"));
					nPage = (Integer) session.getAttribute("cpage");
				}
			}
		} catch (Exception e) {
		}

		IDao dao = sqlSession.getMapper(IDao.class);

		int nTotalPage = dao.articleCount();
		BPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		// 현재 페이지를 임의로 최대보다 크게, 최소보다 작게 넣을 수 있으므로
		// 체크된 값을 사용한다
		nPage = pinfo.getCurPage();
		session.setAttribute("cpage", nPage);

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		model.addAttribute("list", dao.listDao(nStart, nEnd));

		return "/list";
	}

	@RequestMapping("/write_view")
	public String writeForm() {

		return "/write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");

		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(bName, bTitle, bContent);

		session = request.getSession();
		session.setAttribute("cpage", 1);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "/content_view";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));

		return "redirect:list";
	}

	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "/modify_view";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bId")));
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));
		return "/content_view";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("reply_view", dao.content_view(request.getParameter("bId")));

		return "/reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bStep = Integer.parseInt(request.getParameter("bStep") + 1);
		int bIndent = Integer.parseInt(request.getParameter("bIndent") + 1);
		dao.reply_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bGroup")), bStep, bIndent);

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

		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage)
			endPage = totalPage;

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

	@RequestMapping("joinOK")
	public String joinOK(HttpServletRequest request, HttpServletResponse response, Model model) {

		System.out.println("joinOK()");

//		String pw = request.getParameter("pw");

		SHA256 sha256 = new SHA256();
		String SHA256_pw = sha256.getSHA256(request.getParameter("pw")).toUpperCase();

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");

//		System.out.println("pw : " + pw);
		System.out.println("SHA256_pw : " + SHA256_pw);
		System.out.println("name : " + name);
		System.out.println("phone : " + phone);
		System.out.println("eMail : " + eMail);

		signupDao signupdao = sqlSession.getMapper(signupDao.class);
		
//		try {
//			signupdao.signup(eMail, SHA256_pw, name, phone);
//		} catch (Exception e) {
//			// TODO: handle exception
//			signupdao.updateSign(eMail, eMail, SHA256_pw, name, phone);
//		}
		
		signupdao.signup(eMail, SHA256_pw, name, phone);
		return "redirect:login";
//		}

	}
}