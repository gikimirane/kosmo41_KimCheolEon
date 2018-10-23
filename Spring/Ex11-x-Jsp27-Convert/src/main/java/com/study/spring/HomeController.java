package com.study.spring;

import java.text.DateFormat;
import java.util.ArrayList;
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
import com.study.spring.dto.ContentDto;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/list")
	public String list(Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		model.addAttribute("list", dao.listDao());

		return "list";
	}

	@RequestMapping("/write_view")
	public String writeForm() {

		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.writeDao(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.upHit(request.getParameter("bId"));

		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "content_view";
	}

	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "modify_view";
	}

	@RequestMapping("/modify")
	public String modify_confirm(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.modify(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bId")));

		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "content_view";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.deleteDao(request.getParameter("bId"));

		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);

		model.addAttribute("reply_view", dao.reply_view(request.getParameter("bId")));

		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		
//		int bId = Integer.parseInt(request.getParameter("bId"));
		int bGroup = Integer.parseInt(request.getParameter("bGroup"));
		int bStep = Integer.parseInt(request.getParameter("bStep"))+1;
		int bIndent = Integer.parseInt(request.getParameter("bIndent"))+1;
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.reply(bName, bTitle, bContent, bGroup, bStep, bIndent);

		return "redirect:list";
	}

}
