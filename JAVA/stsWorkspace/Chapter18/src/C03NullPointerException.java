
public class C03NullPointerException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = null;
		System.out.println(str);
		
//		int len = str.length();
		
		if (str != null) {
			int len = str.length();
		}

	}

}
