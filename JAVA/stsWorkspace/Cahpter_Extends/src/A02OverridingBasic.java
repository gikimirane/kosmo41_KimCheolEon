class Animal{
	String name;
	int age;
	
	void printPet() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}

class Cat extends Animal{
	String variety;
	
	//오버라라이드 - 기능추가
	void printPet() {
		//부모거 불러와서 밑에 더 추가함
		super.printPet();
		System.out.println("종류 : " + variety);
	}
}


public class A02OverridingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		cat.name = "양순이";
		cat.age = 5;
		cat.variety = "페르시안";
		cat.printPet();
	}

}
