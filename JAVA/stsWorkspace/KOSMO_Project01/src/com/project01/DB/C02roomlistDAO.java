package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class C02roomlistDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
//	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

	private String noThread = "00";

	void TestThread(int n) {
		if (n < 10) {
			noThread = "0" + n;
		} else {
			noThread = "" + n;
		}
	}

	void connect() {
		try {
			Class.forName(jdbc_driver);

			// ----------------------------------------------
			conn = A00ConnectionPool.getConnection("env " + noThread);
			// ----------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[usersDAO_conn] : " + e);
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error[chat_usersDAO_dispstmt] : " + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error[chat_usersDAO_disconn] : " + e);
			}
		}
	}

	public ArrayList<C01roomlistDO> getRoomList() {
		connect();

		ArrayList<C01roomlistDO> list = new ArrayList<C01roomlistDO>();
		String sql = "select *from ROOMLIST order by RNUMBER";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				C01roomlistDO ulist = new C01roomlistDO();

				ulist.setRNUMBER(rs.getString("RNUMBER"));
				ulist.setRMAX(rs.getString("RMAX"));
				ulist.setRUSERCOUNT(rs.getString("RUSERCOUNT"));
				ulist.setRNAME(rs.getString("RNAME"));
				ulist.setRHIDDEN(rs.getString("RHIDDEN"));

				list.add(ulist);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[selectUSERS_List] : " + e);
		} finally {
			disconnect();
		}
		return list;
	}

	public C01roomlistDO selectRoomList(String where, String roomName) {
		connect();

		// String sql = "select *from ROOMLIST WHERE RNAME = ?";
		String sql = "select *from ROOMLIST WHERE " + where + " = ?";

		C01roomlistDO roomlist = new C01roomlistDO();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, roomName);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			roomlist.setRNUMBER(rs.getString("RNUMBER"));
			roomlist.setRMAX(rs.getString("RMAX"));
			roomlist.setRUSERCOUNT(rs.getString("RUSERCOUNT"));
			roomlist.setRHIDDEN(rs.getString("RHIDDEN"));
			roomlist.setRNAME(rs.getString("RNAME"));
			roomlist.setRPASS(rs.getString("RPASS"));

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_selectRoomList] : " + e);
		} finally {
			disconnect();
		}
		return roomlist;
	}

	// 방 만들기(INSERT)
	public boolean insertRoom(C01roomlistDO roomDO) {
		connect();

		String sql = "insert into ROOMLIST(RNUMBER, RNAME, RMAX, RHIDDEN, RPASS, RUSERCOUNT) values(ROOM_NUM.nextval, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomDO.getRNAME());
			pstmt.setString(2, roomDO.getRMAX());
			pstmt.setString(3, roomDO.getRHIDDEN());
			pstmt.setString(4, roomDO.getRPASS());
			pstmt.setString(5, "1");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_insertRoom] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	// 방 부숴버리기
	public boolean deleteRoom(String RNUMBER) {
		connect();

		String sql = "delete from ROOMLIST where RNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RNUMBER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_deleteRoom] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public boolean updateRoom(String setNum, String whereRNum) {
		connect();
		
		String sql = "update roomlist set rusercount = ? where RNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, setNum);
			pstmt.setString(2, whereRNum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_updateRoom] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
}
