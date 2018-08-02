
public class ParseIntTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "1001";                     // 문자열 정의
		 
	    int i = Integer.parseInt(str) + 1;        // 32비트 정수로 그리고 1을 더하기
	    System.out.println(i);                  // 출력: 1001
	 
	    long l = Long.parseLong(str) + 1;         // 64비트 정수로 그리고 1을 더하기
	    System.out.println(l);                  // 출력: 1001
	 
	    float f = Float.parseFloat(str) + 1.0F;   // 32비트 실수로 그리고 1을 더하기
	    System.out.println(f);                  // 출력: 1001.0
	 
	    double d = Double.parseDouble(str) + 1.0; // 64비트 실수로 그리고 1을 더하기
	    System.out.println(d);                  // 출력: 1001.0


	
		
	}

}
