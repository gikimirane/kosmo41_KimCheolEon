enum Animal2 {
	DOG, CAT
}

enum Person2 {
	MAN, WOMAN
}

public class A04SafeEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Animal2.DOG);
		
		//정상 호출
		who(Person2.MAN);
		
		//The method who(Person2) in the type A04SafeEnum is not applicable for the arguments (Animal2)
//		who(Animal2.DOG);
		
		//참고 : C처럼 숫자로 비교하면 에러가 난다.
		//Incompatible operand types Person2 and int
//		if (Person2.MAN == 0) {
//		}
	}
	
	public static void who(Person2 man) {
		switch (man) {
		case MAN:
			System.out.println("남성손님 입니다.");
			break;
		case WOMAN:
			System.out.println("여성손님 입니다.");
			break;
		}
	}
}
