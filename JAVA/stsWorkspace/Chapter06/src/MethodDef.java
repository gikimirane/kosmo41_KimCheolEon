
public class MethodDef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("프로그램의 시작");
		
		MethodCall(10);
		MethodCall(15);		
		
		System.out.println("프로그램의 끝");
	}
	
	public static void MethodCall(int age) {
		System.out.println("--MethodCall--");
		System.out.println("Input Age : " + age);
		
	}

}
