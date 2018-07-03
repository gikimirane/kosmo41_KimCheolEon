import java.math.BigDecimal;

// 실수의 오차없는 표현을 위한 클래스

public class D02BigDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigDecimal d1 = new BigDecimal("1.6");
		BigDecimal d2 = new BigDecimal("0.1");
		
		//일반
		double d3 = 1.6;
		double d4 = 0.1;
		System.out.println("일반덧셈 결과 : " + (d3+d4));
		System.out.println("일반곱셈 결과 : " + (d3*d4));
		System.out.println();
		
		//bigDecimal
		System.out.println("Big덧셈 결과 : " + d1.add(d2));
		System.out.println("Big곱셈 결과 : " + d1.multiply(d2));

	}

}
