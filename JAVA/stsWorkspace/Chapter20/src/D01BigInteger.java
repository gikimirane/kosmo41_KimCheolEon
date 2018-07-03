import java.math.BigInteger;

public class D01BigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// long 형으로 표현 가능한 값의 크기 출력
		System.out.println("최대 정수 : " + Long.MAX_VALUE);
		System.out.println("최소 정수 : " + Long.MIN_VALUE);
		System.out.println();
		
		// 매우 큰 수를 BigInteger 인스턴스로 표현
		BigInteger big1 = new BigInteger("1000000000000000000000000000000000");
		BigInteger big2 = new BigInteger("-999999999999999999999999999999999");
		
		// BigInteger 기반 덧셈 연산
		BigInteger r1 = big1.add(big2);
		System.out.println("덧셈 결과 : " + r1);

		// BigInteger 기반 곱셈 연산
		BigInteger r2 = big1.multiply(big2);
		System.out.println("곱셈 결과 : " + r2);
		
		int num = r1.intValueExact();
		System.out.println("From BigInteger : " + num);
	}
}
