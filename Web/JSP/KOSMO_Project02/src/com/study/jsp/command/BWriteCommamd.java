package com.study.jsp.command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BWriteCommamd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

//		http://cusmaker.tistory.com/110?category=468137

		MultipartRequest multi = null;

		int sizeLimit = 1024 * 1024 * 10; // 10MB
//		String savePath = request.getRealPath("/upload"); // deprecate 되었음, 참고 : http://cofs.tistory.com/40
		String savePath = request.getSession().getServletContext().getRealPath("/fileFolder");
		// 파일이 업로드될 실제 tomcat 폴더의 WebContent 기준
		
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String fileName = multi.getFilesystemName("filename");
		
//		fileName = nullOrEmptyToReplaceString(multi.getFilesystemName("filename"), "uptime");
//		
//		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
//		
//		int i = -1;
//		String realFileName = "-";
//		try {
//			i = fileName.lastIndexOf("."); // 파일 확장자 위치
//			realFileName = now + fileName.substring(i, fileName.length()); // 현재시간과 확장자 합치기
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		File oldFile = new File(savePath + "\\" + fileName);
//		File newFile = new File(savePath + "\\" + realFileName);

		String bName = multi.getParameter("bName");
		String bTitle = multi.getParameter("bTitle");
		String bContent = multi.getParameter("bContent");
		
		BDao dao = BDao.getInstance();

		dao.write(bName, bTitle, bContent, fileName);
	}

//	public static String nullOrEmptyToReplaceString(String str, String replaceStr) {
//		if (str == null || "".equals(str)) {
//			return replaceStr;
//		}
//		return str;
//	}
}
