import java.util.Scanner;

public class C03ReadString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("문자열 입력 : ");
		String str1 = scan.nextLine();
		
		System.out.println("문자열 입력 : ");
		String str2 = scan.nextLine();
		
		System.out.printf("입력 문자열 1 : %s \n", str1);
		System.out.printf("입력 문자열 2 : %s \n", str2);
	}
}
/*

	int		nexInt()
	byte	nextByte()
	String	nextLine() == next()
	double 	nextDouble()
	boolean nextBoolean()

*/