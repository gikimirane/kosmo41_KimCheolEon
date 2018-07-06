interface Printable{
	void print();
}

class Papers{
	private String con;
	public Papers(String s) { con = s; }
	
	public Printable getPrinter() {
		return new Printer();
	}
	
	//클래스 정의 은닉
	private class Printer implements Printable{
		public void print() {
			System.out.println(con);
		}
	}
}

public class B02UseMemberInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Papers p = new Papers("서류 내용 : 행복합니까?");
		Printable prn = p.getPrinter();
		prn.print();
	}
}
