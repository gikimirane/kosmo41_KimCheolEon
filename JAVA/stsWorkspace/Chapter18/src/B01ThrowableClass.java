
public class B01ThrowableClass {
	public static void md1(int n) {
		md2(n, 0);	//아래 메소드 호출
	}
	
	public static void md2(int n1, int n2) {
		r = n1 / n2;	//예외 발생 지점
		// 여기서 예외처리를 하지 않으면, 
		// 해당 메소드를 호출한 영역으로 예외가 전달됨.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		md1(3);
		System.out.println("Good Bye~~!");
	}

}
