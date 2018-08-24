package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinProcess")
public class JoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement pstmt;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";

	private String id, pw, name, phone1, phone2, phone3, gender;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPOST");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");

		String query = "insert into member values(?, ?, ?, ?, ?)";

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone1 + "-" + phone2 + "-" + phone3);
			pstmt.setString(5, gender);

			int updateCount = pstmt.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			
//			에러가 나면 catch타버림
			if (updateCount == 1) {
				System.out.println("insert Success");
				
				writer.println("[{\"result\":\"ok\",\"desc\":\"none\"}]");
				writer.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
//			system context
			response.setContentType("html/text; charset=UTF-8");
			System.out.println("insert Fail");
			
			PrintWriter writer = response.getWriter();
			writer.println("[{\"result\":\"fail\",\"desc\":\"사용중인 아이디가 있음\"}]");
			
			writer.close();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();

			} catch (Exception e2) {

			}
		}
	}

}
