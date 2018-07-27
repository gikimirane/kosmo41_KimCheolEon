package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class a01usersDAO {

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
			System.out.println("Error[usersDAO_conn] : " + e);
		}
	}

	void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error[usersDAO_dispstmt] : " + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error[usersDAO_disconn] : " + e);
			}
		}
	}

	public boolean insertUSERS(a01usersDO users) {
		connect();

		String sql = "insert into insert into USERS(NAME, BLOCK) values(?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getNAME());
			pstmt.setString(2, users.getBLOCK());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[insertUSERS] : " + e);
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public a01usersDO selectUSERS() {
		connect();

		String sql = "select NAME, BLOCK from USERS";
		a01usersDO usersList = new a01usersDO();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			usersList.setNAME(rs.getString("NAME"));
			usersList.setBLOCK(rs.getString("BLOCK"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[selectUSERS] : " + e);
		} finally {
			disconnect();
		}
		return usersList;
	}
}
