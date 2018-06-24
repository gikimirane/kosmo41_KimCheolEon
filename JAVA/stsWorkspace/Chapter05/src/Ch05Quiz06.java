/*[문제 05-06]
사용자로부터 정수 하나를 입력받은 후 그 수에 해당하는 구구단을 역순으로 출력하시오.	*/

import java.util.Scanner;

public class Ch05Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제5-6. 입력받은 수의 구구단 역순 출력.");
		
		// 스캐너 객체 사용
		Scanner scan = new Scanner(System.in);
		
		// 스캔받아 담을 변수 선언 및 할당
		int scanNum = 0;
		
		System.out.println("숫자를 입력하시오 > ");
		// 스캔
		scanNum = scan.nextInt();
			
		System.out.println(scanNum+"단---------------------");
		// 그 수에 해당하는 구구단 역순
		// A x B   A는 변화없고 B만 역순
		for(int j = 9; j > 0; j--) {
			System.out.println(scanNum + " X " + j + " = " + (scanNum*j));
		}
		
//		for(int i = scanNum; i > 0; ) {
//			System.out.println(i+"단---------------------");
//			for(int j = 9; j > 0; j--) {
//				System.out.println(i + " X " + j + " = " + (i*j));
//			}
//			break;
//		}
		
		/*for(int i = 9; i > 0; i--) {
			System.out.println(i+"단---------------------");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/ //9x1 단 - 단역순
		
/*		for(int i = 9; i > 0; i--) {
			System.out.println(i+"단---------------------");
			for(int j = 9; j > 0; j--) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/ //9x9 부터 완전역순
	}
}
