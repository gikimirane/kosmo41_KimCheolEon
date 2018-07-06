interface Animal {
	int DOG = 1;
	int CAT = 2;
}

interface Person {
	int MAN = 1;
	int WOMAN = 2;
}

public class A02NonSafeConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 정상 호출
		who(Person.MAN);

		// 비정상 호출
		who(Animal.DOG);

	}
	public static void who(int man) {
		switch (man) {
		case Person.MAN:
			System.out.println("남성손님 입니다.");
			break;
		case Person.WOMAN:
			System.out.println("여성손님 입니다.");
			break;
		}
	}

}
