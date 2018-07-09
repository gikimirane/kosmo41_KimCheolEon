import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A03WriteFinally {

	// public static void main(String[] args) throws IOException {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OutputStream out = null;

		try {
			out = new FileOutputStream("data.dat");
			// ASCII 코드값으로 들어감. 65 : 대문자 A
			out.write(65);

		} catch (IOException e) {

		} finally {
			if (out != null) {
				// out.close();
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}
