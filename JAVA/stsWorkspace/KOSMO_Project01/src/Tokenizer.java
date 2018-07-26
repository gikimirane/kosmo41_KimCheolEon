import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 String msg = "김 철 언 : /to 김철언2 테스트메시지 입니다.!@#$";
//		String msg = "김 철 언:zz";
		String msg = "김철언 : /to 김철언 테 스 트 메 시 지  입니다.!@#$";

		StringTokenizer test = new StringTokenizer(msg, " ");
		
//		System.out.println(test.hasMoreTokens());
//		System.out.println(test.nextToken());
//		System.out.println(test.nextToken());

//		if (test.hasMoreTokens()) {
//			test.nextToken();
//			test.nextToken(" ");
//						
//			System.out.println(test.nextToken());
//		}
		
		test.nextToken();
		test.nextToken();
		test.nextToken();
		String toName = test.nextToken();
		String toBody = test.nextToken("").trim();
//		String toBody = "";
//		while(test.hasMoreTokens()) {
//			toBody += test.nextToken();
//		}
		System.out.println(toBody);

	}

}
