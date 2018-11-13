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
	public void updateVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		String Ajax_updateEmail = request.getParameter("Ajax_updateEmail");
		String userName = request.getParameter("userName");

		System.out.println("Ajax_updateEmail : " + Ajax_updateEmail);
		System.out.println("userName : " + userName);
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("userName", userName);
		
		// 생각해보니 세션 만들 필요가 없었음. firebase 계정 돌리면 되니까.
		System.out.println("세션테스트 : " + session.getAttribute("userName"));
		

		signupDao signupdao = sqlSession.getMapper(signupDao.class);
		try {

			signupdao.updateVerified("PASS", Ajax_updateEmail);

			writer.println("[{\"result\":\"OK\",\"desc\":\"[" + userName + "] 님의 접속을 환영합니다!\"}]");

		} catch (NullPointerException e) {
			
			writer.println("[{\"result\":\"FAIL\",\"desc\":\"갱신 에러!!\"}]");
			
		} finally {
			writer.close();
		}

	}
}