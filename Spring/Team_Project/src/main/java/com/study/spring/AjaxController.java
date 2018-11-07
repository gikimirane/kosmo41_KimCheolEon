package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.signup.dao.signupDao;
import com.study.spring.signup.dto.signupDto;

@Controller
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;

	@RequestMapping("/idCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String Ajax_idCheck = request.getParameter("Ajax_idCheck");
		int idMinlength = Integer.parseInt(request.getParameter("idMinlength"));

		PrintWriter writer = response.getWriter();

		String searchID = null;

		// text
		if (Ajax_idCheck.equals("")) {
			System.out.println("null");
			writer.println("[{\"result\":\"NULL\",\"desc\":\"아이디를 입력해주세요.\"}]");
			writer.close();
		} else if (Ajax_idCheck.length() < idMinlength) {
			// 아이디는 " + idMinlength + "글자 이상이어야 합니다.
			writer.println("[{\"result\":\"NULL\",\"desc\":\"아이디는 " + idMinlength + "글자 이상이어야 합니다.\"}]");
			writer.close();
		}

		else {
			System.out.println("확인요청받은 ID : " + Ajax_idCheck);

			signupDao signupdao = sqlSession.getMapper(signupDao.class);

			try {

				signupDto signupdto = signupdao.idcheck(Ajax_idCheck);

				searchID = signupdto.getID();

				System.out.println("확인된 dto 값 : " + searchID);
				writer.println("[{\"result\":\"FAIL\",\"desc\":\"중복된 아이디입니다.\"}]");
			} catch (NullPointerException e) {
				System.out.println("[값 존재하지 않음/NullPointerException] : " + e);
				writer.println("[{\"result\":\"OK\",\"desc\":\"사용 가능한 아이디입니다.\"}]");
			} finally {
				writer.close();
			}
		}
	}
}