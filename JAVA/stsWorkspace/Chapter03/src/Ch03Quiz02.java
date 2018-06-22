import java.util.Scanner;

public class Ch03Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		Scanner scan = new Scanner(System.in);
		// Scanner 클래스의 객체 생성
		
		System.out.println("문제2. 한개 정수입력, 제곱 결과출력");
		
		System.out.println("숫자를 입력하세요.");
		int num1 = scan.nextInt();
				
		result = num1 * num1;
		
		System.out.println("당신이 입력한 숫자 : " + num1);
		
		System.out.println("제곱결과 : " + result);
	}

}
