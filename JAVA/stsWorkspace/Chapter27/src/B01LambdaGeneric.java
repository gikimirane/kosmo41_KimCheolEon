//함수형 인터페이스 : 추상메소드가 딱 하나만 존재하는 인터페이스
//@FunctionalInterface : 함수형인터페이스인지 아닌지 확인함

@FunctionalInterface
interface CalculateB01 <T>{
	T cal(T a, T b);
}

public class B01LambdaGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculateB01<Integer> ci = (a, b) -> a + b;
		System.out.println(ci.cal(4, 3));
		
		CalculateB01<Double> cd = (a, b) -> a + b;
		System.out.println(cd.cal(4.32, 3.45));

	}

}
