
/*문제 05A-02
사용자로부터 다음 순서대로 정수를 입력받은 후 평균을 구하여 출력하는 프로그램을 작성하시오.
1. 몇개의 정수를 입력할 지 사용자로부터 입력받는다.
2. 입력받은 숫자만큼 정수를 입력받는다.(조건1에서 3이라고 입력했다면 3개의 정수를 입력받아야 한다)
3. 입력받은 숫자들의 평균값을 구하여 출력한다. 평균값은 소수점 이하까지 계산해야 한다.*/

import java.util.*;

public class Ch05Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문제5-2. 입력받은 만큼의 정수의 평균값출력(소수점이하 계산)");

		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		int controlNum = 0;
		double buffer = 0;
		
		System.out.println("입력받을 정수의 갯수 : ");
		controlNum = scan.nextInt();

		for (int i = 0; i < controlNum; i++) {
			System.out.println("정수입력 : ");
			scanNum = scan.nextInt();
			
			buffer += scanNum;
		}
//		System.out.println("정수들의 합 : " + (int)(buffer));
//		System.out.println("정수들의 평균 : " + (buffer / controlNum));
		//서식문자 테스트
		System.out.printf("합 : %d , 평균 : %.3f", (int)buffer, (buffer / controlNum));
	}

}