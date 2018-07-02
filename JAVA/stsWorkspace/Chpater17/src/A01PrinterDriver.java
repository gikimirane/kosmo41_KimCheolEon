// MS가 정의하고 제공한 인터페이스
interface Printable{
	public void print(String doc);
}

class SPrinterDiver implements Printable{
	public void print(String doc) {
		System.out.println("From Samsung printer");
		System.out.println(doc);
	}
}

class LGPrinterDiver implements Printable{
	@Override
	public void print(String doc) {
		System.out.println("From LG printer");
		System.out.println(doc);
	}
}

public class A01PrinterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String myDoc = "This is report about...TEST";
		
		//삼성 프린터
		Printable prn = new SPrinterDiver();
		prn.print(myDoc);
		System.out.println();
		
		//LG 프린터
		prn = new LGPrinterDiver();
		prn.print(myDoc);
	}

}
