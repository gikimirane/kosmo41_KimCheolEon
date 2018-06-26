import java.util.Random;
import java.util.Scanner;

class BaseBall{
	
	Random rand = new Random();
	
	//TestProject Ch05Quiz15 참고
	int createThreeNum(int ThreeNum) {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int buffer = 0;
		
		while(true) {
			buffer = rand.nextInt(900) + 100;
			num1 = buffer / 100;
			num2 = buffer - (num1 * 100) / 10;
			num3 = buffer - (num1 * 100) - (num2 * 10);
			
			if(num1 != num2 && num2 != num3 && num3 != num1) {
//				System.out.println("결과 : " + (num1*100) + (num2*10) + (num3));
				//이상하게 위에처럼 앞에 문자열 붙여서 붙일라하면 계산식 이상해짐
				//System.out.println("결과 : " + (num1*100) + (num2*10) + (num3));
				break;
			}
			
		}
		ThreeNum = (num1*100) + (num2*10) + (num3);
		System.out.println(ThreeNum);
		
		return ThreeNum;
	}
}

public class Ch13Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제13-06. 숫자 야구게임");

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int [] baseballNum = new int[3]; 
		
		System.out.println("3자리 숫자를 생성하였습니다. 도전해주세요");
		BaseBall ball = new BaseBall();
		
		int buffer = ball.createThreeNum(0);
		
		System.out.printf("Test : %d", buffer);
		
		int num1 = (buffer / 100);
		int num2 = (buffer - (num1 * 100)) / 10;
		int num3 = (buffer - (num1 * 100)) - (num2 * 10);
		
		System.out.println();
		System.out.println("Test100 : " + num1);
		System.out.println("Test10 : " + num2);
		System.out.println("Test1 : " + num3);
		
		baseballNum[0] = num1;
		baseballNum[1] = num2;
		baseballNum[2] = num3;
		
		System.out.println();
		System.out.println("Test100 : " + baseballNum[0]);
		System.out.println("Test10 : " + baseballNum[1]);
		System.out.println("Test1 : " + baseballNum[2]);
		
//		System.out.println("숫자 입력 : ");
//		String word = scan.next();
//		String[] array_word = new String[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정
//		int nCount = 0;
//		for (int i = 0; i < array_word.length; i++) { // 스트링을 한글자씩 끊어 배열에 저장
//			array_word[i] = Character.toString(word.charAt(i));
//		}
		int nCount = 0;
		while(true) {
			nCount++;
			
			System.out.println("숫자 입력 : ");
			String word = scan.next();
			int[] array_word = new int[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정
			
			for (int i = 0; i < array_word.length; i++) { // 스트링을 한글자씩 끊어 배열에 저장
				array_word[i] = word.charAt(i);
			}
			
			if(baseballNum[0] == array_word[0]) {
				System.out.println("3 Strike");
				break;
			}
				

			
			
		}
		
		
		
		
	}

}
