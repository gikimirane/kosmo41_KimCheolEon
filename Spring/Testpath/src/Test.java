import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Test {

	public static void main(String[] args) {

		String test = "4분 2초";
		
		int m = test.indexOf("분");
		
		String mm = test.substring(0, m);
		
		System.out.println("mm : " + mm);
		int mmConvert = Integer.parseInt(mm);
		
		System.out.println("mmNuber : " + mmConvert);

		
		
		
		String ss = test.substring(m + 2, test.length() - 1);
		System.out.println("ss : " + ss);
		
		int ssConvert = Integer.parseInt(ss);
		System.out.println("ssConvert : " + ssConvert);

	}

}
