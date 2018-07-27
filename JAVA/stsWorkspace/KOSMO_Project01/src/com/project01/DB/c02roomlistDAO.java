package com.project01.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class c02roomlistDAO {
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
}
