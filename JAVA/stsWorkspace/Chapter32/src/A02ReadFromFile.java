import java.io.*;

public class A02ReadFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			InputStream in;
			in = new FileInputStream("data.dat");

			int dat = in.read();
			in.close();
			System.out.println(dat);
			System.out.printf("%c", dat);
			// ASCII -> Character code로 찍힘 : 대문자 A
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
