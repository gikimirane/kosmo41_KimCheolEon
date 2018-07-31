package com.project01.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class B02chat_usersDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

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

	// -------------------------------------------------------------------------------------

	// 최초 접속 체크 (이름 조회, 차단여부)
	public B01chat_usersDO checkUSERS(String name) {
		connect();

		String sql = "select NAME, LOGIN, BLOCK from CHAT_USERS where NAME = ?";
		B01chat_usersDO users = new B01chat_usersDO();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			users.setLOGIN(rs.getString("LOGIN"));
			users.setBLOCK(rs.getString("BLOCK"));
			
			rs.close();
			
			System.out.println("[SYSTEM] 회원 테이블 확인.");
		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error[chat_usersDAO_checkUSERS] : " + e);
			System.out.println("[접속거부] 회원 테이블에 존재하지 않음.");
		} finally {
			disconnect();
		}
		return users;
	}
	
	public boolean updateLogin(String name) {
		connect();
		
		String sql = "UPDATE CHAT_USERS SET LOGIN = 'IN' WHERE NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[chat_usersDAO_updateLogin] : " + e);
			return false;
			
		} finally {
			disconnect();
		}
		return true;
	}
	
	public boolean updateLogout(String name) {
		connect();
		
		String sql = "UPDATE CHAT_USERS SET LOGIN = 'NOTIN' WHERE NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[chat_usersDAO_updateLogout] : " + e);
			return false;
			
		} finally {
			disconnect();
		}
		return true;
	}
}
