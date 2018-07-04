//제네릭 클래스 타입 인자를 인터페이스로 제한

interface Eatable{
	public String eat();
}

class Apple8 implements Eatable{
	
	public String toString() {
		return "It String Apple";
	}
	
	public String eat() {
		return "It tastes so Good!";
	}
}

class Box8<T extends Eatable>{
	T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	//한입 먹고 반환하는 행위의 메소드로 수정?
	public T get() {
		System.out.println(ob.eat());
		return ob;
	}
}

public class B05GenericInterfaceTypeBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box8<Apple8> box = new Box8<>();
		box.set(new Apple8());
		
		Apple8 ap = box.get();
		System.out.println(ap);
	}

}
