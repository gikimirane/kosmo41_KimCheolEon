import java.util.Scanner;

public class Ch03Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				int result1 = 0;
				int result2 = 0;
				
				Scanner scan = new Scanner(System.in);
				// Scanner Ŭ������ ��ü ����
				
				System.out.println("����3. �ΰ� �����Է�, ��, ������ ���");
				
				System.out.println("ù ��° ���ڸ� �Է��ϼ���.");
				int num1 = scan.nextInt();
				
				System.out.println("�� ��° ���ڸ� �Է��ϼ���.");
				int num2 = scan.nextInt();
				
				result1 = num1 / num2;
				result2 = num1 % num2;
				
				System.out.println("����� �Է��� ���� : " + num1 + ", " + num2);
				
//				System.out.println(num1 + " ������ " + num2 + "�� ���� "+ result1 + "�Դϴ�");
//				System.out.println(num1 + " ������ " + num2 + "�� �������� "+ result2 + "�Դϴ�");
				System.out.printf("%d ������ %d �� ���� %d �Դϴ�. \n", num1, num2, result1);
				System.out.printf("%d ������ %d �� �������� %d �Դϴ�. \n", num1, num2, result2);	

	}

}
