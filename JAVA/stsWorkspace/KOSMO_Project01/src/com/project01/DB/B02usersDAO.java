package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class B02usersDAO {

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

	// 최초 접속 체크 (이름 조회, 차단여부)
	public B01usersDO checkUSERS(String name) {
		connect();

		String sql = "select * from USERS where NAME = '" + name + "'";
		B01usersDO users = new B01usersDO();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			users.setNAME(rs.getString("NAME"));
			users.setBLOCK(rs.getString("BLOCK"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[selectUSERS] : " + e);
		} finally {
			disconnect();
		}
		return users;
	}

	//
	// public boolean insertCHEAT_USERS(a01usersDO users) {
	// connect();
	//
	// String sql = "insert into insert into USERS(NAME, BLOCK) values(?, ?)";
	//
	// try {
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setString(1, users.getNAME());
	// pstmt.setString(2, users.getBLOCK());
	// pstmt.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Error[insertUSERS] : " + e);
	// return false;
	// } finally {
	// disconnect();
	// }
	// return true;
	// }

	// public boolean UsersPassCheck(String name) {
	// connect();
	//
	// String sql = "select * from USERS where NAME = '" + name + "'";
	// a01usersDO uCheckList = new a01usersDO();
	//
	// try {
	// pstmt = conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	//
	// rs.next();
	// uCheckList.setNAME(rs.getString("NAME"));
	// uCheckList.setBLOCK(rs.getString("BLOCK"));
	// rs.close();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Error[UsersPassCheck] : " + e);
	// return false;
	// } finally {
	// disconnect();
	// }
	// return true;
	// }

//	public ArrayList<B01usersDO> getUsersList() {
//		connect();
//
//		ArrayList<B01usersDO> list = new ArrayList<B01usersDO>();
//		String sql = "select NAME, BLOCK from USERS";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				B01usersDO ulist = new B01usersDO();
//
//				ulist.setNAME(rs.getString("NAME"));
//				ulist.setBLOCK(rs.getString("BLOCK"));
//
//				// //-----테스트 찍어보는중
//				// System.out.println(rs.getString("NAME"));
//				// System.out.println(rs.getString("BLOCK"));
//				// //-----테스트 찍어보는중
//
//				list.add(ulist);
//			}
//			rs.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error[selectUSERS_List] : " + e);
//		} finally {
//			disconnect();
//		}
//		return list;
//	}

	public B01usersDO selectUSERS() {
		connect();

		String sql = "select NAME, BLOCK from USERS where NAME = '김철언'";
		B01usersDO usersList = new B01usersDO();

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
