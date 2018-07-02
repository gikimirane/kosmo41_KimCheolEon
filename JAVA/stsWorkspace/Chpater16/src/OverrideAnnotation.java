//http://itpangpang.xyz/105
//오버로딩, 오버라이딩, 하이딩

class ParentAdder{
	public int add(int a, int b) {
		System.out.println("Super Add");
		return a + b;
	}
}

class ChildAdder extends ParentAdder{
//	@Override
	// 아하, 이게 있어서 오버라이드를 하려는 목적을 밝힘
	// 만약 없다면, 내가 의도한게 오버라이딩인데 오버로딩의 조건이 만족되어 오버로딩이 올바르게 진행됨
	// 일종의 표식..?
	public double add(double a, double b) {
//	public int add(int a, int b) {
		System.out.println("Sub Add");
		return a + b;
	}
}

//시그니처가 같다면 오버라이딩
//시그니처가 다르기 때문에 오버로딩이 됨
//@Override
//상위 클래스의 메서드를 오버라이딩 하는 것이 목적이라는 선언
//오버라이딩을 하는 형태가 아니라면 컴파일러가 오류 메시지 전달

public class OverrideAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParentAdder adder = new ChildAdder();
		System.out.println(adder.add(3, 4));
	}

}
