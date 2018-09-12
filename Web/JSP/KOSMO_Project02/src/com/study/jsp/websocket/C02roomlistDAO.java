package com.study.jsp.websocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class C02roomlistDAO {

	private static C02roomlistDAO instance = new C02roomlistDAO();

	DataSource dataSource = null;
	PreparedStatement pstmt = null;

	private C02roomlistDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static C02roomlistDAO getInstance() {
		return instance;
	}

	// -------------------------------------------------------------------------------------

	public ArrayList<C01roomlistDTO> getRoomList() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<C01roomlistDTO> list = new ArrayList<C01roomlistDTO>();
		String sql = "select *from ROOMLIST order by RNUMBER";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				C01roomlistDTO ulist = new C01roomlistDTO();

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
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public C01roomlistDTO selectRoomList(String where, String set) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		// String sql = "select *from ROOMLIST WHERE RNAME = ?";
		String sql = "select *from ROOMLIST WHERE " + where + " = ?";

		C01roomlistDTO roomlist = new C01roomlistDTO();

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, set);

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
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return roomlist;
	}

	// 방 만들기(INSERT)
	public boolean insertRoom(C01roomlistDTO roomDO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into ROOMLIST(RNUMBER, RNAME, RMAX, RHIDDEN, RPASS, RUSERCOUNT) values(ROOM_NUM.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomDO.getRNAME());
			pstmt.setString(2, roomDO.getRMAX());
			pstmt.setString(3, roomDO.getRHIDDEN());
			pstmt.setString(4, roomDO.getRPASS());
			pstmt.setString(5, "1");

			pstmt.executeUpdate();

//			sql한번 셀렉트
//			반환값 챙겨서
//			하여튼 반환 스트링이든 정수든 ㅇㅇ

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_insertRoom] : " + e);
			return false;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	// 방 부숴버리기
	public boolean deleteRoom(String RNUMBER) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from ROOMLIST where RNUMBER = ?";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RNUMBER);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_deleteRoom] : " + e);
			return false;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public boolean updateRoom(String SETCOUNT, String whereRNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update roomlist set RUSERCOUNT = ? where RNUMBER = ?";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, SETCOUNT);
			pstmt.setString(2, whereRNum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[roomlistDAO_updateRoom] : " + e);
			return false;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
}
