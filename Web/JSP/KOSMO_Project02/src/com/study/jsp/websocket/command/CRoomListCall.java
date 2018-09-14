package com.study.jsp.websocket.command;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.websocket.B01chat_usersDTO;
import com.study.jsp.websocket.C01roomlistDTO;
import com.study.jsp.websocket.C02roomlistDAO;

public class CRoomListCall implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CRoomListCall.....");

		response.setContentType("text/html;charset=UTF-8");
		
		String sResult = "";		

		C02roomlistDAO roomDAO = C02roomlistDAO.getInstance();
		ArrayList<C01roomlistDTO> list = roomDAO.getRoomList();

		int totalElements = list.size();// arrayList의 요소의 갯수를 구한다.

		for (int index = 0; index < totalElements; index++) {
			String rnumber = list.get(index).getRNUMBER();
			String rmax = list.get(index).getRMAX();
			String rusercount = list.get(index).getRUSERCOUNT();
			String rname = list.get(index).getRNAME();
			String rhidden = list.get(index).getRHIDDEN();

			sResult += "[No." + rnumber + "]    " + "[총원:" + rmax + "]    " + "[현재원:" + rusercount + "]    " + "[상태:"
					+ rhidden + "]    [" + rname + "]|";
		}

		try {
			PrintWriter writer = response.getWriter();
			writer.println("[" + "{\"result\":\"ok\",\"desc\":\"none\"," + "\"data\":\"" + sResult + "\"}" + "]");
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
