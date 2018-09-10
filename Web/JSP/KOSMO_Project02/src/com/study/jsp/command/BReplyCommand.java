package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MultipartRequest multi = null;
		
		int sizeLimit = 1024 * 1024 * 10; // 10MB
		
		String savePath = request.getSession().getServletContext().getRealPath("/fileFolder");
		
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String fileName = multi.getFilesystemName("filename");
		// reply_view - hidden data
//		String bId = request.getParameter("bId");
//		String bGroup = request.getParameter("bGroup");
//		String bStep = request.getParameter("bStep");
//		String bIndent = request.getParameter("bIndent");
//		////////////////////////////////////////////////////
//		
//		String bName = request.getParameter("bName");
//		String bTitle = request.getParameter("bTitle");
//		String bContent = request.getParameter("bContent");
		
		
		String bId = multi.getParameter("bId");
		String bGroup = multi.getParameter("bGroup");
		String bStep = multi.getParameter("bStep");
		String bIndent = multi.getParameter("bIndent");
		////////////////////////////////////////////////////
		
		String bName = multi.getParameter("bName");
		String bTitle = multi.getParameter("bTitle");
		String bContent = multi.getParameter("bContent");
		
		
		BDao dao = BDao.getInstance();
		
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent, fileName, request);
	}

}
