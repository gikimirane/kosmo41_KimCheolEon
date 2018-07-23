import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			String sql = "create table test2(id varchar(10), " + 
						 "					 password varchar(10))";

			pstmt = con.prepareStatement(sql);
			int updateCount = pstmt.executeUpdate();
			System.out.println("createCount : " + updateCount);

			// -----------------------------------------------------------

			sql = "insert into test2 values(?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "홍길동");
			pstmt.setString(2, "1111");
			updateCount = pstmt.executeUpdate();
			System.out.println("insertCount : " + updateCount);

			// -----------------------------------------------------------

			sql = "select * from test2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("id : " + rs.getString(1));
				System.out.println(", password : " + rs.getString(2));
			}

			// -----------------------------------------------------------

//			sql = "drop table test2";
//			pstmt = con.prepareStatement(sql);
//			updateCount = pstmt.executeUpdate();
//			System.out.println("dropCount : " + updateCount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

}
