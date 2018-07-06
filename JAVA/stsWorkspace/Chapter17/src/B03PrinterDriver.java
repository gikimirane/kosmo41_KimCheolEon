interface PrintableB03 {
	void print(String doc);
}

// 인터페이스 상속
interface ColorPrintable extends PrintableB03 {
	void printCMYK(String doc);
}


class Prn909Drv implements ColorPrintable{
	@Override
	public void print(String doc) {
		System.out.println("PrintMode : Black & White");
		System.out.println(doc);
		
	}
	
	@Override
	public void printCMYK(String doc) {
		System.out.println("PrintMode : CMYK");
		System.out.println(doc);		
	}
}

public class B03PrinterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String myDoc = "This is report about...TEST";

		ColorPrintable prn = new Prn909Drv();
		prn.print(myDoc);
		System.out.println();
		
		prn.printCMYK(myDoc);


	}

}
