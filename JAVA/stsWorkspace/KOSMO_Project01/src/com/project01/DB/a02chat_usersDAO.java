package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class a02chat_usersDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

	void connect() {
		try {
			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(jdbc_url, "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[chat_usersDAO_conn] : " + e);
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
	
	public boolean insertCHAT_users(a02chat_usersDO chusers) {
		connect();

		String sql = "insert into CHAT_USERS(NAME, LOCATION, ROOMADMIN) values(?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chusers.getNAME());
			pstmt.setString(2, chusers.getLOCATION());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[insertCHAT_users] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public a02chat_usersDO selectCHAT_users() {
		connect();

		String sql = "select NAME, LOCATION, ROOMADMIN from CHAT_USERS";
		a02chat_usersDO CHusersList = new a02chat_usersDO();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			CHusersList.setNAME(rs.getString("NAME"));
			CHusersList.setLOCATION(rs.getString("LOCATION"));
			CHusersList.setROOMADMIN(rs.getString("ROOMADMIN"));
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[selectCHAT_users] : " + e);
		} finally {
			disconnect();
		}
		return CHusersList;
	}
	
	public boolean deleteCHAT_users(a02chat_usersDO chusers) {
		connect();

		String sql = "delete from CHAT_USERS where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chusers.getNAME());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[deleteCHAT_users] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
}
