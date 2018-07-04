//Generic 의 상속

class Box1<T>{
	protected T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class SteelBox1<T> extends Box1<T>{
	public SteelBox1(T o) {
		ob = o;
	}
}

public class A01GenericInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 같은 타입으로만 써야함 Integer에 Simple 을 넣을수 없는 당연한 소리
		Box1<Integer> iBox = new SteelBox1<>(7959);
		Box1<String> sBox = new SteelBox1<>("Simple");
		
		System.out.println(iBox.get());
		System.out.println(sBox.get());		
	}

}
