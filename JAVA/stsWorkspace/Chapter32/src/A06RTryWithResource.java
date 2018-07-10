import java.io.*;

public class A06RTryWithResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (InputStream in = new FileInputStream("data.dat")) {
			int dat = in.read();
			System.out.println(dat);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
