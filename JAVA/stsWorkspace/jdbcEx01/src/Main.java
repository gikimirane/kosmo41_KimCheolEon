import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PDF 의 35쪽부터~

public class Main {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
	}

	public static void main(String[] args) {
		try {
			Connection con = 
					DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe",
							"scott",
							"tiger");
			
			String sb = "select * from employee";
//			Statement stmt = con.createStatement();
			PreparedStatement psmt = con.prepareStatement(sb);
//			StringBuffer sb = new StringBuffer();
//			sb.append("select * from employee");
			
//			ResultSet rs = stmt.executeQuery(sb.toString());
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("eno : " + rs.getInt(1) + ", ");
				System.out.println("ename : " + rs.getString("ename"));
			}
			
			rs.close();
//			stmt.close();
			psmt.close();
			con.close();
		}
		catch (Exception e){
			System.out.println("Connection Error");
			e.printStackTrace();			
		}

	}

}
