import java.util.StringTokenizer;

public class StringTokenizerWithAddString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		StringTokenizer str1 = new StringTokenizer("a,b,c", ",");
//		StringTokenizer str2 = new StringTokenizer("1 2 3");
//		
//		String string = str1.nextToken();
//		int sum = Integer.parseInt(str2.nextToken());
//		
//		while(str1.hasMoreElements()) {
//			string = string + " + " + (str2.nextToken());
//			sum = sum + Integer.parseInt(str2.nextToken());
//		}
//		System.out.println(string + " = " + sum);
		
		StringTokenizer v = new StringTokenizer("a:b:c", ":");
		StringTokenizer n = new StringTokenizer("1 2 3");
		
		String s = v.nextToken();
		int sum = Integer.parseInt(n.nextToken());

//		System.out.println(s);
//		System.out.println(sum);
		
//		System.out.println(v.nextToken());
//		System.out.println(v.nextToken());
		
		System.out.println(v.hasMoreElements());
		
		while(v.hasMoreElements()) {
			String str = v.nextToken();
			System.out.println(str);
//			s = s + " + " + (v.nextToken());
//			s = s + " + " + str;
			s += " + " + str;
			sum = sum + Integer.parseInt(n.nextToken());
		}
		System.out.println(s + " = " + sum);
	}

}
