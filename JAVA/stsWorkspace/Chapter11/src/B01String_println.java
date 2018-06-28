//println 에 대한 오버라이딩 예시를 보여줌

public class B01String_println {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String st1 = new String("Simple String");
		String st2 = "The Best String";
		
		System.out.println(st1);
		System.out.println(st1.length());
		System.out.println();
		
		System.out.println(st2);
		System.out.println(st2.length());
		System.out.println();

		showString("Funny String");		
	}
	
	public static void showString(String str) {
		System.out.println(str);
		System.out.println(str.length());
	}

}
