interface PrintableB04{
	void print(String doc);
	// default method 가 존재함으로써, implements 한 친구들이
	// 해당 기능이 있건 없건 오버라이딩을 하는데 문제가 없게 함.
	// 새 기능이 생겼을 때, 모든 메소드에 추상메소드를 붙이지 않아도 원활히 구동가능
	// 참고 : http://blog.eomdev.com/java/2016/03/30/default-method.html
	default void printCMYK(String doc) {}
}

class Prn731rv4 implements PrintableB04{
	@Override
	public void print(String doc) {
		System.out.println("From MD-731 printer");
		System.out.println(doc);
	}
}

class Prn909Drv4 implements PrintableB04{
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}
	
	@Override
	public void printCMYK(String doc) {
		System.out.println("From MD-909 CMTK ver");
		System.out.println(doc);
	}
}

public class B04PrinterDriverDefault {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String myDoc = "This is report about...TEST";

		PrintableB04 prn = new Prn731rv4();
		prn.print(myDoc);
		System.out.println();
		
		prn.printCMYK(myDoc);
		
		
		PrintableB04 prn2 = new Prn909Drv4();
		prn2.print(myDoc);
		System.out.println();
		
		prn2.printCMYK(myDoc);

	}

}
