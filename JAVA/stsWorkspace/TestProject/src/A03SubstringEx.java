
public class A03SubstringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 마지막 3글자 자르기
		String str1 = "ABCDEFG";
		String result1 = str1.substring(str1.length()-3, str1.length());
		System.out.println(result1);
		
		//2. 특정문자 이후의 문자열 제거
		String str2 = "AB/CD/EFGH";
		int num2 = str2.indexOf("/");
		String result2 = str2.substring(num2 + 1);
		System.out.println(result2);
		
		//3. 특정문자 이후의 문자열 제거(뒤에서)
		String str3 = "AB/CD/EFGH";
		int num3 = str3.lastIndexOf("/");
		String result3 = str3.substring(num3 + 1);
		System.out.println(result3);
	}

}
