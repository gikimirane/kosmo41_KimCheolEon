
/*���� 05A-02
����ڷκ��� ���� ������� ������ �Է¹��� �� ����� ���Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
1. ��� ������ �Է��� �� ����ڷκ��� �Է¹޴´�.
2. �Է¹��� ���ڸ�ŭ ������ �Է¹޴´�.(����1���� 3�̶�� �Է��ߴٸ� 3���� ������ �Է¹޾ƾ� �Ѵ�)
3. �Է¹��� ���ڵ��� ��հ��� ���Ͽ� ����Ѵ�. ��հ��� �Ҽ��� ���ϱ��� ����ؾ� �Ѵ�.*/

import java.util.*;

public class Ch05Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����5-2. �Է¹��� ��ŭ�� ������ ��հ����(�Ҽ������� ���)");

		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		int controlNum = 0;
		double buffer = 0;
		
		System.out.println("�Է¹��� ������ ���� : ");
		controlNum = scan.nextInt();

		for (int i = 0; i < controlNum; i++) {
			System.out.println("�����Է� : ");
			scanNum = scan.nextInt();
			
			buffer += scanNum;
		}
//		System.out.println("�������� �� : " + (int)(buffer));
//		System.out.println("�������� ��� : " + (buffer / controlNum));
		//���Ĺ��� �׽�Ʈ
		System.out.printf("�� : %d , ��� : %.3f", (int)buffer, (buffer / controlNum));
	}

}
