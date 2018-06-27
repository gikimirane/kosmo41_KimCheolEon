package animal;

public class Dog {
	public void welcome(zoo.Cat c) {
		c.makeSound(); // 호출 가능 (public)
//		c.makeHappy(); // 호출 불가능 (default)
	}

}
