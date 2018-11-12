package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@RequestMapping("/updateVerify")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		String Ajax_updateEmail = request.getParameter("Ajax_updateEmail");

		// Email 유효성 검사
		System.out.println("파라미터 email : " + Ajax_updateEmail);

		// 탐색 할 Email 변수
		String searchEmail = null;
		String searchEmailVerify = null;

		// Email 란에 빈 값일 때
		if (Ajax_updateEmail.equals("")) {
			System.out.println("null");
			writer.println("[{\"result\":\"NULL\",\"desc\":\"Email을 입력해주세요.\"}]");
			writer.close();

			return;
		}

		signupDao signupdao = sqlSession.getMapper(signupDao.class);
		try {

			signupDto signupdto = signupdao.idcheck(Ajax_updateEmail);

			searchEmail = signupdto.getEMAIL();
			searchEmailVerify = signupdto.getVERIFY();

			System.out.println("확인된 dto 값 : " + searchEmail);
			System.out.println("Email 인증상태 : " + searchEmailVerify);

			if (searchEmailVerify.equals("NOPASS")) {
				writer.println("[{\"result\":\"NOPASS\",\"desc\":\"등록되었으나 Email 미인증 상태 입니다...\",\"pw\":\"" + signupdto.getPW() + "\"}]");
			} else {
				writer.println("[{\"result\":\"FAIL\",\"desc\":\"중복된 Email 주소 입니다...\"}]");
			}

		} catch (NullPointerException e) {
			System.out.println("[값 존재하지 않음/NullPointerException] : " + e);
			writer.println("[{\"result\":\"OK\",\"desc\":\"사용 가능한 Email 입니다.\"}]");
		} finally {
			writer.close();
		}

	}
}