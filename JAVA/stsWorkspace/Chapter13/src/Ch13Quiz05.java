import java.util.Scanner;

public class Ch13Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-05. 회문 판단 및 출력");

		Scanner scan = new Scanner(System.in);

		System.out.println("단어를 입력해주세요");
		String word = scan.next();

		String[] array_word = new String[word.length()]; // 스트링을 담을 배열 선언 및 크기 지정

		for (int i = 0; i < array_word.length; i++) { // 스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Character.toString(word.charAt(i));
		}
		
		for (int i = 0, j = array_word.length; i< array_word.length; i++, j--)
		
//		for(int i = 0, j = array_word.length; i < array_word.length/2; i++, j--) {
//			if(array_word[i] == )
////				한 단어씩 앞뒤에서 비교하려고했는데 일단 보류
//		}

		// 출력 테스트용… 실제 사용시 안써도 됨.
//		for (int i = 0; i < array_word.length; i++) {
//			System.out.println(array_word[i]);
//		}

	}

}
