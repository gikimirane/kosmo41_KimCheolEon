class Circle2 {
	private double rad = 0;
	final double PI = 3.14;

	public Circle2(double r) {
		setRad(r);
	}
	
	//Setter
	public void setRad(double r) {
		if (r < 0) {
			rad = 0;
			return;
		}
		rad = r;
	}
	
	public double getRad() {
		return rad;
	}

	public double getArea() {
		return (rad * rad) * PI;
	}
}

public class HideCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle2 c = new Circle2(1.5);
		System.out.println(c.getArea());
		System.out.println(c.getRad());
		System.out.println();
		
		c.setRad(2.5);
		System.out.println(c.getArea());
		System.out.println(c.getRad());
		System.out.println();
		
		c.setRad(-3.3);
		System.out.println(c.getArea());
		System.out.println(c.getRad());
		System.out.println();
		
//		c.rad = -4.5; // 직접 접근하여 수정하기 때문에 위험함
//		System.out.println(c.getArea());
		
		c.setRad(-4.5);
		System.out.println(c.getArea());
		System.out.println(c.getRad());
		System.out.println();
	}

}
