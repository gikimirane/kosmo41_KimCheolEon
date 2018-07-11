import java.net.*;
import java.io.*;

public class NetworkEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address = "https://www.google.co.kr/logos/doodles/2018/world-cup-2018-day-23-6245640538423296.3-law.gif";

		int ch = 0;

		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("test.gif");

			while ((ch = in.read()) != -1) {
				out.write(ch);
			}
			
			in.close();
			out.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
