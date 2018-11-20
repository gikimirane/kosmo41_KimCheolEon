package com.study.spring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import com.study.spring.dao.IDao;
import com.study.spring.dto.Joinapply;
import com.study.spring.dto.Joinapplycount;
import com.study.spring.signup.dao.signupDao;

@Controller
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired 
	private ServletContext servletContext;
	
	private HttpSession session = null;
	
	// 모임게시판 참가신청
	@RequestMapping("/join_join")
	public String Join_join(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		PrintWriter writer = response.getWriter();
	
		// 참가인원 확인
		Joinapplycount joinCount = dao.joinapplycount(request.getParameter("numId"));
		int fixed = Integer.parseInt(request.getParameter("fixed")); // 정원
		int jcount = Integer.parseInt(joinCount.getCount());		 // 현재 참가인원
		
		if(fixed > jcount) {
			try {
				// 중복참가 확인
				Joinapply joinapply = dao.joinapply(request.getParameter("numId"),request.getParameter("name"));
				if(joinapply.equals("null")) {
				}
			}catch (Exception e) {
				dao.Join_join(request.getParameter("numId"), request.getParameter("name"));
				writer.println("[{\"result\":\"OK\",\"desc\":\"" + (jcount+1) + "\"}]");
				writer.close();
			}				
		}		

		return "joinlist";
	}
	
	// 모임게시물 삭제하기
	@RequestMapping("/join_delete")
	public String join_delete(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
		
		System.out.println("join_delete()");
		IDao dao = sqlSession.getMapper(IDao.class);
		PrintWriter writer = response.getWriter();
		
		String numId = request.getParameter("numId");
		// 작성자여부 확인
		String maker = request.getParameter("maker");
		String name = request.getParameter("name");
	
		if(maker.equals(name)) {
			dao.join_delete(numId);
		}else {
			writer.println("[{\"result\":\"OK\",\"desc\":\"" + "작성자가 아니라 글삭제에 실패했습니다" + "\"}]");
			writer.close();
		}
		return "joinlist";
	}
	
	
	
	@RequestMapping("/updateVerify")
	public void updateVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		String Ajax_updateEmail = request.getParameter("Ajax_updateEmail");
		String userName = request.getParameter("userName");

		System.out.println("Ajax_updateEmail : " + Ajax_updateEmail);
		System.out.println("userName : " + userName);

		session = request.getSession();
		session.setAttribute("userName", userName);

		// 생각해보니 세션 만들 필요가 없었음. firebase 계정 돌리면 되니까.
		System.out.println("세션테스트 : " + session.getAttribute("userName"));

		signupDao signupdao = sqlSession.getMapper(signupDao.class);
		try {

			signupdao.updateVerified("PASS", Ajax_updateEmail);
			
			session.setAttribute("ValidMem", "yes");

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