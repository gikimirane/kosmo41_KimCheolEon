class Outer2{
	private int num = 0;
	
	class Member{
		void add(int n) { num += n; }
		int get() { return num; }
	}
}

public class B01InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer2 o1 = new Outer2();
		Outer2 o2 = new Outer2();
		
		Outer2.Member o1m1 = o1.new Member();
		Outer2.Member o1m2 = o1.new Member();
		
		Outer2.Member o2m1 = o2.new Member();
		Outer2.Member o2m2 = o2.new Member();
		
		// 보아하니 o1m1 과 o1m1 이 같은걸 보고있네 음...같은뿌리?
		o1m1.add(5);
		System.out.println(o1m2.get());
		
		// 여기도 o2m1 이랑 o2m2 가 같은거 보고있고
		o2m1.add(7);
		System.out.println(o2m2.get());

	}

}
