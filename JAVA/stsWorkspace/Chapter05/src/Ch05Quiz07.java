/*[���� 05-07]
�л��� ��ü ��������� ���� ������ ����ϴ� ���α׷��� �ۼ��϶�.
����� ����, ����, ������ ������ ���ʷ� �Է¹��� �� ����� ���� ��
90���̻� A, 80���̻� B, 70���̻� C, 50���̻� D, �� �̸��̸� F�� ����Ѵ�.*/

import java.util.Scanner;

public class Ch05Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-7. �����Է�, ��� �� �������");

		Scanner scan = new Scanner(System.in);

		float buffer = 0;
		float result = 0;

		for (int i = 0; i < 3; i++) {
			System.out.println("�����Է�(����,����,���� ����) : ");
			buffer += scan.nextInt();
		}
		result = buffer / 3;

		System.out.println("3���� �� : " + buffer + ", " + "3���� ���(�Ҽ���) : " + result);

		if (result >= 90) {
			System.out.println("���� : A");
		} else if (result < 90 && result >= 80) {
			System.out.println("���� : B");
		} else if (result < 80 && result >= 70) {
			System.out.println("���� : C");
		} else if (result < 70 && result >= 50) {
			System.out.println("���� : D");
		} else {
			System.out.println("���� : F");
		}
	}
}
