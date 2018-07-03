
public class B01BoxingUnBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 인스턴스에 값을 감싸는 박싱
		Integer iObj = new Integer(10);
		Double dObj = new Double(3.14);
		
		// 박싱 출력
		System.out.println(iObj);
		System.out.println(dObj);
		System.out.println();
		
		
		// 메소드 호출을 통한 언박싱
		int num1 = iObj.intValue();
		double num2 = dObj.doubleValue();
		
		// 언박싱 출력
		System.out.println(num1);
		System.out.println(num2);
		System.out.println();
		
		// 래퍼 인스턴스 값의 증가
		iObj = new Integer(iObj.intValue() + 10);
		dObj = new Double(dObj.doubleValue() + 1.2);
		//출력
		System.out.println(iObj);
		System.out.println(dObj);

	}

}
