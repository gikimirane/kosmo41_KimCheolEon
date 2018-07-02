abstract class Calc2{
	int a;
	int b;
	
	abstract int result();
	
	void printResult() {
		System.out.println(result());
	}
	
	void setData(int m, int n) {
		a = m;
		b = n;
	}
}

class Plus1 extends Calc2{
	int result() {
		return a + b;
	}
}

class Minus extends Calc2{
	int result() {
		return a - b;
	}
}


public class A06Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 54, y = 12;
		
		
//		Calc2 test = new Calc2();
		
		Calc2 calc1 = new Plus1();
		
		Calc2 calc2 = new Minus();
	
//		calc1 = new Calc2();	
		
		calc1.setData(x, y);
		calc2.setData(x, y);
		
		System.out.print(x + " + " + y + " = ");
		calc1.printResult();
		
		System.out.print(x + " - " + y + " = ");
		calc2.printResult();
	}

}
