interface Animal{
	void cry();
}

class Cat2 implements Animal{
	public void cry() {
		System.out.println("야-옹-");
	}
}

class Dog2 implements Animal{
	public void cry() {
		System.out.println("왈왈 크르릉 커엌ㅇ컹");
	}
}

public class ClassObjectCheck2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Cat2 cat = new Cat2();
		Animal cat = new Cat2();
		Animal dog = new Dog2();
		
		checkAnimal(cat);
//		checkAnimal(dog);
	}
	
	public static void checkAnimal(Animal animal) {
		if (animal instanceof Cat2) {
			System.out.println("고양이");
			animal.cry();
		}else if(animal instanceof Dog2) {
			System.out.println("강아지");
			animal.cry();
		}
	}
}
