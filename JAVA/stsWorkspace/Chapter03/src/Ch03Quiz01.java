import java.util.Scanner;

public class Ch03Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		Scanner scan = new Scanner(System.in);
		// Scanner Ŭ������ ��ü ����
		
		System.out.println("����1. �ΰ� �����Է�, ��Ģ���� ������");
		
		System.out.println("ù ��° ���ڸ� �Է��ϼ���.");
		int num1 = scan.nextInt();
		
		System.out.println("�� ��° ���ڸ� �Է��ϼ���.");
		int num2 = scan.nextInt();
		
		result1 = num1 + num2;
		result2 = num1 - num2;
		result3 = num1 * num2;
		result4 = num1 / num2;
		
		System.out.println("����� �Է��� ���� : " + num1 + ", " + num2);
		
		System.out.println("���� : " + result1);
		System.out.println("���� : " + result2);
		System.out.println("���� : " + result3);
		System.out.println("������ : " + result4);	

	}

}
