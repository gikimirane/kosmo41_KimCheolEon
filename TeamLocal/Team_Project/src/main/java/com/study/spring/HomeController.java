package com.study.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.spring.dao.IDao;
import com.study.spring.dto.BPageInfo;
import com.study.spring.dto.CPageInfo;
import com.study.spring.dto.ContentDto;
import com.study.spring.dto.JoinDto;
import com.study.spring.signup.dao.DbDao;
import com.study.spring.signup.dao.signupDao;
import com.study.spring.signup.dto.signupDto;

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
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 로그인
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout() {
		return "/logout";
	}

	// 정보수정
	@RequestMapping("/mem_modify")
	public String mem_modify() {
		return "/modify";
	}

	// 회원가입
	@RequestMapping("/join")
	public String join() {
		return "/join";
	}

	// 기록관리 게시판 글상세 페이지
	@RequestMapping("/recordcheck_view")
	public String recordcheck_view(HttpServletRequest request, Model model) {
		DbDao dao = sqlSession.getMapper(DbDao.class);
		model.addAttribute("recordcheck_view", dao.recordcheck_view(request.getParameter("startTime")));

		return "/recordcheck_view";
	}

	// 기록관리 게시판 리스트
	@RequestMapping("/recordcheck")
	public String recordcheck(HttpServletRequest request, Model model) {
		DbDao dao = sqlSession.getMapper(DbDao.class);

		int listCount = 9;
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}

		String email = (String) session.getAttribute("email");
		// String email = "test@test";

		int nTotalPage = dao.RecordCount(email);
		CPageInfo pinfo = JoinPage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		System.out.println(email);
		System.out.println(nStart);
		System.out.println(nEnd);

		model.addAttribute("recordlist", dao.recordlist(nStart, nEnd, email));

		return "/recordcheck";
	}

	// 모임게시판

	// 모임게시판 페이징처리
	@RequestMapping("/joinlist")
	public String joinlist(HttpServletRequest request, Model model) {
		int listCount = 9;
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		IDao dao = sqlSession.getMapper(IDao.class);

		int nTotalPage = dao.JoinCount();
		CPageInfo pinfo = JoinPage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		model.addAttribute("clublist", dao.JoinDao(nStart, nEnd));

		return "/joinlist";
	}

	// 모임게시판 상세페이지
	@RequestMapping("/join_view")
	public String join_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);

		model.addAttribute("joinapplycount", dao.joinapplycount(request.getParameter("numId")));
		model.addAttribute("join_view", dao.join_view(request.getParameter("numId")));

		String name = "123";
		JoinDto joindto = dao.join_view(request.getParameter("numId"));
		try {
			HttpSession session = request.getSession();
			session.setAttribute("makerName", joindto.getName());
		} catch (Exception e) {

		}

		return "/join_view";
	}

	// 모임게시물 만들기 페이지 이동
	@RequestMapping("/jmake_view")
	public String jmake_view(HttpServletRequest request, Model model) {
		return "/jmake_view";
	}

	// 모임게시물 만들기 시행 (SQL시행)
	@RequestMapping("/jmake")
	public String jmake(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);

		String path = request.getRealPath("resources/image");

		int size = 1024 * 1024 * 10; // 10MB
		String file = "";
		String oriFile = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();

			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);

			// 모집시작 날짜 + 시간
			String WANTEDSTART = (multi.getParameter("JoinStart_date") + " " + multi.getParameter("JoinStart_time"));
			// 모집종료 날짜 + 시간
			String WANTEDEND = (multi.getParameter("JoinEnd_date") + " " + multi.getParameter("JoinEnd_time"));
			// 접수시작 날짜 + 시간
			String EVENTSTART = (multi.getParameter("Start_date") + " " + multi.getParameter("Start_time"));
			// 접수종료 날짜 + 시간
			String EVENTEND = (multi.getParameter("End_date") + " " + multi.getParameter("End_time"));
			String name = "홍길동";
			dao.jmakeDao(name, multi.getParameter("title"), multi.getParameter("content"),
					multi.getParameter("address"), file, WANTEDSTART, WANTEDEND, EVENTSTART, EVENTEND,
					multi.getParameter("fixed"));
			dao.jmake_join(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:joinlist";
	}

	// 일반게시판

	// 글쓰기
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);

		String path = request.getRealPath("resources/image");

		int size = 1024 * 1024 * 10; // 10MB
		String file = "";
		String oriFile = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();

			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);
			dao.writeDao(multi.getParameter("bName"), multi.getParameter("bTitle"), multi.getParameter("bContent"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}

	// 글상세 페이지
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		ContentDto contetdto = dao.content_view(request.getParameter("bId"));
		try {
			HttpSession session = request.getSession();
			session.setAttribute("content_view_makerName", contetdto.getbName());
		} catch (Exception e) {

		}

		return "/content_view";
	}

	// 글목록 페이징처리
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		IDao dao = sqlSession.getMapper(IDao.class);

		int nTotalPage = dao.articleCount();
		BPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		model.addAttribute("list", dao.listDao(nStart, nEnd));

		return "/list";
	}

	// 글 작성페이지로 이동
	@RequestMapping("/write_view")
	public String writeForm() {

		return "/write_view";
	}

	// 글 삭제하기
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));

		return "redirect:list";
	}

	// 글 수정하기 페이지
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "/modify_view";
	}

	// 글 수정하기 액션(DB추가)
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bId")));
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));
		return "/content_view";
	}

	// 답글 달기 페이지
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("reply_view", dao.content_view(request.getParameter("bId")));

		return "/reply_view";
	}

	// 답글 달기액션(DB추가)
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		int bStep = Integer.parseInt(request.getParameter("bStep") + 1);
		int bIndent = Integer.parseInt(request.getParameter("bIndent") + 1);
		dao.reply_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bGroup")), bStep, bIndent);

		return "redirect:list";
	}

	// 일반게시판 페이징처리
	public BPageInfo articlePage(int curPage, int nTotalCount) {
		// �� ������ ��
		int totalPage = nTotalCount / listCount;
		if (nTotalCount % listCount > 0)
			totalPage++;

		// ���� ������
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;

		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

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

	// 모임게시판 페이징처리
	public CPageInfo JoinPage(int curPage, int nTotalCount) {
		// �� ������ ��
		int listCount = 9;
		int pageCount = 9;
		int totalPage = nTotalCount / listCount;
		if (nTotalCount % listCount > 0)
			totalPage++;

		// ���� ������
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;

		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;

		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage)
			endPage = totalPage;

		CPageInfo pinfo = new CPageInfo();
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

		// String pw = request.getParameter("pw");

		SHA256 sha256 = new SHA256();
		String SHA256_pw = sha256.getSHA256(request.getParameter("pw")).toUpperCase();

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");

		// System.out.println("pw : " + pw);
		System.out.println("SHA256_pw : " + SHA256_pw);
		System.out.println("name : " + name);
		System.out.println("phone : " + phone);
		System.out.println("eMail : " + eMail);

		signupDao signupdao = sqlSession.getMapper(signupDao.class);

		// try {
		// signupdao.signup(eMail, SHA256_pw, name, phone);
		// } catch (Exception e) {
		// // TODO: handle exception
		// signupdao.updateSign(eMail, eMail, SHA256_pw, name, phone);
		// }

		signupdao.signup(eMail, SHA256_pw, name, phone);
		return "redirect:login";
		// }

	}

}