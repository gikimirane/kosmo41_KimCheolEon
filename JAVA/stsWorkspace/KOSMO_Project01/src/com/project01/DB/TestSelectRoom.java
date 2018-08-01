package com.project01.DB;

public class TestSelectRoom {

	public static void main(String[] args) {

		String roomName = "방만들기";
		
		C02roomlistDAO roomDAO = new C02roomlistDAO();
		
		System.out.println(roomName);
		
		C01roomlistDO selectRoom = roomDAO.selectRoomList(roomName);
		System.out.println(selectRoom.getRNUMBER());
	}

}
