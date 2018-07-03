
public class B02StringEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = new String("So Simple");
		String str2 = new String("So Simple");
		
		//참조 대상을 비교하는 if ~ else 문
		if(str1 == str2) {
			System.out.println("st1, str2 참조 대상 동일");
		}
		else {
			System.out.println("st1, str2 참조 대상 다름");
		}
		
		//두 인스턴스 내용 비교하는 if ~ else 문
		if(str1.equals(str2)) {
			System.out.println("st1, str2 내용 동일");
		}
		else {
			System.out.println("st1, str2 내용 다름");
		}
	}
}
// Answer;
// String 클래스는 내용 비교를 하는 형태로 equals 메서드를
// 오버라이딩 하고 있음