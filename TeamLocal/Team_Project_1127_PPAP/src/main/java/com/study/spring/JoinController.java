package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.spring.dao.GroupJoinDao;
import com.study.spring.dto.GroupJoinDto;
import com.study.spring.dto.GroupJoinPageInfo;
import com.study.spring.dto.GroupManagementDto;
import com.study.spring.dto.GroupManagementcount;

@Controller
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	int listCount = 10;
	int pageCount = 10;
	JSONArray jsonArray;
	JSONObject jsonObject;

	// 모임게시판

	// 모임게시판 페이징처리
	@RequestMapping("/joinlist")
	public String joinlist(HttpServletRequest request, Model model) {
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);

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
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}

		if (option == null || option.equals("")) {
			nTotalPage = dao.JoinCount();
		} else if (option.equals("0")) {
			nTotalPage = dao.JoinCount0(search);
		}

		GroupJoinPageInfo pinfo = JoinPage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();

		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;

		if (option == null || option.equals("")) {
			model.addAttribute("clublist", dao.JoinDao(nStart, nEnd));
		}

		else if (option.equals("0")) {
			model.addAttribute("clublist", dao.JoinDao0(nStart, nEnd, search));
		}

		request.setAttribute("page", pinfo);
		request.setAttribute("option", option);
		request.setAttribute("search", search);

		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("option", option);
		session.setAttribute("search", search);

		return "/D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_";
	}

	// 모임게시판 상세페이지
	@RequestMapping("/join_view")
	public String join_view(HttpServletRequest request, Model model) {
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);

		model.addAttribute("joinapplycount", dao.joinapplycount(request.getParameter("numId")));
		model.addAttribute("join_view", dao.join_view(request.getParameter("numId")));

		GroupJoinDto joindto = dao.join_view(request.getParameter("numId"));

		session = request.getSession();
		String name = (String) session.getAttribute("userName");

		try {
			session.setAttribute("makerName", joindto.getName());
			GroupManagementDto joinapply = dao.joinapply(request.getParameter("numId"), name);
			String checkname = joinapply.getUserName();
			System.out.println(checkname);
			if (checkname.equals(name)) {
				session.setAttribute("checking", "Yes");
			}

		} catch (Exception e) {
			session.setAttribute("checking", "No");
		}

		System.out.println(session.getAttribute("checking"));

		return "/D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_View";
	}

	// 모임게시판 참가신청
	@RequestMapping("/join_join")
	public String Join_join(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);
		PrintWriter writer = response.getWriter();

		// 참가인원 확인
		GroupManagementcount joinCount = dao.joinapplycount(request.getParameter("numId"));
		int fixed = Integer.parseInt(request.getParameter("fixed")); // 정원
		int jcount = Integer.parseInt(joinCount.getCount()); // 현재 참가인원

		if (fixed > jcount) {
			try {
				// 중복참가 확인
				GroupManagementDto joinapply = dao.joinapply(request.getParameter("numId"),
						request.getParameter("name"));
				if (joinapply.equals("null")) {
				}
			} catch (Exception e) {
				dao.Join_join(request.getParameter("numId"), request.getParameter("name"),
						request.getParameter("userEmail"));
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + "참가신청이 완료됐습니다." + "\"}]");
				writer.close();
			}
		}

		return "D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_";
	}

	// 모임게시물 삭제하기
	@RequestMapping("/join_delete")
	public String join_delete(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		System.out.println("join_delete()");
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);
		PrintWriter writer = response.getWriter();

		session = request.getSession();

		String numId = request.getParameter("numId");
		// 작성자여부 확인
		String name = (String) session.getAttribute("userName");
		String maker = (String) session.getAttribute("makerName");

		if (maker.equals(name)) {
			dao.manegement_delete(numId);
			dao.join_delete(numId);
			writer.println("[{\"result\":\"OK\",\"desc\":\"" + "글삭제에 성공했습니다" + "\"}]");
		} else {
			writer.println("[{\"result\":\"OK\",\"desc\":\"" + "작성자가 아니라 글삭제에 실패했습니다" + "\"}]");
		}

		writer.close();
		return "D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_";
	}

	// 모임게시물 취소하기
	@RequestMapping("/join_cancel")
	public String join_cancel(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		System.out.println("join_cancel()");
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);
		PrintWriter writer = response.getWriter();

		session = request.getSession();

		String numId = request.getParameter("numId");
		String name = (String) session.getAttribute("userName");

		try {
			dao.Join_cancel(numId, name);
			writer.println("[{\"result\":\"OK\",\"desc\":\"" + "신청하신 내용을 취소했습니다" + "\"}]");
		} catch (Exception e) {
			writer.println("[{\"result\":\"OK\",\"desc\":\"" + "신청하신 내용을 취소하지 못했습니다" + "\"}]");
		}

		writer.close();

		return "D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_";
	}

	// 모임게시물 만들기 페이지 이동
	@RequestMapping("/jmake_view")
	public String jmake_view(HttpServletRequest request, Model model) {
		String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		session = request.getSession();
		session.setAttribute("curTime", curTime);

		return "/D_TEAM_GROUPBOARD/TEAM_GROUPBOARD_List_Make";
	}

	// 모임게시물 만들기 시행 (SQL시행)
	@RequestMapping("/jmake")
	public String jmake(HttpServletRequest request, Model model) {
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);

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

			// Email 정보
			String userEmail = multi.getParameter("userEmail");

			System.out.println("name : " + name);
			System.out.println("userEmail : " + userEmail);

			dao.jmakeDao(name, multi.getParameter("title"), multi.getParameter("content"),
					multi.getParameter("address"), file, WANTEDSTART, WANTEDEND, EVENTSTART, EVENTEND,
					multi.getParameter("fixed"));
			
			ArrayList<GroupJoinDto> getNumber = dao.getgroupBoardNumId(name);
			
			System.out.println("생성된 모임번호 : " + getNumber.get(0).getNumId());
			
			dao.jmake_join(getNumber.get(0).getNumId(), name, userEmail);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return "redirect:joinlist";
	}

	// 모임게시판 페이징처리
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

}