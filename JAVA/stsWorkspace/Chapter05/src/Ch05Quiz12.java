
public class Ch05Quiz12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-12. do while ���, 1~1000 ���ϱ� ��� ������ �̾");

		int countNum = 0;
		int buffer = 0;

		do {
			countNum++;
			System.out.print(countNum);
			buffer += countNum;
			if (countNum == 1000) {// ���� �������� �̰� ���� ������ ��ȣ�� ��� �ߴܽ��ѹ�������.
				break;
			}
			System.out.print(" + ");		
		} while (countNum <= 1000);
		System.out.println(" = " + buffer);
	}
}
