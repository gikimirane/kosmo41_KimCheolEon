import java.io.*;

public class A05WTryWithResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (OutputStream out = new FileOutputStream("data.dat")) {
			out.write(65);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
