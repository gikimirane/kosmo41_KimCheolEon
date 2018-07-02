import java.util.Scanner;

public class A01ExceptionCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		
		// 예외1. N / 0
		// 예외2. 문자입력
		System.out.println("a/b...a?");
		int n1 = kb.nextInt();
		
		System.out.println("a/b...b?");
		int n2 = kb.nextInt();
		
		System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
		System.out.println("Good bye~");
	}

}
