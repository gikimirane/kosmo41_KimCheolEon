import java.util.Random;

//매개변수가 없는 람다식

interface Generator{
	int rand(); //매개변수가 없는 메소드
}

public class A06NoParamAndReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//해당 부분은 기능에따라 얼마든지 길어질 수도 있음
		Generator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(50);
		};
		
		System.out.println(gen.rand());

	}

}
