import java.io.*;

public class A01WriteReadFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// //파일이 없기때문에, Read 이전에 Write부터 해야함
		//
		// OutputStream out = new FileOutputStream("data.dat");
		// //ASCII 코드값으로 들어감. 65 : 대문자 A
		// out.write(65);
		// out.close();

		// 파일이 없기때문에, Read 이전에 Write부터 해야함

		try {
			OutputStream out;
			out = new FileOutputStream("data.dat");
			// ASCII 코드값으로 들어감. 65 : 대문자 A
			out.write(65);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
