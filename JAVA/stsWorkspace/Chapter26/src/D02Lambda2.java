interface Printable02 {
	void print(String s);
}

public class D02Lambda2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 이전에서 배운 익명클래스를 통해 선언, 생성, 리턴
		Printable02 prn = new Printable02() {
			public void print(String s) {
				System.out.println(s);
			}
		};
		/////////////////////////////////////////////////
		prn.print("What is Lambda?, ver2");
	}

}
