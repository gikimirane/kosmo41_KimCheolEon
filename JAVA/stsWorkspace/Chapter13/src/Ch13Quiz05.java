//회문 개선 완료

//회문 탐색할 때 false면 바로 break 걸고 나와서 아니라고 뱉어내야함

import java.util.Arrays;
import java.util.Scanner;

public class Ch13Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-05. 회문 판단 및 출력");

		Scanner scan = new Scanner(System.in);

		System.out.println("단어를 입력해주세요");
		String word = scan.next();

		String[] array_word = new String[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정
//		String[] bufferArray = new String[word.length()];

		for (int i = 0, j = array_word.length; i < array_word.length; i++, j--) { // 스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Character.toString(word.charAt(i));
//			bufferArray[j - 1] = Character.toString(word.charAt(i));
		}

		// 출력 테스트용… 실제 사용시 안써도 됨.
		for (int i = 0; i < array_word.length; i++) {
			// System.out.println(array_word[i]);
			System.out.print(array_word[i]);
		}
		System.out.println();
//		// 버퍼 출력 테스트
//		for (int i = 0; i < array_word.length; i++) {
//			// System.out.println(array_word[i]);
//			System.out.print(bufferArray[i]);
//		}

		System.out.println();

		System.out.println("원본 : " + Arrays.toString(array_word));
//		System.out.println("버퍼 : " + Arrays.toString(bufferArray));

		// 테스트 결과, 정상
		// boolean buf = array_word[0].equals(bufferArray[0]);
		// System.out.println(buf);
//		boolean Judgment = false;
		for (int i = 0; i < array_word.length / 2; i++) {
			if (array_word[i].equals(array_word[array_word.length - 1 - i])) {
				System.out.println("회문입니다");
			} else {
				System.out.println("회문이 아닙니다.");
				break;
			}
		}

//		if (Judgment == true) {
//			System.out.println("회문입니다");
//		} else {
//			System.out.println("회문이 아닙니다.");
//		}
	}
}
