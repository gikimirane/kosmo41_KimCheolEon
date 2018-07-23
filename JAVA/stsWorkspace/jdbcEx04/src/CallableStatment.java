import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CallableStatment {

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
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", 
					"tiger");
			
			System.out.println("---------- 프로시저 호출 전 salary 테이블 ---------");
			String sql = "select name, pay from salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name : " + rs.getString(1));
				System.out.println(", pay : " + rs.getString(2));
			}
			
			System.out.println("------------------------------------------");
			
			cstmt = con.prepareCall("{call adjust(?, ?)}");
			sql = "select name from salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cstmt.setString(1, rs.getString("name"));
				cstmt.setFloat(2, (float)0.05);
				cstmt.executeUpdate();
			}
			
			System.out.println("---------- 프로시저 호출 후 salary 테이블 ---------");
			sql = "select name, pay from salary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("name : " + rs.getString(1));
				System.out.println(", pay : " + rs.getInt(2));
			}
			
			System.out.println("------------------------------------------");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (cstmt != null) cstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
