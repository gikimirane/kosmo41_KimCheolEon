/*�������� ����ϵ� ¦���ܸ� ����ϵ��� ���α׷��� �ۼ��϶�.
��, 2���� 2*2������, 4���� 4*4������....8���� 8*8������ ����ؾ� �Ѵ�.
( ��, for������ 2�� �����ϴ� �� �ȵ� !!!!)
*/

public class Ch05Quiz05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("���� 5-5. ¦���� ��� ������. ��, ���ڸ��� �ش� �ܱ�����(~2*2, ~4*4)");
		
		for (int i = 1; i < 10; i++) {
			if ((i % 2) != 0) {
				continue;
			}
			System.out.println(i + "��---------------------");
			for (int j = 1; j <= i; j++) {
				
				System.out.println(i + " X " + j + " = " + (i * j));
			}
		}
	}
}
