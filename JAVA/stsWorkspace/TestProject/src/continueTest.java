
public class continueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b = 1;
		
//		System.out.println(a);
		System.out.println(b);
		
		for(a=0; a<4; a++) {
			if(a+b == 2) {
				continue;
			}
			
			System.out.println(a + " + " + b + " = " + (a+b));
		}

	}

}
