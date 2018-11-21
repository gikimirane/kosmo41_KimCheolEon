package com.study.spring.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB3 {
    private static ConnectDB3 instance = new ConnectDB3();

    public static ConnectDB3 getInstance() {
        return instance;
    }
    public ConnectDB3() {  }

    // oracle 계정
    String jdbcUrl = "jdbc:oracle:thin:@192.168.0.117:1521:xe";
    String userId = "scott";
    String userPw = "tiger";

    Connection conn = null;
    PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
    String sql = "";
    String sql2 = "";
    String returns = "a";
    
    public String connectionDB(String email) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            
            //활동기록 데이터 입력
            sql = "select * from team_running where email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeQuery();
            resultSet = pstmt.executeQuery();
            while(resultSet.next()) {
            String starttime = resultSet.getString("starttime");
            String endtime = resultSet.getString("endtime");
            String move = resultSet.getString("move");
            System.out.println("starttime: " + starttime + "\t endtime : " + endtime + "\t move : " + move);
            }
            returns = "OK";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
        return returns;
    }
}