package com.study.spring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.study.spring.dao.GroupJoinDao;
import com.study.spring.dao.MemberListCallDao;
import com.study.spring.dao.GroupSignupDao;
import com.study.spring.dto.GroupManagementDto;
import com.study.spring.dto.GroupSignupDto;

@Controller
public class FirebaseController {

	private static final Logger logger = LoggerFactory.getLogger(FirebaseController.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private ServletContext servletContext;

	private HttpSession session = null;

	int stateNumber = 1;

	public FirebaseMessaging message = null;
	public FirebaseAuth auth = null;

	public void FirebaseFunction() throws IOException {

		FirebaseMessaging message;
		FirebaseAuth auth;

		if (stateNumber == 1) {
			FileInputStream serviceAccount = new FileInputStream(
					servletContext.getRealPath("resources/kosmo-teamproject-key.json"));
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://kosmo-teamproject-aee81.firebaseio.com").build();
			FirebaseApp.initializeApp(options);

			this.auth = FirebaseAuth.getInstance();
			this.message = FirebaseMessaging.getInstance();

			stateNumber++;
		}
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
		session.setAttribute("email_id", Ajax_updateEmail);
		session.setAttribute("email_test", "123456");

		GroupSignupDao signupdao = sqlSession.getMapper(GroupSignupDao.class);
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

	@RequestMapping("/memberListCall")
	public void memberListCall(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();

		int numId = Integer.parseInt(request.getParameter("numId"));

		System.out.println("numId 확인 : " + numId);

		String memberAppend = "";

		MemberListCallDao memberListCallDao = sqlSession.getMapper(MemberListCallDao.class);

		try {

			ArrayList<GroupManagementDto> memList = memberListCallDao.memberList(numId);
			for (int i = 0; i < memList.size(); i++) {
				System.out.println(memList.get(i).getUserName() + " : " + memList.get(i).getState());
				if (memList.get(i).getState().equals("ACTIVE")) {
					memberAppend += "<p>" + memList.get(i).getUserName() + "</p>";
				}
			}

			writer.println(memberAppend);

		} catch (NullPointerException e) {

			writer.println("[{\"result\":\"FAIL\",\"desc\":\"Error!!!\"}]");

		} finally {
			writer.close();
		}

	}

	@RequestMapping("/firebaseAdmin")
	public void firebaseAdmin(HttpServletRequest req, HttpServletResponse res)
			throws IOException, FirebaseAuthException {

		System.out.println("firebaseAdmin()");

		FirebaseFunction();

		// ----------------------------------------------------------------------------------------

		String uid = req.getParameter("uid");
		String displayName = req.getParameter("displayName");

		System.out.println("uid : " + uid);
		System.out.println("displayName : " + displayName);

		UpdateRequest request = new UpdateRequest(uid).setEmailVerified(true).setDisplayName(displayName);

		UserRecord userRecord = FirebaseAuth.getInstance().updateUser(request);
		System.out.println("Successfully updated user: " + userRecord.getUid());

	}

	@RequestMapping("/FCMpushMessage")
	public void FCMpushMessage(HttpServletRequest request, HttpServletResponse res)
			throws FirebaseMessagingException, IOException {

		System.out.println("FCMpushMessage()");

		FirebaseFunction();

		// ----------------------------------------------------------------------------------//

		PrintWriter writer = res.getWriter();

		int numId = Integer.parseInt(request.getParameter("numId"));
		String boardName = request.getParameter("boardName");
		String fcmTitle = request.getParameter("fcmTitle");
		String fcmBody = request.getParameter("fcmBody");

		String userEmail = (String) session.getAttribute("email_id");
		System.out.println("fcm 메시지 - session 이메일 : " + userEmail);

		if (fcmTitle.equals("") && fcmBody.equals("")) {
			writer.println("empty");
			writer.close();
			return;
		}

		// where NUMID_FK
		GroupJoinDao dao = sqlSession.getMapper(GroupJoinDao.class);
		ArrayList<GroupManagementDto> mgmtSelect = dao.groupUser(numId);

		GroupSignupDao signdao = sqlSession.getMapper(GroupSignupDao.class);

		try {
			for (int i = 0; i < mgmtSelect.size(); i++) {
				System.out.println("mgmtSelect.get(i).getMG_EMAIL() : " + mgmtSelect.get(i).getMG_EMAIL());

				if (mgmtSelect.get(i).getMG_EMAIL().equals(userEmail)) {
					System.out.println("fcm메시지 - 글 작성자 이메일 제외");
					continue;
				}

				GroupSignupDto signdto = signdao.tokenGet(mgmtSelect.get(i).getMG_EMAIL());

				System.out.println("signdto.getTOKEN() : " + signdto.getTOKEN());

				if (signdto.getTOKEN().equals("NODATA")) {
					System.out.println("fcm메시지 - 토큰 NODATA 제외");
					continue;
				}
//					  See documentation on defining a message payload.
				Message message = 
						Message.builder()
						.putData("title", fcmTitle)
						.putData("message", fcmBody)
						.setToken(signdto.getTOKEN())
						.build();

				String response = FirebaseMessaging.getInstance().send(message);
				System.out.println("Successfully sent message: " + response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			writer.close();
		}

	}
}