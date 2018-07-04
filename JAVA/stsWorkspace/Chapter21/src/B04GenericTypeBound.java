//제네릭 타입 인자제한 extends 사용. doc 파일 봐서 확인해도 좋음
class Box7<T extends Number>{
	private T ob;
	
	public int toIntValue() {
		return ob.intValue();
	}
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}


public class B04GenericTypeBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box7<Integer> iBox = new Box7<>();
		iBox.set(24);
		
		Box7<Double> dBox = new Box7<>();
		dBox.set(5.97);
		
		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}

}
