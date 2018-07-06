interface Printable1{
	void print(String s);
}

class Printer1 implements Printable1{
	public void print(String s) {
		System.out.println(s);
	}
}

public class D01Lambda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//기본적으로 아는 인터페이스, 인터페이스 상속, 인스턴스 생성
		Printable1 prn = new Printer1();
		prn.print("What is Lambda?, ver1");
	}
}
