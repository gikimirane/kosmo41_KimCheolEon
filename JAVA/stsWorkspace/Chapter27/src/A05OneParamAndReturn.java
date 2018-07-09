//매개변수가 있고 반환하는 람다식2

interface HowLong{
	int len(String s); //int 반환
}

public class A05OneParamAndReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HowLong hl = s -> s.length();
		int num = hl.len("Test"); // 이와같이 연산 결과가 남는다?
		//남는다는 표현보다는 메모리 할당(이용을 한다)을 한다는게 맞겠다.
		System.out.println(hl.len("I am so happy"));
		System.out.println(num);
	}
}