package com.project01.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class B02chat_usersDAO {

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

	public ArrayList<B01chat_usersDO> checkUSERS(String where, String set) {
		connect();
		
		ArrayList<B01chat_usersDO> chuList = new ArrayList<B01chat_usersDO>();
		String sql = "select * from CHAT_USERS where " + where + " = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set);
			ResultSet rs = pstmt.executeQuery();
			
			//이거 여기 있게 했더니 나 울기 직전까지 갔음.마ㅣㄴ어ㅏㅁ;어;ㅣㅏㄴ머아;ㅣ머나ㅣ어
//			B01chat_usersDO chusers = new B01chat_usersDO();

			while (rs.next()) {
				B01chat_usersDO chusers = new B01chat_usersDO();
				chusers.setNAME(rs.getString("NAME"));
				chusers.setLOGIN(rs.getString("LOGIN"));
				chusers.setBLOCK(rs.getString("BLOCK"));
				chusers.setLOCATION(rs.getString("LOCATION"));
				chusers.setROOMADMIN(rs.getString("ROOMADMIN"));
				chusers.setHOLDWHISPER(rs.getString("HOLDWHISPER"));
				chusers.setWHISPERNAME(rs.getString("WHISPERNAME"));
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
			disconnect();
		}
		return chuList;
	}

	public boolean updateCHAT_USERS(String where, String name, String column, String set) {
		connect();

		String sql = "UPDATE CHAT_USERS SET " + column + " = ? WHERE " + where + " = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set);
			pstmt.setString(2, name);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error[chat_usersDAO_updateLOGIN] : " + e);
			return false;

		} finally {
			disconnect();
		}
		return true;
	}
}
