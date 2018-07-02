import java.util.Scanner;

public class F03FinallyCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 0;
		
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		try {
			number = a / b;	
		}
		catch(Exception e) {
//			number = 0; // 이렇게 에러 해결할수도있음
		}
		finally {
			// 접속종료 등 무조건 해야 할 일. (정상작동하고 종료든, 에러든 연결끊기)
			if(b != 0) {
				number = 0;
			}			
		}
		
		System.out.println(number);

	}

}
