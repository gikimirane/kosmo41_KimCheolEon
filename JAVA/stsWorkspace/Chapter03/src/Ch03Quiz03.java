import java.util.Scanner;

public class Ch03Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				int result1 = 0;
				int result2 = 0;
				
				Scanner scan = new Scanner(System.in);
				// Scanner 클래스의 객체 생성
				
				System.out.println("문제3. 두개 정수입력, 몫, 나머지 출력");
				
				System.out.println("첫 번째 숫자를 입력하세요.");
				int num1 = scan.nextInt();
				
				System.out.println("두 번째 숫자를 입력하세요.");
				int num2 = scan.nextInt();
				
				result1 = num1 / num2;
				result2 = num1 % num2;
				
				System.out.println("당신이 입력한 숫자 : " + num1 + ", " + num2);
				
//				System.out.println(num1 + " 나누기 " + num2 + "의 몫은 "+ result1 + "입니다");
//				System.out.println(num1 + " 나누기 " + num2 + "의 나머지는 "+ result2 + "입니다");
				System.out.printf("%d 나누기 %d 의 몫은 %d 입니다. \n", num1, num2, result1);
				System.out.printf("%d 나누기 %d 의 나머지는 %d 입니다. \n", num1, num2, result2);	

	}

}
