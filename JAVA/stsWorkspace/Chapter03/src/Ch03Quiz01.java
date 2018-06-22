import java.util.Scanner;

public class Ch03Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		Scanner scan = new Scanner(System.in);
		// Scanner 클래스의 객체 생성
		
		System.out.println("문제1. 두개 정수입력, 사칙연산 결과출력");
		
		System.out.println("첫 번째 숫자를 입력하세요.");
		int num1 = scan.nextInt();
		
		System.out.println("두 번째 숫자를 입력하세요.");
		int num2 = scan.nextInt();
		
		result1 = num1 + num2;
		result2 = num1 - num2;
		result3 = num1 * num2;
		result4 = num1 / num2;
		
		System.out.println("당신이 입력한 숫자 : " + num1 + ", " + num2);
		
		System.out.println("덧셈 : " + result1);
		System.out.println("뺄셈 : " + result2);
		System.out.println("곱셈 : " + result3);
		System.out.println("나눗셈 : " + result4);	

	}

}
