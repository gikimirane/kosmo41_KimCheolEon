package com.study.spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;

@Component("contentHandler")
public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {

//		String bId = request.getParameter("bId");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String bId = request.getParameter("bId");

//		BDao dao = BDao.getInstance();
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);

		request.setAttribute("content_view", dto);
	}

}
