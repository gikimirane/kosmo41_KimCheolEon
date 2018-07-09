import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class A04ReadFinally {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStream in = null;

		try {
			in = new FileInputStream("data.dat");
			int dat = in.read();
			System.out.println(dat);
			System.out.printf("%c", dat);
			// ASCII -> Character code로 찍힘 : 대문자 A
		} finally {
			if (in != null) {
				in.close();
			}
		}

	}

}
