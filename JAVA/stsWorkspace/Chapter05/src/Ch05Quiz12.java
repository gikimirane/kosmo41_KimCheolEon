
public class Ch05Quiz12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-12. do while 사용, 1~1000 더하기 출력 실행결과 이어서");

		int countNum = 0;
		int buffer = 0;

		do {
			countNum++;
			System.out.print(countNum);
			buffer += countNum;
			if (countNum == 1000) {// 굳이 쓸데없이 이걸 넣은 이유는 기호를 출력 중단시켜버리려고.
				break;
			}
			System.out.print(" + ");		
		} while (countNum <= 1000);
		System.out.println(" = " + buffer);
	}
}
