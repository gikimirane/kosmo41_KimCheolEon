//제네릭 메소드의 정의

class BoxC<T>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class BoxFactoryC{
	public static <T> BoxC<T> makeBox(T o){
		BoxC<T> box = new BoxC<T>();
		box.set(o);
		return box;
	}
}

public class C01GenericMethodMake1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoxC<String> sBox = BoxFactoryC.makeBox("Sweet");
//		BoxC<String> sBox = BoxFactoryC.<String>makeBox("Sweet"); // 뒤에 타입 생략 가능
		//생략 못할경우엔 명확히 써줘야함 예제2 C02 참고
		System.out.println(sBox.get());
		
		BoxC<Double> dBox = BoxFactoryC.makeBox(7.59);
		System.out.println(dBox.get());
		
	}

}
