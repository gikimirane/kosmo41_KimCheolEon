import java.util.Scanner;

public class Ch05Quiz11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-11. �Է¹��� ���� ���丮�� ���(while ���)");

		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		int buffer = 1;
		
		System.out.println("���� �Է� : ");
		scanNum = scan.nextInt();
		
		while(scanNum >= 1) {
			System.out.print(scanNum);
			if (scanNum == 1) {// ���� �������� �̰� ���� ������ ��ȣ�� ��� �ߴܽ��ѹ�������.
				break;
			}
			System.out.print(" * ");
			buffer *= scanNum;
			scanNum--;			
		}
		System.out.print("\n");
		System.out.println("��� : " + buffer);
	}
}
