//매개변수가 둘 인 람다식

interface Calculate{
	void cal(int a, int b);
}

public class A03TwoParamNoReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculate c;
		
		//그러니까... 이 부분이 오버라이딩을 대체하는건가?
		c = (a, b) -> System.out.println(a + b); // 여기서 실행x, 식만 정해줌
		c.cal(4, 3); //덧셈 진행
		
		c = (a, b) -> System.out.println(a - b);
		c.cal(4, 3); //뺄셈
		
		c = (a, b) -> System.out.println(a * b);
		c.cal(4, 3); //곱셈
		
		//위의 것들은 연산결과가 남지 않음?
	}

}
