/*[���� 05-06]
����ڷκ��� ���� �ϳ��� �Է¹��� �� �� ���� �ش��ϴ� �������� �������� ����Ͻÿ�.	*/

import java.util.Scanner;

public class Ch05Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("����5-6. �Է¹��� ���� ������ ���� ���.");
		
		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		
		System.out.println("���ڸ� �Է��Ͻÿ� > ");
		scanNum = scan.nextInt();
		
		for(int i = scanNum; i > 0; ) {
			System.out.println(i+"��---------------------");
			for(int j = 9; j > 0; j--) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			break;
		}
		
		/*for(int i = 9; i > 0; i--) {
			System.out.println(i+"��---------------------");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/ //9x1 �� - �ܿ���
		
/*		for(int i = 9; i > 0; i--) {
			System.out.println(i+"��---------------------");
			for(int j = 9; j > 0; j--) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/ //9x9 ���� ��������
	}
}