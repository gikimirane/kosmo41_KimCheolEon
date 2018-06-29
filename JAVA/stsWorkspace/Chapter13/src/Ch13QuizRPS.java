import java.util.Random;
import java.util.Scanner;

public class Ch13QuizRPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-09. 가위바위보 게임만들기");
		// 다차원 배열 문제니까, 2차원 배열 활용

		Scanner scan = new Scanner(System.in);

		String[][] mArray = { 
				{ "null", "가위", "바위", "보" }, 
				{ "가위", "비겼습니다.", "졌습니다.", "이겼습니다." },
				{ "바위", "이겼습니다.", "비겼습니다.", "졌습니다." }, 
				{ "보", "졌습니다.", "이겼습니다.", "비겼습니다." } };
		// 가위 바위 보
		// 가위 비김 졌음 이김
		// (나) 바위 이김 비김 졌음
		// 보 졌음 이김 비김
		//
		Random randrom = new Random();
		// int comRandom = randrom.nextInt(3);
		// System.out.println(num1);
		while (true) {
			int comRandom = randrom.nextInt(3) + 1;

			System.out.println("무엇을 내겠습니까? <1:가위 / 2:바위 / 3:보 / 0:끝내기>");
			int userInput = scan.nextInt();
			if (userInput >= 4) {
				System.out.println("!!!error, 재입력!!! ");
				userInput = 0;
				continue;
			}else if(userInput == 0) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			else {
				System.out.println(mArray[userInput][comRandom]);
				System.out.println("사용자 : " + mArray[userInput][0] + ", " + "컴퓨터 : " + mArray[0][comRandom]);
				System.out.println();
			}
		}
	}
}
