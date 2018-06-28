import java.util.Random;
import java.util.Scanner;

public class Ch13Quiz11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Mind Reader Game");
		System.out.println("당신이 생각한 숫자를 맞춰보겠습니다.(0 to 100 / 제시된 숫자가 크면 h, 작으면 l; 정답이면 e)");

		Random rand = new Random();

		int comHistory = 100;
		int nMax = 100;
		int nMin = 0;
		int comNumber = 50; // 발표 숫자

		Scanner scan = new Scanner(System.in);
		String userAnswer = null;

		// String[] setAnswer = new String[] {"h", "l"};
		String[] setAnswer = { "h", "l" };

		int tryNum = 0;
		while (true) {
			tryNum++;

			// 발표함 (물어봄)
			System.out.println("is it " + comNumber + " ?");
			System.out.print("Answer : ");

			userAnswer = scan.nextLine();

			System.out.println();
			// IF high
			if (userAnswer.equals(setAnswer[0])) {

				nMax = comNumber;
				comNumber = (nMin + comNumber) / 2;

				// IF low
			} else if (userAnswer.equals(setAnswer[1])) {

				nMin = comNumber;
				comNumber = (nMax + comNumber) / 2;

			} else {
				System.out.println("I'm Win!");
				System.out.println("Try Number [ " + tryNum + " ]");

				break;
			}
			System.out.println();
		}
	}
}
