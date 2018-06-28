
public class B02ImmutableString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Simple String";
		String str2 = "Simple String";
//		String str2 = str1;// 위 아래가 같음.
		
		String str3 = new String("Simple String");
		String str4 = new String("Simple String");
		
		int test = 1;
		int test2 = 2;
		String te = "t";
		String te2 = "t";
		
		System.out.println(te.equals(te2));		
		
		//결론 : == 은 인스턴스를 비교함. equals 는 내부 값을 비교. 인스턴스 생성을 최소화함
		// 근데 테스트 해보니 equals 는 스트링만 비교하는듯
		if(str1 == str2) {
			System.out.println("str1과 str2 는 동일 인스턴스 참조");
		}
		else {
			System.out.println("str1과 str2 는 다른 인스턴스 참조");
		}
		
		if(str3 == str4) {
			System.out.println("str3과 str4 는 동일 인스턴스 참조");
		}
		else {
			System.out.println("str3과 str4 는 다른 인스턴스 참조");
		}
	}

}
