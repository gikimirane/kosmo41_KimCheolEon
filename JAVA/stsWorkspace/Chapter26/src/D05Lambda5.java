interface Printable05{
	void print(String s, int n);
}
public class D05Lambda5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//파라미터 여러개일때
		Printable05 prn = (s, n) -> {System.out.println(s + " : " + n); };
		prn.print("What is Lambda? ver", 5);
	}
}
