package zoo;

public class Cat {
	
	// public makeSound - 어디든 호출 가능
	public void makeSound() {
		System.out.println("야옹");
	}
	
	// default makeHappy - 같은 패키지에서만 호출
	void makeHappy() {
		System.out.println("스마일");
	}

}
