abstract class Human {
	abstract void print();
}

class Man extends Human {
//	String str;

//	Man(String str) {
//		this.str = str;
//	}

	public void print() {
//		System.out.println(str + " 생성1");
//		System.out.println(str + " 생성2");
		System.out.println("남자 생성");
	}
}

class Woman extends Human {
//	String str;

//	Woman(String str) {
//		this.str = str;
//	}

	public void print() {
//		System.out.println(str + " 생성1");
//		System.out.println(str + " 생성2");
//		System.out.println(str + " 생성3");
		System.out.println("여자 생성");
	}
}

class HumanFactory {
	public static Human Create(String str) {

		if (str == "남자") {
//			return new Man(str);
			return new Man();

		} else if (str == "여자") {
//			return new Woman(str);
			return new Woman();
		}
		return null;
	}
}

public class A06Test_Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Human h1 = HumanFactory.Create("남자");
		h1.print();

		Human h2 = HumanFactory.Create("여자");
		h2.print();

	}

}
