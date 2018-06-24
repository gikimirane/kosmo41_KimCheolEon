
public class UnaryAddMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		short num1 = 5;
		System.out.println(+num1); // 연산을 했기 때문에 int 발생
		System.out.println(-num1);
		
		short num2 = 7;
//		short num3 = (+num2);
		short num3 = (short)(+num2);
		short num4 = (short)(-num2);
		System.out.println(num3);
		System.out.println(num4);

	}

}
