interface Hello2{
	void hello2();
}

interface Talk2{
	void talk2();
}

//class Morning implements Hello, Talk{
//	public void hello() {
//		System.out.println("안녕하세요!");
//	}
//	public void talk() {
//		System.out.println("날씨 좋네요.");
//	}
//}

interface Morning2 extends Hello2, Talk2{
//	void hello2();
}

class MAMA{
	
}

class Test2 extends MAMA implements Morning2{
	
	public void hello2() {
		System.out.println("Test");
	}
	public void talk2() {
		System.out.println("Test2");
	}
	
}

public class A04Test_InferfaceExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Morning mor = new Morning();
//		
//		mor.hello();
//		mor.talk();
		
		Test2 test = new Test2();
		
		test.hello2();
//		test.talk();
	}

}
