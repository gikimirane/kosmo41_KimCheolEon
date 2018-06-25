/*
1이상 100미만의 정수중에서 7의배수와 9의배수를 출력하는 프로그램을 작성하라.
단, 7의 배수이면서 동시에 9의 배수인 정수는 한번만 출력해야 한다.
-> 한번만 나온다는게 무슨 소리인가?
*/

public class Ch05Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-3. 1이상 100미만 정수 - 7의배수와 9의배수 출력 & 7&9 공배수는 한번만");

		for (int i = 1; i < 100; i++) {

			
			//방법1
/*			if ((i % 7) == 0 && (i % 9) == 0) {
				System.out.println("7 & 9 의 공배수 출력 : " + i);
			} else if ((i % 7) == 0) {
				System.out.println("7의 배수 출력 : " + i);
			} else if ((i % 9) == 0) {
				System.out.println("9의 배수 출력 : " + i);
			}*/

			
			//방법2
			/*if ((i % 7) == 0 && (i % 9) == 0) {
				System.out.println("7 & 9 의 공배수 출력 : " + i);
				continue;
			}
			if ((i % 7) == 0) {
				System.out.println("7의 배수 출력 : " + i);
				continue;
			}
			if ((i % 9) == 0) {
				System.out.println("9의 배수 출력 : " + i);
				continue;
			}*/
			
			//방법3
			//숫자만 나열해도 상관 없다는 걸 이해못했음
			//문제중에서 하나만 출력하라는 소리는, 논리연산에서 뒤에 연산을 캔슬하는 의도임
			if ((i % 7) == 0 || (i % 9) == 0) {
				System.out.println("숫자 : " + i);
			}
		}
	}
}