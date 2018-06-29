import java.util.Scanner;

public class Ch13QuizMindReaderAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int min = 0;
		int max = 101;
		int avg;
		
		System.out.println("pick a number between 1 to 100");
		System.out.println("if the number is higher than the guess press h");
		System.out.println("if it is less than the guess press l");
		System.out.println("if my guess is correct press y");
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i<8; i ++) {
			avg = (min + max) / 2;
			System.out.println("당신이 선택한 숫자는 " + avg + " 인가요?");
			
			String str = s.nextLine();
			
			if(str.equalsIgnoreCase("y")) {
				System.out.println("정답입니다. [" + (i+1) + " 회차]");
				break;
			}
			else if(str.equalsIgnoreCase("h")) {
				min = avg;
			}
			else if(str.equalsIgnoreCase("l")) {
				max = avg;
			}
		}
		System.out.println("Good Bye :)");

	}
}
