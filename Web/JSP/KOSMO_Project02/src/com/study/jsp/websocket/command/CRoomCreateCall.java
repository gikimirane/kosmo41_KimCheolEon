package com.study.jsp.websocket.command;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.websocket.B01chat_usersDTO;
import com.study.jsp.websocket.B02chat_usersDAO;
import com.study.jsp.websocket.C01roomlistDTO;
import com.study.jsp.websocket.C02roomlistDAO;

public class CRoomCreateCall implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CRoomCreateCall.....");

		response.setContentType("text/html;charset=UTF-8");

		String sResult = "";

		String rcName = request.getParameter("rcName");
		String rcMax = request.getParameter("rcMax");
		String rcHidden = request.getParameter("rcHidden");
		String rcPass = request.getParameter("rcPass");
		if (rcPass.equals("")) {
			rcPass = null;
		}
		String inUser = request.getParameter("inUser");

		C01roomlistDTO roomDTO = new C01roomlistDTO();
		C02roomlistDAO roomDAO = C02roomlistDAO.getInstance();

		roomDTO.setRNAME(rcName);
		roomDTO.setRMAX(rcMax);
		roomDTO.setRHIDDEN(rcHidden);
		roomDTO.setRPASS(rcPass);

		C01roomlistDTO roomSelect = roomDAO.selectRoomList("RNAME", rcName);

		String roomNum = roomSelect.getRNUMBER();

		B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();

		chuDAO.updateCHAT_USERS("NAME", inUser, "LOCATION", roomNum);

		try {
			roomDAO.insertRoom(roomDTO);

			PrintWriter writer = response.getWriter();
			writer.println("[" + "{\"result\":\"ok\",\"desc\":\"none\"," + "\"data\":\"" + "생성 성공" + "\"}" + "]");
			writer.close();
		} catch (Exception e) {
			System.out.println("AccountInfoSetError :" + e);
			try {
				PrintWriter writer = response.getWriter();
				writer.println("[{\"result\":\"fail\",\"desc\":\"생성 실패\"}]");
				writer.close();
			} catch (Exception e2) {
			}
		}

	}
}
