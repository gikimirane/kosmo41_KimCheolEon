import java.util.Scanner;

public class Ch03Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		Scanner scan = new Scanner(System.in);
		// Scanner Ŭ������ ��ü ����
		
		System.out.println("����2. �Ѱ� �����Է�, ���� ������");
		
		System.out.println("���ڸ� �Է��ϼ���.");
		int num1 = scan.nextInt();
				
		result = num1 * num1;
		
		System.out.println("����� �Է��� ���� : " + num1);
		
		System.out.println("������� : " + result);
	}

}
