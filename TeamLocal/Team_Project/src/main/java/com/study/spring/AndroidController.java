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
import com.oreilly.servlet.MultipartRequest;
import com.study.spring.dao.IDao;
import com.study.spring.dto.Joinapply;
import com.study.spring.dto.Joinapplycount;
import com.study.spring.signup.dao.DbDao;
import com.study.spring.signup.dao.signupDao;
import com.study.spring.signup.dto.signupDto;

@Controller
public class AndroidController {

	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);

	@Autowired
	private SqlSession sqlSession;
	private HttpSession session = null;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/AndroidLogin")
	public void AndroidLogin(HttpServletRequest request, HttpServletResponse response) {

		PrintWriter writer;
		String returns = null;

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		System.out.println("db1 email : [" + email + "]");
		System.out.println("db1 pw : [" + pw + "]");

		DbDao dbDao = sqlSession.getMapper(DbDao.class);
		signupDto signupDto = dbDao.connectionDB(email);
		try {
			if (email.equals(signupDto.getEMAIL())) {

				if (pw.equals(signupDto.getPW())) {
					returns = "loginOK";
				} else {
					returns = "password";
				}

			}
		} catch (Exception e) {
			returns = "notid";
		}

		System.out.println(returns);

		// 안드로이드로 전송
		try {
			writer = response.getWriter();
			writer.println(returns);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/Androidtime")
	public void Androidtime(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writer;
		String returns = null;

		String email = request.getParameter("email");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String movetime = request.getParameter("move");
		String upload = request.getParameter("upload");

		System.out.println(email);
		System.out.println(starttime);
		System.out.println(endtime);
		System.out.println(movetime);
		System.out.println(upload);
		try {
			DbDao dbDao = sqlSession.getMapper(DbDao.class);
			dbDao.runningtime(email, starttime, endtime, movetime, upload);
			returns = "runningOK";
		} catch (Exception e) {
			System.out.println(e);
			returns = "runningFAIL";
		}

		System.out.println(returns);

		// 안드로이드로 전송
		try {
			writer = response.getWriter();
			writer.println(returns);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("upload()");

		// String dir = application.getRealPath("/WEB-INF/views/upload");
		String dir = servletContext.getRealPath("resources/upload");

		// 파일 저장 경로
		System.out.println("저장경로 : " + dir);

		int max = 10 * 1024 * 1024;

		// 최대크기, dir 디렉토리에 파일을 업로드하는 multipartRequest

		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, dir, max, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String orgFileName = mr.getOriginalFileName("uploaded_file");

		String saveFileName = mr.getFilesystemName("uploaded_file");

		System.out.println(orgFileName + "이 저장되었습니다.");
	}

	@RequestMapping("/Androidsearch")
	public String Androidsearch() {
		return "/androidDB4";
	}
}