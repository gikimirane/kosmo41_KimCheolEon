//toString 으로 배열 출력하는거랑
//enhanced for loop 로 배열 출력하는거 두가지 방법으로 출력해봄

import java.util.Arrays;
import java.util.Scanner;

class Odd_Even {

	void EvenNumber(int[] array) {

		int[] buffer = new int[5];

		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				buffer[j] = array[i];
				j++;
			}
		}
//		System.out.println("짝수 : " + Arrays.toString(buffer));
		System.out.print("짝수 : ");
		for(int i : buffer) {
			System.out.print(i + " ");
		}
	}
	
	void OddNumber(int[] array) {

		int[] buffer = new int[5];

		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				buffer[j] = array[i];
				j++;
			}
		}
		System.out.println("홀수 : " + Arrays.toString(buffer));
	}

}

public class Ch13Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-03. 길이10배열, 10개 정수 받아서 홀짝 분류하기");

		Scanner scan = new Scanner(System.in);
		Odd_Even num = new Odd_Even();
		
		int[] nArray = new int[10];

		for (int i = 0; i < nArray.length; i++) {
			System.out.println("정수를 입력하세요 : ");
			nArray[i] = scan.nextInt();
		}
		
		num.EvenNumber(nArray);
		System.out.println();
		num.OddNumber(nArray);

	}

}
