package com.study.jsp.websocket.command;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.websocket.B01chat_usersDTO;
import com.study.jsp.websocket.B02chat_usersDAO;
import com.study.jsp.websocket.C01roomlistDTO;
import com.study.jsp.websocket.C02roomlistDAO;

public class CRoomOutCall implements CCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("CRoomOutCall.....");

		response.setContentType("text/html;charset=UTF-8");
		
		String inUser = request.getParameter("inUser");
		
		B02chat_usersDAO chuDAO = B02chat_usersDAO.getInstance();
		B01chat_usersDTO chuDTO = new B01chat_usersDTO();
		
		System.out.println("inUser : " + inUser);
		
		// 유저선택
		ArrayList<B01chat_usersDTO> chuInfo = chuDAO.checkUSERS("NAME", inUser);
		// 유저의 이전 로케이션 획득
		String userLocation = chuInfo.get(0).getLOCATION();
		
		// 대기실로 이동
		chuDAO.updateCHAT_USERS("NAME", inUser, "LOCATION", "1");
		
		// 이전 방의 인원수 차감시작
		C02roomlistDAO roomDAO = C02roomlistDAO.getInstance();
		//이전 방 룸 선택
		System.out.println("userLocation : " + userLocation);
		
		C01roomlistDTO roomselect = roomDAO.selectRoomList("RNUMBER", userLocation);
		
		
		//이전 방 룸 정보 획득, 1차감
		int roomPersonNo = Integer.parseInt(roomselect.getRUSERCOUNT()) - 1;
		
		System.out.println("roomPersonNo : " + roomPersonNo);
		
		roomDAO.updateRoom(Integer.toString(roomPersonNo), userLocation);
			
		try {
			
			PrintWriter writer = response.getWriter();
			writer.println("[" + "{\"result\":\"ok\",\"desc\":\"none\"," + "\"data\":\"" + "대기실로 이동합니다." + "\"}" + "]");
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
