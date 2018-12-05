package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import com.study.spring.dao.AndroidDao;
import com.study.spring.dao.GroupRunningDao;
import com.study.spring.dao.GroupSignupDao;
import com.study.spring.dto.GroupJoinPageInfo;
import com.study.spring.dto.GroupListPageInfo;
import com.study.spring.dto.GroupRunningDto;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	int listCount = 10;
	int pageCount = 10;
	JSONArray jsonArray;
	JSONObject jsonObject;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "A_Home/home";
	}

	// 로그인
	@RequestMapping("/login")
	public String login() {
		return "/B_NAVBAR/login";
	}

	// 회원가입
	@RequestMapping("/join")
	public String join() {
		return "/B_NAVBAR/join";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout() {
		return "/B_NAVBAR/logout";
	}

	// 기록관리 게시판 글상세 페이지
	@RequestMapping("/recordcheck_view")
	public String recordcheck_view(HttpServletRequest request, Model model) {
		GroupRunningDao dao = sqlSession.getMapper(GroupRunningDao.class);
		model.addAttribute("recordcheck_view", dao.recordcheck_view(request.getParameter("startTime")));

		GroupRunningDto recordDto = dao.recordcheck_view(request.getParameter("startTime"));
		String map1 = recordDto.getMap1();
		String map2 = recordDto.getMap2();
		String map3 = recordDto.getMap3();
		String map4 = recordDto.getMap4();
		String map5 = recordDto.getMap5();

		String[] dataList = { map1, map2, map3, map4, map5 };

		String result = "";
		System.out.println("result : " + result);
		for (int i = 0; i < 5; i++) {
			// System.out.println("in for");
			if (dataList[i].equals("nodata")) {
				continue;
			}
			// System.out.println("append");
			dataList[i] = dataList[i].replaceAll("\\[", "");
			dataList[i] = dataList[i].replaceAll("\\]", "");
			result += dataList[i] + ",";
		}

		result = "[" + result + "]";

		System.out.println("result : " + result);
		System.out.println("result length : " + result.length());

		model.addAttribute("map", result);

		return "/E_TEAM_RUNNING/TEAM_RUNNING_List_View";
	}

	// 기록관리 게시판 리스트
	@RequestMapping("/recheck")
	public String recordcheck(HttpServletRequest request, Model model) {
		GroupRunningDao dao = sqlSession.getMapper(GroupRunningDao.class);
		session = request.getSession();

		String email = "";
		String search = request.getParameter("search");
		String option = "";

		if (search == null || search.equals("")) {
			option = "";
		} else {
			option = "0";
		}

		System.out.println("search : " + search);
		System.out.println("option : " + option);

		int listCount = 9;
		int nPage = 1;
		int nTotalPage = 0;
		try {
			email = (String) session.getAttribute("email_id");
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}

		System.out.println("email : " + email);

		if (option == null || option.equals("")) {
			nTotalPage = dao.RecordCount(email);
		} else if (option.equals("0")) {
			nTotalPage = dao.RecordCount0(email, search);
		}

		GroupJoinPageInfo pinfo = JoinPage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		if (option == null || option.equals("")) {
			model.addAttribute("recordlist", dao.recordlist(nStart, nEnd, email));
		}

		else if (option.equals("0")) {
			model.addAttribute("recordlist", dao.recordlist0(nStart, nEnd, email, search));
		}

		session.setAttribute("setting", dao.recordlist(nStart, nEnd, email));

		request.setAttribute("page", pinfo);
		request.setAttribute("option", option);
		request.setAttribute("search", search);

		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("option", option);
		session.setAttribute("search", search);

		return "/E_TEAM_RUNNING/TEAM_RUNNING_List_";
	}

	// 기록게시판 페이징처리
	public GroupJoinPageInfo JoinPage(int curPage, int nTotalCount) {
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

		GroupJoinPageInfo pinfo = new GroupJoinPageInfo();
		pinfo.setTotalCount(nTotalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(myCurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}

	// 마이페이지
	@RequestMapping("/myPagelist")
	public String myPagelist(HttpServletRequest request, Model model) {
		GroupRunningDao dao = sqlSession.getMapper(GroupRunningDao.class);
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
		GroupListPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		System.out.println(nStart);
		System.out.println(nEnd);

		model.addAttribute("pagelist", dao.mypagelist(nStart, nEnd, name));

		return "/F_TEAM_GROUP_MANAGEMENT/TEAM_GROUP_MANAGEMENT_List_";
	}

	// 마이페이지 페이징처리
	public GroupListPageInfo articlePage(int curPage, int nTotalCount) {
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

		GroupListPageInfo pinfo = new GroupListPageInfo();
		pinfo.setTotalCount(nTotalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(myCurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}

	// 정보수정
	@RequestMapping("/mem_modify")
	public String mem_modify() {
		return "/B_NAVBAR/modify";
	}

	// 정보수정 (DB에 업데이트)
	@RequestMapping("/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		AndroidDao dao = sqlSession.getMapper(AndroidDao.class);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		System.out.println("핸드폰 : " + phone);
		System.out.println("이메일 : " + email);
		dao.modifyOk(phone, email);

		return "redirect:list";
	}

	@RequestMapping("joinOK")
	public void joinOK(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		System.out.println("joinOK()");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

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

		GroupSignupDao signupdao = sqlSession.getMapper(GroupSignupDao.class);


		try {
			signupdao.signup(eMail, SHA256_pw, name, phone);
			writer.println("[{\"result\":\"OK\",\"desc\":\"로그인 화면으로 이동합니다.\"}]");
		} catch (Exception e) {
			e.printStackTrace();
			writer.println("[{\"result\":\"FAIL\",\"desc\":\"Error\"}]");
		} finally {
			writer.close();
		}
	}
}