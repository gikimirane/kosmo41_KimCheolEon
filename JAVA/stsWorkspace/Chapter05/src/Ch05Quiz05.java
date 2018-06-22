/*구구단을 출력하되 짝수단만 출력하도록 프로그램을 작성하라.
단, 2단은 2*2까지만, 4단은 4*4까지만....8단은 8*8까지만 출력해야 한다.
( 단, for문에서 2씩 증가하는 것 안됨 !!!!)
*/

public class Ch05Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제 5-5. 짝수단 출력 구구단. 단, 뒷자리도 해당 단까지만(~2*2, ~4*4)");
		
		for (int i = 1; i < 10; i++) {
			if ((i % 2) != 0) {
				continue;
			}
			System.out.println(i + "단---------------------");
			for (int j = 1; j <= i; j++) {
				
				System.out.println(i + " X " + j + " = " + (i * j));
			}
		}
	}
}
