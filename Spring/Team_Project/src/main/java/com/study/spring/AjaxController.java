package com.study.spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import com.study.spring.signup.dao.signupDao;
import com.study.spring.signup.dto.signupDto;

@Controller
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;

	private HttpSession session = null;
	
	@Autowired private ServletContext servletContext;
	

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

	@RequestMapping("/firebaseAdmin")
	public void firebaseAdmin(HttpServletRequest req, HttpServletResponse res)
			throws IOException, FirebaseAuthException {
		
		System.out.println("firebaseAdmin()");
		
//		https://firebase.google.com/docs/admin/setup
//		https://firebase.google.com/docs/auth/admin/manage-users#update_a_user
		
//		System.out.println(servletContext.getRealPath("resources/google-services.json"));
//		FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");
		FileInputStream serviceAccount = new FileInputStream(servletContext.getRealPath("resources/kosmo-teamproject-key.json"));

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://kosmo-teamproject-aee81.firebaseio.com").build();

		FirebaseApp.initializeApp(options);

		// ----------------------------------------------------------------------------------------

		String uid = req.getParameter("uid");
		String displayName = req.getParameter("displayName");
		
		System.out.println("uid : " + uid);
		System.out.println("displayName : " + displayName);

		UpdateRequest request = new UpdateRequest(uid)
				.setEmailVerified(true)
				.setDisplayName(displayName);

		UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);
		System.out.println("Successfully updated user: " + userRecord.getUid());

	}
}