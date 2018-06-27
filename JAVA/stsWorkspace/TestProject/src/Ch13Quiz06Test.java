//http://egloos.zum.com/wharak/v/24491
//int 배열을 문자열로 바꾸기

//http://wakeupjava.tistory.com/entry/IntegerArrayConverter-String%EB%B0%B0%EC%97%B4%EC%9D%84-int%EB%B0%B0%EC%97%B4%EB%A1%9C-%EB%B3%80%ED%99%98
//string 배열을 int로 변환

import java.util.Random;
import java.util.Scanner;

class BaseBall {

	Random rand = new Random();

	// TestProject Ch05Quiz15 참고
	int[] createThreeNum(int[] ThreeNum) {
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int buffer = 0;

		while (true) {
			if (num1 != 0 && num1 != num2 && num2 != num3 && num3 != num1) {
				break;
			}
			
			buffer = rand.nextInt(900) + 100;
			num1 = buffer / 100;
			num2 = buffer - (num1 * 100) / 10;
			num3 = buffer - (num1 * 100) - (num2 * 10);
		}

		int Test = (num1 * 100) + (num2 * 10) + (num3);
		System.out.println("수식계산 : " + Test);

		ThreeNum[0] = num1;
		ThreeNum[1] = num2;
		ThreeNum[2] = num3;

		// System.out.println();
		// System.out.println(Test);
		// System.out.println(ThreeNum[0]);
		// System.out.println(ThreeNum[1]);
		// System.out.println(ThreeNum[2]);

		return ThreeNum;
	}
}

public class Ch13Quiz06Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-06. 숫자 야구게임");

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		int[] createNum = new int[3];
		int[] inputNum = new int[3];

		// String[] inputNum = new String[3];

		System.out.println("3자리 숫자를 생성하였습니다. 도전해주세요");
		BaseBall ball = new BaseBall();

		createNum = ball.createThreeNum(createNum);

		// System.out.println(buffer[0]);
		// System.out.println(buffer[1]);
		// System.out.println(buffer[2]);

		System.out.println("3자리 숫자를 입력해주세요 : ");
		String word = scan.next();

//		String[] array_word = new String[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정
		int[] array_word = new int[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정

		for (int i = 0; i < array_word.length; i++) { // 스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Integer.parseInt(Character.toString(word.charAt(i)));
		}

//		for (int i = 0; i < array_word.length; i++) {
//			inputNum[i] = Integer.parseInt(array_word[i]);
//		}

		// if 세자리 다른 숫자 체크해야함.
		// 
		// 배열에서, 3자리 숫자를 추출하는 방법을 계속 고민했는데 - 나는 배열에 각자 넣으려고 했고
		// 추천하는 방법은 하나의 100단위 숫자 만든 후에 나눠서 자릿수 분리
		//

		System.out.println(array_word[0]);
		System.out.println(array_word[1]);
		System.out.println(array_word[2]);

		int x = 0;
		int y = 0;
		if (x == y) {
			if (inputNum[x] == createNum[y]) {
				System.out.println("strike");
			} else {
				System.out.println("ball");
			}

		}

	}

}
