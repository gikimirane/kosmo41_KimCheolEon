class Apple5{
	public String toString() {
		return "I am an apple.";
	}
}

class Orange5{
	public String toString() {
		return "I am an orange.";
	}
}

class Box5<T>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

public class A05FruitBoxGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box5<Apple5> aBox = new Box5<Apple5>();
		Box5<Orange5> oBox = new Box5<Orange5>();
		
		//과일을 박스에 담는다. 올바른 제네릭 [1]
//		aBox.set(new Apple5());
//		oBox.set(new Orange5());
		
		// Problem2 에서 패스됬던 문제가 체크됨 [2]
		aBox.set("Apple");
		oBox.set("Orange");
		
		//박스에서 과일을 꺼내는데 형변환하지 않는다
		Apple5 ap = aBox.get();
		Orange5 og = oBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}
}
