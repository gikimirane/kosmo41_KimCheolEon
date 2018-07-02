
public class B02ThrowableClassTryCatch {

	public static void md1(int n) {
		md2(n, 0);		// 이 지점에서 md2로부터 예외가 넘어옴
	}
	
	public static void md2(int n1, int n2) {
		r = n1 / n2;	// 예외 발생지점
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			md1(3);	
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Good Bye~~!");
	}

}
