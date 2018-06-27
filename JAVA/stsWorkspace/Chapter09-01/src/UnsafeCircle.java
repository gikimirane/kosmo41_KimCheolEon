class Circle {
	double rad = 0;
	final double PI = 3.14;

	public Circle(double r) {
		setRad(r);
	}
	
	public void setRad(double r) {
		if (r < 0) {
			rad = 0;
			return;
		}
		rad = r;
	}
	
	public double getArea() {
		return (rad * rad) * PI;
	}
}

public class UnsafeCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c = new Circle(1.5);
		System.out.println(c.getArea());
		
		c.setRad(2.5);
		System.out.println(c.getArea());
		
		c.setRad(-3.3);
		System.out.println(c.getArea());
		
		c.rad = -4.5; // 직접 접근하여 수정하기 때문에 위험함
		System.out.println(c.getArea());

	}

}
