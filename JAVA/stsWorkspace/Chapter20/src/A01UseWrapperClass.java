// 기본 자료형의 값을 감싸는 래퍼클래스


public class A01UseWrapperClass {

	public static void showData(Object obj) {
		System.out.println(obj);
	}
	// 인스턴스를 요구하는 메소드
	// 이 메소드를 통해서 정수나 실수를 출력하려면 해당 값을
	// 인스턴스화 해서 줘야한다.
	
//	public static void showDat(int num) {
//		System.out.println(num);
//	}
//	
//	public static void showDat(double num) {
//		System.out.println(num);
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정수 3으로 채워진 래퍼 인스턴스 생성
		Integer iInst = new Integer(3);
		showData(iInst);
		
		// 실수 7.15로 채워진 래퍼 인스턴스 생성
		showData(new Double(7.15));
	}
	//기본 자료형의 값을 인스턴스로 감싸는 목적의 클래스를 래퍼클래스라고 한다.
}
