interface Printable3 {
	void print();
}

class Papers3 {
	private String con;

	public Papers3(String s) {
		con = s;
	}

	public Printable3 getPrinter() {
		//익명클래스 만들어서 정의한다음에 생성해서 던져버림
		//이걸 확장한게 람다?
		return new Printable3() {
			public void print() {System.out.println(con);}
		};
	}
}

public class B04UseAnonymousInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Papers3 p = new Papers3("서류 내용 : 이젠 아닌듯;;");
		Printable3 prn = p.getPrinter();
		prn.print();
	}
}
