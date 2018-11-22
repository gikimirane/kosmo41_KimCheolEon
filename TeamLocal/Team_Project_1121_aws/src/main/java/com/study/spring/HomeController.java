package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
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
import com.study.spring.dto.Joinapply;
import com.study.spring.signup.dao.DbDao;
import com.study.spring.signup.dao.signupDao;
import com.study.spring.signup.dto.RecordDto;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	@Autowired
	private ServletContext servletContext;

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

	// 마이페이지
	@RequestMapping("/myPagelist")
	public String myPagelist(HttpServletRequest request, Model model) {
		DbDao dao = sqlSession.getMapper(DbDao.class);
		// 로그인 아이디 확인
		session = request.getSession();
		String name = (String) session.getAttribute("userName");

		System.out.println(name);

		int nPage = 1;
		int nTotalPage = 0;

		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}

		nTotalPage = dao.mypageCount(name);
		System.out.println(nTotalPage);
		BPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		System.out.println(nStart);
		System.out.println(nEnd);

		model.addAttribute("pagelist", dao.mypagelist(nStart, nEnd, name));

		return "/MyPagelist";
	}

	// 정보수정
	@RequestMapping("/mem_modify")
	public String mem_modify() {
		return "/modify";
	}

	// 정보수정 (DB에 업데이트)
	@RequestMapping("/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		DbDao dao = sqlSession.getMapper(DbDao.class);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		System.out.println("핸드폰 : " + phone);
		System.out.println("이메일 : " + email);
		dao.modifyOk(phone, email);

		return "redirect:list";
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

		RecordDto recordDto = dao.recordcheck_view(request.getParameter("startTime"));
		String map1 = recordDto.getMap1();
		String map2 = recordDto.getMap2();
		String map3 = recordDto.getMap3();
		String map4 = recordDto.getMap4();
		String map5 = recordDto.getMap5();

		String[] dataList = { map1, map2, map3, map4, map5 };

//		System.out.println("map1 : " + dataList[0]);
//		System.out.println("map2 : " + dataList[1]);
//		System.out.println("map3 : " + dataList[2]);
//		System.out.println("map4 : " + dataList[3]);
//		System.out.println("map5 : " + dataList[4]);
//		System.out.println("map1 length : " + dataList[0].length());
//		System.out.println("map2 length : " + dataList[1].length());
//		System.out.println("map3 length : " + dataList[2].length());
//		System.out.println("map4 length : " + dataList[3].length());
//		System.out.println("map5 length : " + dataList[4].length());
		
		String result = "";
		System.out.println("result : " + result);
		for(int i = 0; i < 5; i++) {
//			System.out.println("in for");
			if(dataList[i].equals("nodata")) {
				continue;
			}
//			System.out.println("append");
			dataList[i] = dataList[i].replaceAll("\\[", "");
			dataList[i] = dataList[i].replaceAll("\\]", "");	
			result += dataList[i] + ",";
		}
		
		result = "[" + result + "]";
		
		System.out.println("result : " + result);
		System.out.println("result length : " + result.length());

		model.addAttribute("map", result);

		return "/recordcheck_view";
	}

	// 기록관리 게시판 리스트
	@RequestMapping("/recheck")
	public String recordcheck(HttpServletRequest request, Model model) {
		DbDao dao = sqlSession.getMapper(DbDao.class);
		String email = "";

		session = request.getSession();

		int listCount = 9;
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		try {
			email = (String) session.getAttribute("email_id");

		} catch (Exception e) {

		}
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

		JoinDto joindto = dao.join_view(request.getParameter("numId"));

		session = request.getSession();
		String name = (String) session.getAttribute("userName");

		try {
			session.setAttribute("makerName", joindto.getName());
			Joinapply joinapply = dao.joinapply(request.getParameter("numId"), name);
			String checkname = joinapply.getUserName();
			System.out.println(checkname);
			if (checkname.equals(name)) {
				session.setAttribute("checking", "Yes");
			}

		} catch (Exception e) {
			session.setAttribute("checking", "No");
		}

		System.out.println(session.getAttribute("checking"));

		return "/join_view";
	}

	// 모임게시물 만들기 페이지 이동
	@RequestMapping("/jmake_view")
	public String jmake_view(HttpServletRequest request, Model model) {
		String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		session = request.getSession();
		session.setAttribute("curTime", curTime);

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
		session = request.getSession();
		String name = (String) session.getAttribute("userName");
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

		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

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
		dao.upHit(request.getParameter("bId"));
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

		String option = request.getParameter("option");
		String search = request.getParameter("search");

		int nPage = 1;
		int nTotalPage = 0;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		IDao dao = sqlSession.getMapper(IDao.class);

		if (search == null) {
			nTotalPage = dao.articleCount();
		}

		else if (option.equals("0")) {
			nTotalPage = dao.articleCount0(search);
		}

		else if (option.equals("1")) {
			nTotalPage = dao.articleCount1(search);
		}

		else if (option.equals("2")) {
			nTotalPage = dao.articleCount2(search);
		}

		else if (option.equals("3")) {
			nTotalPage = dao.articleCount3(search);
		}

		BPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		if (search == null) {
			model.addAttribute("list", dao.listDao(nStart, nEnd));
		}

		else if (option.equals("0")) {
			model.addAttribute("list", dao.listDao0(nStart, nEnd, search));
		}

		else if (option.equals("1")) {
			model.addAttribute("list", dao.listDao1(nStart, nEnd, search));
		}

		else if (option.equals("2")) {
			model.addAttribute("list", dao.listDao2(nStart, nEnd, search));
		}

		else if (option.equals("3")) {
			model.addAttribute("list", dao.listDao3(nStart, nEnd, search));
		}

		request.setAttribute("page", pinfo);
		request.setAttribute("option", option);
		request.setAttribute("search", search);

		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("option", option);
		session.setAttribute("search", search);

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

	@RequestMapping("joinOK")
	public void joinOK(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		System.out.println("joinOK()");

		PrintWriter writer = response.getWriter();

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

		String resultTest = "";

		try {
			signupdao.signup(eMail, SHA256_pw, name, phone);
			resultTest = "계정 등록 완료";
		} catch (Exception e) {
			// TODO: handle exception
			resultTest = "Error!";
			e.printStackTrace();
		}

		writer.println(resultTest);

		writer.close();
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

}