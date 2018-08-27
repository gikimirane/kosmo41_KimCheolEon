<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%!
		Connection con;
		PreparedStatement pstmt;
		ResultSet resultSet;
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			int n;
			String query = "insert into member values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			// insert 인데도 기묘하게 null point exception이 떠서 쭉 읽어보니, prepareStatement 쿼리문 삽입을 안함(상단)

			pstmt.setString(1, "abc");
			pstmt.setString(2, "123");
			pstmt.setString(3, "홍길동");
			pstmt.setString(4, "010-1234-5678");
			pstmt.setString(5, "man");
			n = pstmt.executeUpdate();

			pstmt.setString(1, "def");
			pstmt.setString(2, "456");
			pstmt.setString(3, "전우치");
			pstmt.setString(4, "010-4567-8901");
			pstmt.setString(5, "woman");
			n = pstmt.executeUpdate();

			pstmt.setString(1, "ghi");
			pstmt.setString(2, "789");
			pstmt.setString(3, "손오공");
			pstmt.setString(4, "010-7654-0987");
			pstmt.setString(5, "man");
			n = pstmt.executeUpdate();

			if (n == 1) {
				out.println("insert success");
			}
			/* excute실패시, if~ else 로 넘어가지 않고 catch로 넘어감. 왜냐하면 삽입 실패는
				primary 키때문에 익셉션이 바로 튀어나오기 때문임. 그래서 catch 부분에 실패 로직 넣음*/

		} catch (Exception e) {
			/* System.out.println(e.getMessage()); */
			// ORA-00001 : unique constraint ~
			if (e.getMessage().contains("ORA-00001")) {
				out.println("중복되는 회원아이디 데이터가 있습니다.");
			}
		} finally {
			try{
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
	%>
	<br>
	<a href="B02MemberView.jsp">회원정보 보기</a>
</body>
</html>