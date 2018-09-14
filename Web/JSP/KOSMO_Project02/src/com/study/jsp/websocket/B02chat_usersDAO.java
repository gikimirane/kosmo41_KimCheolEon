package com.study.jsp.websocket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class B02chat_usersDAO {

	private static B02chat_usersDAO instance = new B02chat_usersDAO();

	DataSource dataSource = null;
	PreparedStatement pstmt = null;

	private B02chat_usersDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static B02chat_usersDAO getInstance() {
		return instance;
	}

	// -------------------------------------------------------------------------------------

	public void insertCHAT_USERS(String NAME) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into CHAT_USERS(NAME) values(?)";

		try {
			con = dataSource.getConnection(); // ConnectionPool

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, NAME);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void deleteCHAT_USERS(String NAME) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String query = "delete from chat_users where NAME = ?";

		try {
			con = dataSource.getConnection(); // ConnectionPool

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, NAME);

			int rn = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 우측의 유저 리스트 갱신용
	public ArrayList<B01chat_usersDTO> listCHAT_USERS() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<B01chat_usersDTO> list = new ArrayList<B01chat_usersDTO>();
		String sql = "select * from CHAT_USERS order by NAME";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				B01chat_usersDTO ulist = new B01chat_usersDTO();

				ulist.setNAME(rs.getString("NAME"));
				ulist.setLOCATION(rs.getString("LOCATION"));

				list.add(ulist);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
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

	public ArrayList<B01chat_usersDTO> checkUSERS(String where, String set) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ArrayList<B01chat_usersDTO> chuList = new ArrayList<B01chat_usersDTO>();
		String sql = "select * from CHAT_USERS where " + where + " = ?";
		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set);
			ResultSet rs = pstmt.executeQuery();

			// 이거 여기 있게 했더니 나 울기 직전까지 갔음.마ㅣㄴ어ㅏㅁ;어;ㅣㅏㄴ머아;ㅣ머나ㅣ어
//			B01chat_usersDO chusers = new B01chat_usersDO();

			while (rs.next()) {
				B01chat_usersDTO chusers = new B01chat_usersDTO();
				chusers.setNAME(rs.getString("NAME"));
				chusers.setBLOCK(rs.getString("BLOCK"));
				chusers.setLOCATION(rs.getString("LOCATION"));
				chusers.setROOMADMIN(rs.getString("ROOMADMIN"));
				chusers.setINVITE(rs.getString("INVITE"));
				chusers.setBANNLIST(rs.getString("BANNLIST"));
				chusers.setBANNWORD(rs.getString("BANNWORD"));

				chuList.add(chusers);
			}

			rs.close();

		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("Error[chat_usersDAO_checkUSERS] : " + e);
			System.out.println("[접속거부] 회원 테이블에 존재하지 않음.");
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
		return chuList;
	}

	///////////////////////////////////////////////////////////////////////////////////////////

	public boolean updateCHAT_USERS(String where, String name, String column, String set) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE CHAT_USERS SET " + column + " = ? WHERE " + where + " = ?";

		try {
			conn = dataSource.getConnection(); // ConnectionPool

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set);
			pstmt.setString(2, name);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[chat_usersDAO_updateLOGIN] : " + e);
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
