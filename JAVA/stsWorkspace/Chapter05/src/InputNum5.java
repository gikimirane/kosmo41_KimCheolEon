import java.util.*;

public class InputNum5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����5. ����ؼ� ���� �Է¹ް�, 0�Է½� ��� ���� ���Ѱ� ���");
				
		int buffer = 0;
		int i = 0;
		while(i < 9999999) {
			
			System.out.println("���ڸ� �Է��ϼ���.");
			int num1 = scan.nextInt();
			
			buffer = buffer + num1;
			
			if(num1 == 0) {
				System.out.println("0 �Է�, ����");
				break;
			}
			i++;			
		}
		
		System.out.println("��ü �Է°� ��� : " + buffer);
	}

}
