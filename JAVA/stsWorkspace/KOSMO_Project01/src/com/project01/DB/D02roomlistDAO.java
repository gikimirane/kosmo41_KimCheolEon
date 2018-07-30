package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class D02roomlistDAO {

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
	
	public ArrayList<D01roomlistDO> getRoomList() {
		connect();

		ArrayList<D01roomlistDO> list = new ArrayList<D01roomlistDO>();
		String sql = "select *from ROOMLIST";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				D01roomlistDO ulist = new D01roomlistDO();
				
				ulist.setRNUMBER(rs.getString("RNUMBER"));
				ulist.setRMAX(rs.getString("RMAX"));
				ulist.setRName(rs.getString("RNAME"));
				ulist.setRHIDDEN(rs.getString("RHIDDEN"));
				
//				System.out.println(rs.getString("RNUMBER"));
//				System.out.println(rs.getString("RMAX"));
//				System.out.println(rs.getString("RNAME"));
//				System.out.println(rs.getString("RHIDDEN"));

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
	
}
