class Apple4{
	public String toString() {
		return "I am an apple.";
	}
}

class Orange4{
	public String toString() {
		return "I am an orange.";
	}
}

class Box4{
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}


public class A04FruitBoxProblem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box4 aBox = new Box4();
		Box4 oBox = new Box4();
		
		aBox.set("Apple");
		oBox.set("Orange");
		
		//에러가 나야하는데 에러가 나질 않음
		// 객체로 던져서 객체로 받아서 출력하니까.
		// 아무튼 잠재적 위험이 내재되 있음
		System.out.println(aBox.get());
		System.out.println(oBox.get());
		// 뭐지;;
		System.out.println(aBox.get().toString());
	}
}
