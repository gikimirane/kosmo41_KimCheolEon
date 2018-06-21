
public class ArithOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 3;
		int num2 = 7;
		//일부러 숫자 바꿈 - 못나눌때를 알아보는게 더 좋으니까.
		
		System.out.println("num1 + num2 = " + (num1 + num2)); //10
		System.out.println("num1 - num2 = " + (num1 - num2)); //-4
		System.out.println("num1 * num2 = " + (num1 * num2)); //21
		System.out.println("num1 / num2 = " + (num1 / num2)); //0
		System.out.println("num1 % num2 = " + (num1 % num2)); //3 - 못나누니까 몫이 바로 튀어나감
	}

}
