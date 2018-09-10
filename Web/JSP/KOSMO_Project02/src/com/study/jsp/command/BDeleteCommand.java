package com.study.jsp.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bId = request.getParameter("bId");

		BDao dao = BDao.getInstance();
		BDto dto = new BDto();

		String filename = request.getParameter("filename");

		String uploadFileName = request.getSession().getServletContext().getRealPath("/fileFolder") + "\\" + filename;
		
		System.out.println("uploadFileName : " + uploadFileName);

		File uploadfile = new File(uploadFileName);

		if (uploadfile.exists() && uploadfile.isFile()) {
			
			uploadfile.delete(); // 파일 삭제
		}
		dao.delete(bId);
	}

}
