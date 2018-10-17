package com.study.spring.command;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//-----------------------------------------------------------------
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//-----------------------------------------------------------------
		
		// reply_view - hidden data
		String bId = request.getParameter("bId");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
//		BDao dao = BDao.getInstance();
		BDao dao = new BDao();
		
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
