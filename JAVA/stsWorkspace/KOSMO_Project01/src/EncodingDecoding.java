import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "가나다라 마바사 abcd !@#$?★~!@#$%^&*()? ";
		
		try {
			System.out.println(str1);
			
			String encoded = URLEncoder.encode(str1, "UTF-8");
			
			System.out.println(encoded);
			
			String str2 = encoded;
			
			String decoded = URLDecoder.decode(str2, "UTF-8");
			
			System.out.println(decoded);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
