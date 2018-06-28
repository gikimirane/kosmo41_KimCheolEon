import java.util.Random;
import java.util.Scanner;

public class Ch13Quiz10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("High & Low Game");
		System.out.println("0~100 사이의 컴퓨터가 생각한 값을 맞춰주세요. (6회 제한)");

		Random rand = new Random();
		int comNumber = rand.nextInt(100) + 1;

		// Test 용
		// System.out.println("comNumber : " + comNumber);

		Scanner scan = new Scanner(System.in);
		int userNumber = 0;

		for (int i = 5; i >= 0; i--) {

			System.out.println("몇이라고 생각합니까? (0 to 100) : ");
			userNumber = scan.nextInt();

			if (userNumber > comNumber) {
				System.out.println(userNumber + " 는 제가 정한 숫자보다 큽니다 (h)");
			} else if (userNumber < comNumber) {
				System.out.println(userNumber + " 는 제가 정한 숫자보다 작습니다 (l)");
			} else {
				System.out.println("정답입니다!!");
				System.out.println("comNumber : " + comNumber);
				break;
			}

			if (i == 0) {
				System.out.println("기회가 끝났습니다.");
				System.out.println("comNumber : " + comNumber);
				System.out.println("다시 하시겠습니까? <y / n>");

				i = 5;
				
				String reStart = scan.next();

				if (reStart.equals("y")) {
					continue;
				} else{
					System.out.println("안녕히 가십시오.");
					break;
				}
			} else {
				System.out.println("남은 기회 [ " + i + " ]");
				System.out.println();
			}
		}
	}
}
