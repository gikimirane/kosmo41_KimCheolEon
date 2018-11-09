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

	@RequestMapping("/emailCheck")
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		String Ajax_emailCheck = request.getParameter("Ajax_emailCheck");

		// Email 유효성 검사
		boolean EmailCheck = checkEmail(Ajax_emailCheck);
		System.out.println("EmailCheck : " + EmailCheck);
		System.out.println("확인요청받은 Email : " + Ajax_emailCheck);

		// 탐색 할 Email 변수
		String searchEmail = null;
		System.out.println("Ajax_emailCheck : " + Ajax_emailCheck);

		// Email 란에 빈 값일 때
		if (Ajax_emailCheck.equals("")) {
			System.out.println("null");
			writer.println("[{\"result\":\"NULL\",\"desc\":\"Email을 입력해주세요.\"}]");
			writer.close();

			return;
		}

		// Email 유효성이 올바르지 않을 때
		if (!EmailCheck) {
			writer.println("[{\"result\":\"NOEMAIL\",\"desc\":\"올바른 Email 형식을 입력해주세요.\"}]");
			writer.close();

			return;
		}

		signupDao signupdao = sqlSession.getMapper(signupDao.class);
		try {

			signupDto signupdto = signupdao.idcheck(Ajax_emailCheck);

			searchEmail = signupdto.getEMAIL();

			System.out.println("확인된 dto 값 : " + searchEmail);
			writer.println("[{\"result\":\"FAIL\",\"desc\":\"중복된 Email 주소 입니다..\"}]");
		} catch (NullPointerException e) {
			System.out.println("[값 존재하지 않음/NullPointerException] : " + e);
			writer.println("[{\"result\":\"OK\",\"desc\":\"사용 가능한 Email 입니다.\"}]");
		} finally {
			writer.close();
		}

	}

	// http://plaboratory.org/archives/143
	public boolean checkEmail(String email) {
		String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		boolean isNormal = m.matches();

		return isNormal;
	}
}