
public class Ch05Quiz12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-12. do while 사용, 1~1000 더하기 출력 실행결과 이어서");

		int countNum = 0;
		int buffer = 0;

		do {
			System.out.print(countNum);
			if (countNum != 1000) {
				System.out.print(" + ");
			}		
			buffer += countNum;
			countNum++;
		} while (countNum <= 1000);
		
		System.out.println(" = " + buffer);
	}
}
