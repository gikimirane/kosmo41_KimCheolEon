class Box<T>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

public class B02PrimitivesAndGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box<Integer> iBox = new Box<Integer>();
		//타입 인자로 기본형 x - 래퍼클래스가 필요한 이유
//		Box<int> iBox = new Box<Integer>();
		
		iBox.set(125);			//오토 박싱
		int num = iBox.get();	//오토 언박싱
		System.out.println(num);
	}
}
