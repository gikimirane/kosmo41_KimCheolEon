import java.util.Scanner;

public class Ch05Quiz10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-10. ��Ȳ�� ���� num1~num2����. �Ǵ� num2~num1 ����");

		Scanner scan = new Scanner(System.in);
		int scanNum1 = 0;
		int scanNum2 = 0;
		int buffer = 0;

		System.out.println("���� 1 �Է� : ");
		scanNum1 = scan.nextInt();

		System.out.println("���� 2 �Է� : ");
		scanNum2 = scan.nextInt();

		if (scanNum1 > scanNum2) {
			for (int i = scanNum1; i >= scanNum2; i--) {
				System.out.print(i);
				buffer += i;
				if (i == scanNum2) {// ���� �������� �̰� ���� ������ + ��ȣ�� �ߴܽ��ѹ�������.
					break;
				}
				System.out.print(" + ");
			}
			System.out.print("\n");
			System.out.println("�� ��(����) : " + buffer);
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
			System.out.println("�� ��(����) : " + buffer);
		}
		// for(int i = scanNum1; i <= scanNum2; i++) {
		// System.out.println(i);
		// buffer += scanNum1;
		// }
		// System.out.println("���ߴ�(����) : " +buffer);

		// if(scanNum1 < scanNum2) {
		// for(int i = scanNum2; i < scanNum1; i++) {
		// System.out.print(i);
		// }
		// System.out.println("�� �� : " + buffer);
		// System.out.println("���� 2�� �� ŭ");
		// }
		// else {
		//// for(int i = scanNum1; i < scanNum2; i++) {
		//// System.out.print(i);
		//// System.out.print(" + ");
		//// buffer += i;
		//// }
		//// System.out.println("�� �� : " + buffer);
		// System.out.println("���� 1�� ŭ(����)");
		// }
	}
}
