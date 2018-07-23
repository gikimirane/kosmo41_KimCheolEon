import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionEx {
	
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
		boolean success = false;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", 
					"tiger");
			
//			con.setAutoCommit(false);
			
			//----------------------------------------------------
			
			String sql = "insert into test3 values((select count(*)+1 from test3), '홍길동', '11111')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("11111");

			
			sql = "insert into test3 values((select count(*)+1 from test3), '전우치', '22222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("22222");
			
//			sql = "insert into test3 values('손오공', '33333'";		//고의적 에러유도 - ) 빠짐
			sql = "insert into test3 values((select max(seqno)+1 from test3), '손오공', '33333')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("33333");
			
			success = true;		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (success) {
					System.out.println("44444 - 정상");
					con.commit();
				} else {
					System.out.println("55555 - 비정상");
					con.rollback();
				}
				
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		

	}

}
