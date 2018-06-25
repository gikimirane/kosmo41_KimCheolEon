import java.util.Scanner;

public class Ch05Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Scanner scan = new Scanner(System.in);
				
				System.out.println("문제5. 계속해서 정수 입력받고, 0입력시 모든 정수 더한값 출력");
						
//				int buffer = 0;
//				int i = 0;
//				while(i < 9999999) {
//					
//					System.out.println("숫자를 입력하세요.");
//					int num1 = scan.nextInt();
//					
//					buffer = buffer + num1;
//					
//					if(num1 == 0) {
//						System.out.println("0 입력, 정지");
//						break;
//					}
//					i++;			
//				}
				/////////////////////////////////////////////////////////////////
				
				int buffer = 0;
				int num1 = 0;
				do {
					System.out.println("숫자를 입력하세요.");
					num1 = scan.nextInt();
					buffer = buffer + num1;
				}while(num1 != 0);
				
				System.out.println("전체 입력값 출력 : " + buffer);

	}

}