import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class connTest1{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ConnectionPool cp = null;
	
	public void select() {
		try {
			cp = ConnectionPool.getInstance();
			con = cp.getConnection();
			pstmt = con.prepareStatement("select count(*) from department");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("count : " + rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : conTestSelect");
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) cp.releaseConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error : conTestSelectClose");
			}
		}	
	}
}

class connTest2 extends Thread{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ConnectionPool cp = null;
	
	//run() 메소드 재정의
	@Override
	public void run() {
		try {
			String name = Thread.currentThread().getName();
			
			cp = ConnectionPool.getInstance();
			con = cp.getConnection();
			pstmt = con.prepareStatement("select count(*) from department");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(name + " : " + rs.getInt(1) + " : " + con);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : conTest2 run Error");
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) cp.releaseConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Error : conTest2 runClose Error");
			}
		}
	}
}


public class Main {

	public static void main(String[] args) throws InterruptedException {
		connTest1 ct = new connTest1();
		ct.select();
		
		for (int i=0; i<80; i++) {
			Thread test = new connTest2();
			test.start();
			//0.01초 슬립
			Thread.sleep(10);
			//원래는 여기서 슬립을 걸면 안됨. 그래서 불완전하고 문제가 있음. 원래는 ConnectionPool 에서 걸려야함
			//일단 땜빵
		}
		
	}

}
