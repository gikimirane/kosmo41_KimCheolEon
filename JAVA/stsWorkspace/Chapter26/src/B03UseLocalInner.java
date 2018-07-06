interface Printable2 { void print(); }

class Papers2{
	private String con;
	public Papers2(String s) { con = s; }

	public Printable2 getPrinter() {
		//클래스 - 메소드 - 안에다가 더 깊이 감춤
		class Printer2 implements Printable2{
			public void print() {
				System.out.println(con);
			}
		}//Printer2 만들어서 return으로 던짐
		return new Printer2();
	}
}

public class B03UseLocalInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Papers p = new Papers("서류 내용 : 행복할것인가..");
		Printable prn = p.getPrinter();
		prn.print();

	}

}
