/*
1이상 100미만의 정수중에서 7의배수와 9의배수를 출력하는 프로그램을 작성하라.
단, 7의 배수이면서 동시에 9의 배수인 정수는 한번만 출력해야 한다.
*/

public class Ch05Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-3. 1이상 100미만 정수 - 7의배수와 9의배수 출력 & 7&9 공배수는 한번만");
		
		for (int i = 1; i < 100; i++) {
			if ((i % 7) == 0 && (i % 9) == 0) {
				System.out.println("7 & 9 의 공배수 출력 : " + i);
			} 
			else if ((i % 7) == 0) {
				System.out.println("7의 배수 출력 : " + i);
			} 
			else if ((i % 9) == 0) {
				System.out.println("9의 배수 출력 : " + i);
			}
		}
	}
}
