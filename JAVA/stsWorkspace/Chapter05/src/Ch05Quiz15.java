import java.util.Random;

public class Ch05Quiz15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제5-15. 랜덤한 세자리수 표현, 단 100자리, 10자리, 1자리수는 같으면 안됨");
		
		Random randrom = new Random();
		
		int num1 = 0;
		int num2 = 0;
		int num3 = 0; 
			
		while(true) {
			num1 = randrom.nextInt(10);
			num2 = randrom.nextInt(10);
			num3 = randrom.nextInt(10);
			
			if(num1 != num2 && num2 != num3 && num3 != num1) {
				System.out.println("결과 : " + num1 + num2 + num3);
				break;
			}
		}
	}
}
