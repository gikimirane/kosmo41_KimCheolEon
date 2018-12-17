package com.study.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.study.spring.dao.AndroidDao;
import com.study.spring.dto.GroupRunningDto;
import com.study.spring.dto.GroupSignupDto;

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

		SHA256 sha256 = new SHA256();
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pw_hash = sha256.getSHA256(request.getParameter("pw")).toUpperCase(); 
		
		AndroidDao dbDao = sqlSession.getMapper(AndroidDao.class);
		GroupSignupDto signupDto = dbDao.connectionDB(email);
		
		try {
			if (email.equals(signupDto.getEMAIL())) {

				if (pw_hash.equals(signupDto.getPW())) {
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
		
		ArrayList<ArrayList<JSONObject>> jsonArrayTotal = new ArrayList<ArrayList<JSONObject>>();
		ArrayList<JSONObject> jsonsubArray = new ArrayList<JSONObject>();
		JSONArray jsonMainArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		ArrayList[] height = new ArrayList[5];
		String[] mapString = { "nodata", "nodata", "nodata", "nodata", "nodata" };

		try {
			jsonMainArray = new JSONArray(map);

			if (jsonMainArray.length() > 0) {
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

			try {
				AndroidDao dbDao = sqlSession.getMapper(AndroidDao.class);
				dbDao.runningtime(email, starttime, endtime, movetime, upload, mapString[0], mapString[1], mapString[2],
						mapString[3], mapString[4]);
				returns = "runningOK";
				System.out.println("complete");
			} catch (Exception e) {
				System.out.println(e);
				returns = "runningFAIL";
				System.out.println("fail");
			}

			System.out.println(returns);

			// 안드로이드로 전송
			try {
				writer = response.getWriter();
				writer.println(returns);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
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
	public void Androidsearch(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writer;
		String returns = null;

		String email = request.getParameter("email");
		System.out.println(email);

		AndroidDao dbDao = sqlSession.getMapper(AndroidDao.class);
		ArrayList<GroupRunningDto> searchDto = dbDao.runningsearch(email);

		JSONObject jsonMain = new JSONObject();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();

		for (int i = 0; i < searchDto.size(); i++) {
			String starttime = searchDto.get(i).getStartTime();
			String endtime = searchDto.get(i).getEndTime();
			String movetime = searchDto.get(i).getMoveTime();
			String upload = searchDto.get(i).getUpLoad();		
			
			// 안드로이드로 보낼 메시지를 만듬
			jsonMain.put("starttime", starttime);
			jsonMain.put("endtime", endtime);
			jsonMain.put("movetime", movetime);
			jsonMain.put("upload", upload);
			
			// 위에서 만든 각각의 객체를 하나의 배열 형태로 만듬
			jsonList.add(jsonMain);

			jsonMain = new JSONObject();

		}
		returns = jsonList.toString();
		// 안드로이드로 전송
		try {
			writer = response.getWriter();
			writer.println(returns);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/TokenCreate")
	public void TokenCreate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("TokenCreate()");

		String token = request.getParameter("token");
		String email = request.getParameter("email");

		System.out.println("token : " + token);
		System.out.println("email : " + email);

		AndroidDao dbDao = sqlSession.getMapper(AndroidDao.class);
		try {
			dbDao.keyupdate(token, email);
			System.out.println("Token insert Complete!!");
		} catch (Exception e) {
			System.out.println("Token insert Error!!!");
			System.out.println(e);
		}
	}

}