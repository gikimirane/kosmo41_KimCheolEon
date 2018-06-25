
public class LogicalOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 11;
		int num2 = 22;
		boolean result;
		
		result = (1 < num1) && (num1 < 100);
		System.out.println("num1은 1을 초과하고 100 미만인 값인가? : " + result);
		
		result = ((num2  % 2) == 0) || ((num2 % 3) == 0);
		System.out.println("num2는 2의 배수거나 3의 배수인가? : " + result);
		
		result = !(num1 != 0);
		System.out.println("num1은 0이 아닌게 아닌가?(num1은 0이 맞는가?) : " + result);
		// 부정의 부정은 긍정
	}

}
