
class Apple3{
	public String toString() {
		return "I am an apple.";
	}
}

class Orange3{
	public String toString() {
		return "I am an orange.";
	}
}

class Box3{
	private Object ob;
	
	public void set(Object o) {
		ob = o;
	}
	public Object get() {
		return ob;
	}
}

public class A03FruitBoxProblem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box3 aBox = new Box3();
		Box3 oBox = new Box3();
		
		// 과일을 박스에 담은 것인가?
		aBox.set("Apple");
		oBox.set("Orange");
		
		//ClassCastException - 제대로 꺼낼수 있는가?
		Apple3 ap = (Apple3)aBox.get();
		Orange3 og = (Orange3)oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}
