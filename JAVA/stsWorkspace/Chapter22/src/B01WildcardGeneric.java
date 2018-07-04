//와일드카드의 사용

class Box4<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}

	@Override
	public String toString() {
		return ob.toString();
	}
}

class Unboxer4 {
	public static <T> T openBox(Box4<T> box) {
		return box.get();
	}

	// public static <T> void peekBox(Box4<T> box) {
	// System.out.println(box);
	// }
	
	//기능적으로 위와 아래 메소드는 완전 동일
	public static void peekBox(Box4<?> box) {
		System.out.println(box);
	}
}

public class B01WildcardGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box4<String> box = new Box4<>();
		box.set("So Simple String");
		Unboxer4.peekBox(box);
	}

}
