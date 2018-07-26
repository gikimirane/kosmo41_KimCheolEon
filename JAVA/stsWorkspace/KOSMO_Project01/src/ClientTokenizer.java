import java.util.StringTokenizer;

public class ClientTokenizer {

	public static void main(String[] args) {
		
		String msg = "/to ";
		
		StringTokenizer token = new StringTokenizer(msg, " ");

		System.out.println(msg.substring(0,1));
		
//		if(token.nextToken().equals("/to")) {
//			System.out.println(token.countTokens());
//			token.nextToken();
//			if( token.hasMoreTokens() == false) {
//				System.out.println("이제 없엉;");
//			}
//		}
		
		
//		System.out.println(token.nextToken());
//		System.out.println(token.nextToken());
		

	}

}
