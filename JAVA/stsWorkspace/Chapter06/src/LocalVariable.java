
public class LocalVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean ste = true;
		int num1 = 11;
		
		if(ste) {
//			int num1++;
			num1++;
			System.out.println("num1 : " + num1);			
		}
		{
			int num2 = 33;
			num2++;
			System.out.println("num2 : " + num2);
		}
//		System.out.println("num2 : " + num2);	// 상단에 {} 중괄호로 엮여서 영역 다름

	}

}
