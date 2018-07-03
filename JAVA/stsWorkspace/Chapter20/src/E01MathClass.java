
public class E01MathClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("원주율 : " + Math.PI);
		System.out.println("2의 제곱근 : " + Math.sqrt(2));
		System.out.println();
		System.out.println("PI Degree : " + Math.toDegrees(Math.PI));
		System.out.println("PI Degree : " + Math.toDegrees(2.0 * Math.PI));
		
		double radian45 = Math.toRadians(45);
		System.out.println("Sine 45 : " + Math.sin(radian45));
		System.out.println("Sine 45 : " + Math.cos(radian45));
		System.out.println("Sine 45 : " + Math.tan(radian45));
		System.out.println();
		System.out.println("log25 : " + Math.log(25));
		System.out.println("2^16 : " + Math.pow(2, 16));

	}

}
