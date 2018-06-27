import com.company.area.*;
//import com.company.length.*;
//같은 이름(Circle) 이라서 import 하면 에러남

public class B01ImportCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c1 = new Circle(3.5);
		System.out.println("반지름 3.5 원 넓이 : " + c1.getArea());
		
		Circle c2 = new Circle(5.5);
		System.out.println("반지름 5.5 원 넓이 : " + c2.getArea());

	}

}
