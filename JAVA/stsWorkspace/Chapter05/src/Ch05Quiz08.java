import java.util.Scanner;

public class Ch05Quiz08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����5-8. 5�� ���� �� ���, 1�̸��� ���Է�");

		Scanner scan = new Scanner(System.in);
		
		int scanNum = 0;
		int buffer = 0;
		
		
		for(int i = 0; i < 5; ) {
			System.out.println("���� �Է� : ");
			scanNum = scan.nextInt();
			
			if(scanNum < 1) {
				System.out.println("1�̸� ����, ���Է��ʿ�");
				continue;
			}	
			
			buffer += scanNum;
			
			i++;				
		}
		System.out.println("5�� �� �� : " + buffer);
	}
}
