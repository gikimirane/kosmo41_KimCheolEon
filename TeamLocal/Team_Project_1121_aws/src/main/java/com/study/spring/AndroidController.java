package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.study.spring.signup.dao.DbDao;
import com.study.spring.signup.dto.signupDto;

@Controller
public class AndroidController {

	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);

	@Autowired
	private SqlSession sqlSession;
	private HttpSession session = null;

	@Autowired
	private ServletContext servletContext;

	ArrayList<ArrayList<JSONObject>> jsonArrayTotal = new ArrayList<ArrayList<JSONObject>>();
	ArrayList<JSONObject> jsonsubArray = new ArrayList<JSONObject>();
	JSONArray jsonMainArray;
	JSONObject jsonObject;

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

		String getLat = "";
		String getLong = "";

		String email = request.getParameter("email");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String movetime = request.getParameter("move");
		String upload = request.getParameter("upload");
		String map = request.getParameter("map");

		ArrayList[] height = new ArrayList[5];
		String[] mapString = { "nodata", "nodata", "nodata", "nodata", "nodata" };

//		email = "kchy12345@gmail.com";
//		starttime = "2018/11/22 11:33:39";
//		endtime = "2018/11/22 11:33:42";
//		movetime = "0분 3초";
//		upload = "running20181122113343.png";
//		map = "[{\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}, {\"lat\":\"37.5795746\",\"long\":\"125.8780912\"}]";
//
//		System.out.println(email);
//		System.out.println(starttime);
//		System.out.println(endtime);
//		System.out.println(movetime);
//		System.out.println(upload);
//		System.out.println(map);

		jsonMainArray = new JSONArray(map);

		if (jsonMainArray.length() > 85) {
			System.out.println("jsonMainArray.length() over! : " + jsonMainArray.length());

			for (int i = 0; i < jsonMainArray.length(); i++) {
				jsonObject = jsonMainArray.getJSONObject(i);
				jsonsubArray.add(jsonObject);
				System.out.println("jsonsubArray.size() : " + jsonsubArray.size());

				if (jsonsubArray.size() > 85) {
					jsonArrayTotal.add(jsonsubArray);
					jsonsubArray = new ArrayList<JSONObject>();
				}
			}
		}

		jsonArrayTotal.add(jsonsubArray);

		for (int i = 0; i < jsonArrayTotal.size(); i++) {
			if (jsonArrayTotal.get(i) == null) {
				continue;
			}
			height[i] = jsonArrayTotal.get(i);
			mapString[i] = String.valueOf(height[i]);
		}

//		System.out.println(map);
//		System.out.println("mapLength : " + map.length());
//		System.out.println("jsonMainArray : " + jsonMainArray.length());
//		System.out.println(jsonArrayTotal);
//		System.out.println("jsonArrayTotal.size() : " + jsonArrayTotal.size());
//		System.out.println("jsonArrayTotal.get(0) : " + jsonArrayTotal.get(0));
//		System.out.println("jsonArrayTotal.get(1) : " + jsonArrayTotal.get(1));
//		System.out.println("jsonArrayTotal.get(2) : " + jsonArrayTotal.get(2));
//		System.out.println("height[0] : " + height[0]);
//		System.out.println("height[1] : " + height[1]);
//		System.out.println("height[2] : " + height[2]);
//		System.out.println("height[3] : " + height[3]);
//		System.out.println("height[4] : " + height[4]);
//		System.out.println("mapString[0] : " + mapString[0]);
//		System.out.println("mapString[1] : " + mapString[1]);
//		System.out.println("mapString[2] : " + mapString[2]);
//		System.out.println("mapString[3] : " + mapString[3]);
//		System.out.println("mapString[4] : " + mapString[4]);

		try {
			DbDao dbDao = sqlSession.getMapper(DbDao.class);
			dbDao.runningtime(email, starttime, endtime, movetime, upload, mapString[0], mapString[1], mapString[2],
					mapString[3], mapString[4]);
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