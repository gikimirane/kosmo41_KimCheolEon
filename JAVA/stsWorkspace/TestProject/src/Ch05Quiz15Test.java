import java.util.Random;

class MyRandom{
	
	Random random = new Random();
	
	void print1() {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0; 
			
		while(true) {
			num1 = random.nextInt(10);
			num2 = random.nextInt(10);
			num3 = random.nextInt(10);
			
			if(num1 != num2 && num2 != num3 && num3 != num1 && num1 != 0) {
				break;
			}
		}
		System.out.println("결과 : " + num1 + num2 + num3);
		System.out.println((num1*100) + (num2*10) + num3);
	}
	
	void print2() {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int buffer = 0;
		
		while(true) {
			buffer = random.nextInt(900) + 100;
			num1 = buffer / 100;
			num2 = buffer - (num1 * 100) / 10;
			num3 = buffer - (num1 * 100) - (num2 * 10);
			
			if(num1 == 0 && num1 != num2 && num2 != num3 && num3 != num1) {
//				System.out.println("결과 : " + (num1*100) + (num2*10) + (num3));
				//이상하게 위에처럼 앞에 문자열 붙여서 붙일라하면 계산식 이상해짐
				System.out.println((num1*100) + (num2*10) + (num3));
				break;
			}
			break;
			
		}
		
		
		
	}
}

public class Ch05Quiz15Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제5-15. 랜덤한 세자리수 표현, 단 100자리, 10자리, 1자리수는 같으면 안됨");
		
		MyRandom rand = new MyRandom();
		
		rand.print1();
		System.out.println();
		rand.print2();
	}
}
