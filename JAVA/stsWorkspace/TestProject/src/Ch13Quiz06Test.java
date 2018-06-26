import java.util.Random;
import java.util.Scanner;

class BaseBall{
	
	Random rand = new Random();
	
	//TestProject Ch05Quiz15 참고
	int[] createThreeNum(int[] ThreeNum) {
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
//		ThreeNum = (num1*100) + (num2*10) + (num3);
		
		System.out.println(ThreeNum[0]);
		System.out.println(ThreeNum[1]);
		System.out.println(ThreeNum[2]);
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		ThreeNum[0] = num1 * 100;
		ThreeNum[1] = num2 * 10;
		ThreeNum[2] = num3;
		
		System.out.println(ThreeNum[0]);
		System.out.println(ThreeNum[1]);
		System.out.println(ThreeNum[2]);
		
		return ThreeNum;
	}
}

public class Ch13Quiz06Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제13-06. 숫자 야구게임");

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int [] baseballNum = new int[3]; 
		
		System.out.println("3자리 숫자를 생성하였습니다. 도전해주세요");
		BaseBall ball = new BaseBall();
		
//		int buffer = ball.createThreeNum(0);
		int[] buffer = new int[3];
		
		buffer = ball.createThreeNum(buffer);
		
//		System.out.println(buffer[0]);
//		System.out.println(buffer[1]);
//		System.out.println(buffer[2]);
	}

}
