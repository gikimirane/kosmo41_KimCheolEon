interface Printable03{ //추상메소드 한개인 인터페이스
	void print(String s, int n);
}

public class D03Lambda3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Printable03 prn = (s, n) -> { System.out.println(s + n); };
		prn.print("What is Lambda? ver3 : ", 3);
	}

}
