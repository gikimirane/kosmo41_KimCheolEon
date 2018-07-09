//매개변수가 있고 반환하는 람다식1

interface Calculate04{
	int cal(int a, int b);
}

public class A04TwoParamAndReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//return a + b 로 정해줌
		Calculate04 c;
//		c = (a, b) -> { return a + b; }; //return 중괄호 생략 불가
		c = (a, b) -> { System.out.println("test"); 
			return 1; }; //테스트용
		System.out.println(c.cal(4, 3)); //여기서 반환값 돌려받겠군...
		
		//위의 식과 달라도 된다라?
		//위랑은 완전 별도의 식으로 자리잡는듯
		c = (a, b) -> a * b; //연산결과가 남으면, 별도로 명시하지 않아도 반환됨?
		System.out.println(c.cal(4, 3));
		//리턴을 알아서 한다는 소리같음
	}
}

/*
	메서드 몸체에 해당하는 내용이 return 문이면
	그 문장이 하나이더라도 중괄호의 생략이 불가능하다
*/
