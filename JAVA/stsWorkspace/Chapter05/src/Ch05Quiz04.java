/*두개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
1과2를 입력했다면 1 .... 20과10을 입력했다면 10 ....
위 프로그램을 if문과 조건연산자를 이용하여 작성해보자.*/

import java.util.*;

public class Ch05Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제5-4. 입력된 두 수의 차에서 항상 양수가 나오도록(앞뒤 교환)");
		
		Scanner scan = new Scanner(System.in);
		
		int scanNum1 = 0;
		int scanNum2 = 0;
		int buffer = 0;
		
		System.out.println("정수 입력 1 : ");
		scanNum1 = scan.nextInt();
			
		System.out.println("정수 입력 2 : ");
		scanNum2 = scan.nextInt();

//		방법2 : if(scanNum1 - scanNum2 < 0) {
		/*
		if(scanNum1 < scanNum2) {
			buffer = scanNum2 - scanNum1;
			System.out.println("두 수의 차(자리교환) : "+ buffer);
		}
		else {
			buffer = scanNum1 - scanNum2;
			System.out.println("두 수의 차 : "+ buffer);
		}
		
		//방법3 : 조건문해서 0보다 작으면 -1을 곱하기
		//방법4 : 삼항연산자
		/*buffer = scanNum1 - scanNum2;*/
		buffer = (scanNum1 < scanNum2) ? ((scanNum1 - scanNum2)*-1) : (scanNum1 - scanNum2);
		System.out.println("두 수의 차 : "+ buffer);
	}
}
