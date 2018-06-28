abstract class Calc {
	int a;
	int b;

	abstract void answer();

	void setData(int m, int n) {
		a = m;
		b = n;
	}
}

class Plus extends Calc {
	
	//The type Plus must implement the inherited 
	//abstract method Calc.answer() 
	//오버라이드를 해야 한다.
	void answer() {
		System.out.println(a + " + " + b + " = " + (a + b));
	}
}

public class A03AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Plus plus = new Plus();
		plus.setData(27, 32);
		plus.answer();
	}
}
