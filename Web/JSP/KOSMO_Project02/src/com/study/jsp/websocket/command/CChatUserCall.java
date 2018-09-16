package com.study.jsp.websocket.command;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.websocket.B01chat_usersDTO;
import com.study.jsp.websocket.B02chat_usersDAO;

public class CChatUserCall implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CChatUsercall.....");

		response.setContentType("text/html;charset=UTF-8");

		B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();
		ArrayList<B01chat_usersDTO> namelist = chuDAO.listCHAT_USERS();

		String body = "";
		for (int i = 0; i < namelist.size(); i++) {
			body += namelist.get(i).getNAME() + "|";
		}

		try {
			PrintWriter writer = response.getWriter();
			writer.println("[" + "{\"result\":\"ok\",\"desc\":\"none\"," + "\"data\":\"" + body + "\"}" + "]");
			writer.close();
		} catch (Exception e) {
			System.out.println("AccountInfoSetError :" + e);
			try {
				PrintWriter writer = response.getWriter();
				writer.println("[{\"result\":\"fail\",\"desc\":\"리스트 확보 실패\"}]");
				writer.close();
			} catch (Exception e2) {
			}
		}
	}
}
