class BoxC2<T>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

class UnboxerC2{
	public static <T> T openBox(BoxC2<T> box) {
		return box.get();
	}
}

public class C02GenericMethodMake2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoxC2<String> box = new BoxC2<>();
		box.set("My Generic Method");
		
		//원래 이게 정상인데
//		String str = UnboxerC2.<String>openBox(box);
		
		//여기도 희한하게 생략해도 된다. 위의 BoxC2 가 이미 <String>을
		// 걸렸었기 때문인듯;
		String str = UnboxerC2.openBox(box);
		System.out.println(str);
	}

}
