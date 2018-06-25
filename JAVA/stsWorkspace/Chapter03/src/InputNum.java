import java.util.*;

public class InputNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner scan = new Scanner(System.in);
		// Scanner 클래스의 객체 생성
		
		System.out.println("문제1. 두개 정수입력, 사칙연산 결과출력");
		
		System.out.println("첫 번째 숫자를 입력하세요.");
		int num1 = scan.nextInt();
		
		System.out.println("두 번째 숫자를 입력하세요.");
		int num2 = scan.nextInt();
		
		System.out.println("당신이 입력한 숫자 : " + num1 + ", " + num2);
	}
}