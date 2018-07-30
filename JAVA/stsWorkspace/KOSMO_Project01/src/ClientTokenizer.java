import java.util.StringTokenizer;

public class ClientTokenizer {

	public static void main(String[] args) {
		
		String s = "김철언 : /to";
		
		StringTokenizer test = new StringTokenizer(s, " ");
		System.out.println(test.nextToken());
		System.out.println(test.nextToken());
		String tokenCommand = test.nextToken();
		System.out.println(tokenCommand);
		System.out.println(test.nextToken(""));
		
		

	}

}
