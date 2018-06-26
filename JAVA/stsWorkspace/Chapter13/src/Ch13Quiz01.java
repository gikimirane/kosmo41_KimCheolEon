import java.util.Scanner;

class Quiz01Calc {

	void PrintMax(int[] array) {
		int buffer = 0;
		
		for (int i = 0; i < 5; i++) {
			if (array[i] > buffer) {
				buffer = array[i];
			}
		}
		System.out.println("최대값 출력 : " + buffer);
	}

	void PrintMin(int[] array) {
		int buffer = 1000;
		
		for (int i = 0; i < 5; i++) {
			if (array[i] < buffer) {
				buffer = array[i];
			}
		}
		System.out.println("최소값 출력 : " + buffer);

	}

	void PrintSum(int[] array) {
		int buffer = 0;
		
		for (int i = 0; i < 5; i++) {
			buffer += array[i];
		}
		System.out.println("총 합 출력 : " + buffer);
	}

}

public class Ch13Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-01. 길이5, 정수 5개 입력, 최대최소 모든수 합 구하기(함수사용:최대,최소,합)");

		Scanner scan = new Scanner(System.in);
		int[] nArray = new int[5];

		Quiz01Calc calc = new Quiz01Calc();

		for (int i = 0; i < nArray.length; i++) {
			System.out.println("정수를 입력하세요 : ");
			nArray[i] = scan.nextInt();
		}

		calc.PrintMax(nArray);
		calc.PrintMin(nArray);
		calc.PrintSum(nArray);

	}

}
