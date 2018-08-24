package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("html/text; charset=UTF-8");

		String id, pw, name, phone, gender;

		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = "";
		phone = "";
		gender = "";

		String query = "select * from member where id = ? and pw = ?";

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
//				id = resultSet.getString("id");
//				pw = resultSet.getString("pw");
				name = resultSet.getString("name");
				phone = resultSet.getString("phone");
				gender = resultSet.getString("gender");
			}
			
			//테스트용 이름 확인
			System.out.println(name);
			
			PrintWriter writer = response.getWriter();
			
			if(!name.equals("")) {
				System.out.println("login Success");
				
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				
				writer.println("[{\"result\":\"ok\",\"desc\":\"loginok\"}]");
				writer.close();
				
			}else {
				System.out.println("login Fail");
				
				writer.println("[{\"result\":\"fail\",\"desc\":\"계정이 존재하지 않음\"}]");
				writer.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
