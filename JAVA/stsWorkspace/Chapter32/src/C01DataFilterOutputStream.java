import java.io.*;

public class C01DataFilterOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (DataOutputStream out = 
				new DataOutputStream(new FileOutputStream("data.dat"))) {
			out.writeInt(370); // int 형 데이터 저장
			out.writeDouble(3.14); // double 형 데이터 저장
			// 근데 헥사코드로 저장함

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
