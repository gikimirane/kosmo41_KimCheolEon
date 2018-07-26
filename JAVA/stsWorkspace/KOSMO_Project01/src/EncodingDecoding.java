import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.StringTokenizer;

public class EncodingDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String str1 = "가나다라 마바사 abcd !@#$?★~!@#$%^&*()? ";
		
		try {
			System.out.println(str1);
			
			String encoded = URLEncoder.encode(str1, "UTF-8");
			
			System.out.println(encoded);
			
			String decoded = URLDecoder.decode(encoded, "UTF-8");
			
			System.out.println(decoded);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
