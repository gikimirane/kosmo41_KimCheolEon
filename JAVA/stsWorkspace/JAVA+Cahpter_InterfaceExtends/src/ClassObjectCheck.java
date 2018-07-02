interface Cry{
	void cry();
}

class Cat implements Cry{
	public void cry() {
		System.out.println("야-옹-");
	}
}

class Dog{
	public void cry() {
		System.out.println("왈왈 크르릉 커엌ㅇ컹");
	}
}

public class ClassObjectCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		
		// 오브젝트가 클래스의 오브젝트인지를 조사하기 위한 연산자
		// boolean flag = c instanceof x; : 오브젝트가 클래스 또는 서브클래스 오브젝트면 true 반환
		if(cat instanceof Cry) {
			cat.cry();
		}
		
		if(dog instanceof Dog) {
			dog.cry();			
		}
	}
}
