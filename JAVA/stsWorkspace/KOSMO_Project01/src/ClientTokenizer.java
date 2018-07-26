import java.util.StringTokenizer;

public class ClientTokenizer {

	public static void main(String[] args) {
		
		String msg = "김 철 언 : /to 수신자 ㅋㅋㅋㅋㅋ";
		
		StringTokenizer str = new StringTokenizer(msg, ":");
		
		System.out.println(str.nextToken());
		System.out.println(str.nextToken(""));
		System.out.println(str.nextToken());
		System.out.println(str.nextToken());
		System.out.println(str.nextToken());
		System.out.println(str.nextToken());
		

	}

}
