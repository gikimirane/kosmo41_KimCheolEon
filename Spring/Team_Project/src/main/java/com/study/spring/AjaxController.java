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

	@RequestMapping("/emailCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String Ajax_emailCheck = request.getParameter("Ajax_emailCheck");

		PrintWriter writer = response.getWriter();

		String searchID = null;
		
		System.out.println("Ajax_emailCheck : " + Ajax_emailCheck);

		// text
		if (Ajax_emailCheck.equals("")) {
			System.out.println("null");
			writer.println("[{\"result\":\"NULL\",\"desc\":\"Email을 입력해주세요.\"}]");
			writer.close();
		} else {
			System.out.println("확인요청받은 Email : " + Ajax_emailCheck);

			signupDao signupdao = sqlSession.getMapper(signupDao.class);

			try {

				signupDto signupdto = signupdao.idcheck(Ajax_emailCheck);

//				searchID = signupdto.getID();

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