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

}
