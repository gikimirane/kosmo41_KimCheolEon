import java.util.StringTokenizer;

public class TokenSubStirng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "김철언 : /list 뒤에 나올건 무엇인가?";
		
		
		System.out.println("전송된 메시지 : "+s);
		StringTokenizer test = new StringTokenizer(s, " ");
		
		//토큰1 - 보낸사람 NAME
		String sendName = test.nextToken();
		System.out.println("토큰1 : "+sendName);
		
		//토큰2 - : (콜론)
		String unWokrd = test.nextToken();
		System.out.println("토큰2 : "+unWokrd);
		
		//토큰3 - 콜론 이후 내용물 시작
		String tokenCommand = test.nextToken();
		System.out.println("토큰3 : "+tokenCommand);
		
		System.out.println("토큰4" + test.nextToken(""));
		
		//그 토큰3의 첫시작이 "/" 일때 명령어 커맨드로 구분
		if (tokenCommand.substring(0, 1).equals("/")) {
			int commandIndex = tokenCommand.length();
			System.out.println("렝스만큼 잘라낸것 : "+s.substring(commandIndex));
			
		} else {
			
		}

	}

}
