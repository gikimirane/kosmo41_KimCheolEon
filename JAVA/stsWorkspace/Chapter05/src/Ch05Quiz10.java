import java.util.Scanner;

public class Ch05Quiz10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-10. 상황에 따라 num1~num2덧셈. 또는 num2~num1 덧셈");

		Scanner scan = new Scanner(System.in);
		int scanNum1 = 0;
		int scanNum2 = 0;
		int buffer = 0;

		System.out.println("정수 1 입력 : ");
		scanNum1 = scan.nextInt();

		System.out.println("정수 2 입력 : ");
		scanNum2 = scan.nextInt();

		if (scanNum1 > scanNum2) {
			for (int i = scanNum1; i >= scanNum2; i--) {
				System.out.print(i);
				buffer += i;
				if (i == scanNum2) {// 굳이 쓸데없이 이걸 넣은 이유는 + 기호를 중단시켜버리려고.
					break;
				}
				System.out.print(" + ");
			}
			System.out.print("\n");
			System.out.println("총 합(역순) : " + buffer);
		} else {
			for (int i = scanNum1; i <= scanNum2; i++) {
				System.out.print(i);
				buffer += i;
				if (i == scanNum2) {
					break;
				}
				System.out.print(" + ");
			}
			System.out.print("\n");
			System.out.println("총 합(정순) : " + buffer);
		}
		// for(int i = scanNum1; i <= scanNum2; i++) {
		// System.out.println(i);
		// buffer += scanNum1;
		// }
		// System.out.println("더했당(정순) : " +buffer);

		// if(scanNum1 < scanNum2) {
		// for(int i = scanNum2; i < scanNum1; i++) {
		// System.out.print(i);
		// }
		// System.out.println("총 합 : " + buffer);
		// System.out.println("정수 2가 더 큼");
		// }
		// else {
		//// for(int i = scanNum1; i < scanNum2; i++) {
		//// System.out.print(i);
		//// System.out.print(" + ");
		//// buffer += i;
		//// }
		//// System.out.println("총 합 : " + buffer);
		// System.out.println("정수 1이 큼(정상)");
		// }
	}
}
