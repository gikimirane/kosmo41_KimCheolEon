import java.util.Scanner;

public class Ch05Quiz11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-11. 입력받은 수의 팩토리얼 출력(while 사용)");

		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		int buffer = 1;
		
		System.out.println("정수 입력 : ");
		scanNum = scan.nextInt();
		
//		while(scanNum >= 1) {
//			System.out.print(scanNum);
//
//			if (scanNum != 1) {
//				System.out.print(" * ");
//			}
//			
//			buffer *= scanNum;
//			scanNum--;			
//		}
		
		while(true) {
			if(scanNum > 0) {
				System.out.print(scanNum);
				
				if(scanNum != 1) {
					System.out.print(" * ");
				}
				
				buffer *= scanNum;
				scanNum--;	
			}
			else {
				break;
			}
		}
		
		
		System.out.print("\n");
		System.out.println("결과 : " + buffer);
	}
}