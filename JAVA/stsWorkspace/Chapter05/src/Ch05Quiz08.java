import java.util.Scanner;

public class Ch05Quiz08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-8. 5개 정수 합 출력, 1미만시 재입력");

		Scanner scan = new Scanner(System.in);

		int scanNum = 0;
		int buffer = 0;
		int controlCnt = 0;

		while (true) {

			System.out.println("정수 입력 : ");
			scanNum = scan.nextInt();

			if (scanNum >= 1) {
				buffer += scanNum;
				controlCnt++;
			} else {
				System.out.println("1미만 숫자, 재입력필요");
			}

			if (controlCnt == 5) {
				System.out.println("모든 조건이 완료 되어서 종료 합니다.");
				break;
				
			}

		}

		// for(int i = 0; i < 5; ) {
		// System.out.println("정수 입력 : ");
		// scanNum = scan.nextInt();
		//
		// if(scanNum < 1) {
		// System.out.println("1미만 숫자, 재입력필요");
		// continue;
		// }
		//
		// buffer += scanNum;
		//
		// i++;
		// }
		System.out.println("5개 총 합 : " + buffer);
	}
}