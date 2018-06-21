
public class SCE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 0;
		int num2 = 0;
		boolean result;
		
		result = ((num1 += 10) < 0) && ((num2 += 10) > 0);
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2 + '\n');
		//논리곱, false 나와서 후반 연산 x
		
//		result = ((num1 += 10) > 0) && ((num2 += 10) > 0);
		result = ((num1 += 10) > 0) || ((num2 += 10) > 0);
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		//논리합, true 나와서 후반 연산 x

	}

}
