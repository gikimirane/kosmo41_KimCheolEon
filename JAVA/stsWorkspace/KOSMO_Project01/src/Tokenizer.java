import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String msg = "/to 김 철 언 : ㅋㅋ";
		
		StringTokenizer to = new StringTokenizer(msg, " ");
		System.out.println(to.nextToken());
		System.out.println(to.nextToken());
		System.out.println(to.nextToken());
		String toName = to.nextToken("");
		String toBody = to.nextToken("").trim();

	}

}
