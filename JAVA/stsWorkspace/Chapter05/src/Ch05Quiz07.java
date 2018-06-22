/*[문제 05-07]
학생의 전체 평균점수에 대한 학점을 출력하는 프로그램을 작성하라.
실행시 국어, 영어, 수학의 점수를 차례로 입력받은 후 평균을 구한 후
90점이상 A, 80점이상 B, 70점이상 C, 50점이상 D, 그 미만이면 F를 출력한다.*/

import java.util.Scanner;

public class Ch05Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-7. 점수입력, 평균 및 학점출력");

		Scanner scan = new Scanner(System.in);

		float buffer = 0;
		float result = 0;

		for (int i = 0; i < 3; i++) {
			System.out.println("점수입력(국어,영어,수학 순서) : ");
			buffer += scan.nextInt();
		}
		result = buffer / 3;

		System.out.println("3과목 합 : " + buffer + ", " + "3과목 평균(소수점) : " + result);

		if (result >= 90) {
			System.out.println("학점 : A");
		} else if (result < 90 && result >= 80) {
			System.out.println("학점 : B");
		} else if (result < 80 && result >= 70) {
			System.out.println("학점 : C");
		} else if (result < 70 && result >= 50) {
			System.out.println("학점 : D");
		} else {
			System.out.println("학점 : F");
		}
	}
}
