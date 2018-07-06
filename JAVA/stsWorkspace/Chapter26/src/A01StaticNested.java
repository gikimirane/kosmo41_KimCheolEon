class Outer{
	private static int num = 0;
	static class Nested1{
		void add(int n) { num += n; } // Outer클래스의 static 변수 공유
	}
	static class Nested2{
		int get() { return num; }
	}
}

public class A01StaticNested {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer.Nested1 nst1 = new Outer.Nested1();
		nst1.add(5);
		
		Outer.Nested2 nst2 = new Outer.Nested2();
		System.out.println(nst2.get());
	}
}

// Static 네스티드 클래스는 static 선언이 갖는 특성이 반영된 클래스이다.
// 따라서 자신을 감싸는 외부 클래스의 인스턴스와 상관없이 static 네스티드
// 클래스의 인스턴스 생성이 가능하다.
