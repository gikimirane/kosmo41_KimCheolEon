/*�ΰ��� ������ �Է� �޾Ƽ� �� ���� ���� ����ϴ� ���α׷��� �ۼ��϶�.
�� �Էµ� �� ���� ������ ������� ��°���� �׻� 0 �̻��̾�� �Ѵ�.
1��2�� �Է��ߴٸ� 1 .... 20��10�� �Է��ߴٸ� 10 ....
�� ���α׷��� if���� ���ǿ����ڸ� �̿��Ͽ� �ۼ��غ���.*/

import java.util.*;

public class Ch05Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("����5-4. �Էµ� �� ���� ������ �׻� ����� ��������(�յ� ��ȯ)");
		
		Scanner scan = new Scanner(System.in);
		
		int scanNum1 = 0;
		int scanNum2 = 0;
		int buffer = 0;
		
		System.out.println("���� �Է� 1 : ");
		scanNum1 = scan.nextInt();
			
		System.out.println("���� �Է� 2 : ");
		scanNum2 = scan.nextInt();

//		���2 : if(scanNum1 - scanNum2 < 0) {
		/*
		if(scanNum1 < scanNum2) {
			buffer = scanNum2 - scanNum1;
			System.out.println("�� ���� ��(�ڸ���ȯ) : "+ buffer);
		}
		else {
			buffer = scanNum1 - scanNum2;
			System.out.println("�� ���� �� : "+ buffer);
		}
		
		//���3 : ���ǹ��ؼ� 0���� ������ -1�� ���ϱ�
		//���4 : ���׿�����
		/*buffer = scanNum1 - scanNum2;*/
		buffer = (scanNum1 < scanNum2) ? ((scanNum1 - scanNum2)*-1) : (scanNum1 - scanNum2);
		System.out.println("�� ���� �� : "+ buffer);
	}
}
