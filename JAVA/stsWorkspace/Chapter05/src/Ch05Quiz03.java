/*
1�̻� 100�̸��� �����߿��� 7�ǹ���� 9�ǹ���� ����ϴ� ���α׷��� �ۼ��϶�.
��, 7�� ����̸鼭 ���ÿ� 9�� ����� ������ �ѹ��� ����ؾ� �Ѵ�.

-> �ѹ��� ���´ٴ°� ���� �Ҹ��ΰ�?
*/

public class Ch05Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-3. 1�̻� 100�̸� ���� - 7�ǹ���� 9�ǹ�� ��� & 7&9 ������� �ѹ���");

		for (int i = 1; i < 100; i++) {

			
			//���1
/*			if ((i % 7) == 0 && (i % 9) == 0) {
				System.out.println("7 & 9 �� ����� ��� : " + i);
			} else if ((i % 7) == 0) {
				System.out.println("7�� ��� ��� : " + i);
			} else if ((i % 9) == 0) {
				System.out.println("9�� ��� ��� : " + i);
			}*/

			
			//���2
			/*if ((i % 7) == 0 && (i % 9) == 0) {
				System.out.println("7 & 9 �� ����� ��� : " + i);
				continue;
			}
			if ((i % 7) == 0) {
				System.out.println("7�� ��� ��� : " + i);
				continue;
			}
			if ((i % 9) == 0) {
				System.out.println("9�� ��� ��� : " + i);
				continue;
			}*/
			
			//���3
			//���ڸ� �����ص� ��� ���ٴ� �� ���ظ�����
			//�����߿��� �ϳ��� ����϶�� �Ҹ���, �����꿡�� �ڿ� ������ ĵ���ϴ� �ǵ���
			if ((i % 7) == 0 || (i % 9) == 0) {
				System.out.println("���� : " + i);
			}
		}
	}
}
