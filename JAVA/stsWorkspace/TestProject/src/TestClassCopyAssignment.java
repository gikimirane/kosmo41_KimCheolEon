class SuperClass{
	int price = 1000;
	
	void getPrice() {
		System.out.println("Super-price : " + price);
	}
}

class SubClass extends SuperClass{
	int price = 5000;
	String name = "아몰랑";
	
	void getPrice() {
		System.out.println("Sub-price : " + price);
		System.out.println("name : " + name);		
	}
}


public class TestClassCopyAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int num1 = 10;
		double num2 = num1;
		
		double num3 = 23.45;
//		int num4 = num3;
		
		SuperClass obj1 = new SuperClass();
		SuperClass obj2 = new SubClass();
		
//		SubClass obj3 = obj1;
		SuperClass obj3 = new SubClass();
		
		obj1.getPrice();
		obj2.getPrice();
		obj3.getPrice();
	}

}
