
/*
 * http://arabiannight.tistory.com/entry/361
*/

public class RecursiveCall {

	public static void main(String[] args) {

		System.out.println("sum = " + recursiveCallPlus(0));
		System.out.println("minus = " + recursiveCallMinus(10));
		recursiveCallTrue();

	}

	// 재귀호출 메서드 (1 ~ 10 합계 구하기) 1
	static int recursiveCallPlus(int sum) {

		if (sum == 10) {
			return 10;
		}

		return sum + recursiveCallPlus(sum + 1);

	}

	// 재귀호출 메서드 (1 ~ 10 합계 구하기) 2
	static int recursiveCallMinus(int minus) {

		if (minus == 1) {
			return 1;
		}

		return minus + recursiveCallMinus(minus - 1);

	}

	// 재귀호출 메서드 (특정 변수가 true 일 경우 종료 되는 메서드)
	static boolean recursiveCallTrue() {

		for (int i = 0; i <= 10; i++) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("count i = " + i);

			if (i == 10) {
				return true;
			}

		}

		return recursiveCallTrue();

	}
}
