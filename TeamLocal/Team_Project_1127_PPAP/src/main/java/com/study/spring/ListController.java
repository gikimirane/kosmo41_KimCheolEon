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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.spring.dao.GroupListDao;
import com.study.spring.dto.GroupListDto;
import com.study.spring.dto.GroupListPageInfo;

@Controller
public class ListController {

	private static final Logger logger = LoggerFactory.getLogger(ListController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	int listCount = 10;
	int pageCount = 10;
	JSONArray jsonArray;
	JSONObject jsonObject;
	
	
	// 일반게시판

	// 글쓰기
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);

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
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		
//		글상세 페이지 리스트 업
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));
		GroupListDto contetdto = dao.content_view(request.getParameter("bId"));
		
//		댓글 리스트 업
		model.addAttribute("content_reply", dao.content_reply_view(request.getParameter("bId")));
		
		
//		조회수 증가
		dao.upHit(request.getParameter("bId"));
		try {
			HttpSession session = request.getSession();
			session.setAttribute("content_view_makerName", contetdto.getbName());
			
			String userName = (String)session.getAttribute("userName");
			request.setAttribute("userName", userName);
		} catch (Exception e) {

		}

		return "/C_TEAM_BOARD/TEAM_BOARD_List_View";
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
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);

		if (option == null || option.equals("")) {
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
		
		GroupListPageInfo pinfo = articlePage(nPage, nTotalPage);

		model.addAttribute("page", pinfo);

		nPage = pinfo.getCurPage();
	
		int nStart = (nPage - 1) * listCount + 1;
		int nEnd = (nPage - 1) * listCount + listCount;
		
		if (option == null || option.equals("")) {
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

		return "/C_TEAM_BOARD/TEAM_BOARD_List_";
	}

	// 글 작성페이지로 이동
	@RequestMapping("/write_view")
	public String writeForm() {

		return "/C_TEAM_BOARD/TEAM_BOARD_List_Write_View";
	}

	// 글 삭제하기
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		dao.deleteDao(request.getParameter("bId"));

		return "redirect:list";
	}

	// 글 수정하기 페이지
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));

		return "/C_TEAM_BOARD/TEAM_BOARD_List_Modify_View";
	}

	// 글 수정하기 액션(DB추가)
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		dao.modify_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bId")));
		
		System.out.println(request.getParameter("bId"));
		model.addAttribute("content_view", dao.content_view(request.getParameter("bId")));
		return "/C_TEAM_BOARD/TEAM_BOARD_List_View";
	}

	// 답글 달기 페이지
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		model.addAttribute("reply_view", dao.content_view(request.getParameter("bId")));

		return "/C_TEAM_BOARD/TEAM_BOARD_List_Reply_View";
	}

	// 답글 달기액션(DB추가)
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
		int bStep = Integer.parseInt(request.getParameter("bStep") + 1);
		int bIndent = Integer.parseInt(request.getParameter("bIndent") + 1);
		dao.reply_view(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"),
				Integer.parseInt(request.getParameter("bGroup")), bStep, bIndent);

		return "redirect:list";
	}
	
	// 일반게시물 댓글달기
		@RequestMapping("/content_reply")
		public void content_reply(HttpServletRequest request, HttpServletResponse response, Model model)
				throws IOException {

			System.out.println("content_reply()");
			GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
			PrintWriter writer = response.getWriter();

			String numId = request.getParameter("numId");
			String content = request.getParameter("content");
			System.out.println("content : " + content);
			String name = request.getParameter("name");

			try {
				dao.content_reply(numId, name, content);
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + "댓글이 정상등록 되었습니다." + "\"}]");
			} catch (Exception e) {
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + "댓글등록에 실패했습니다." + "\"}]");
			}

			writer.close();
		}

		// 일반게시물 댓글삭제하기
		@RequestMapping("/reply_delete")
		public void reply_delete(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
			System.out.println("reply_delete()");

			GroupListDao dao = sqlSession.getMapper(GroupListDao.class);
			PrintWriter writer = response.getWriter();

			String numId = request.getParameter("numId");

			try {
				dao.reply_delete(numId);
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + "댓글삭제에 성공 했습니다." + "\"}]");
			} catch (Exception e) {
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + "댓글삭제에 실패 했습니다." + "\"}]");
			}

			writer.close();
		}

	// 일반게시판 페이징처리
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
}