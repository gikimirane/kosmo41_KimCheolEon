interface Printable04{
	void print(String s);
}

public class D04Lambda4 {

	public static void ShowString(Printable04 p, String s) {
		p.print(s);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//파라미터 통째로 람다로 넘김
		ShowString((s) -> {System.out.println(s);}, "What is Lambda? ver4");
	}

}
