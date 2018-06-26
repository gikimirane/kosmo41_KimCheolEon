class Calc{
	int x1 = 0;
	int x2 = 0;
	
	Calc(int n1, int n2){
		x1 = x1 + n1;
		x2 = x2 + n2;
	}
	
	int Add(int n1, int n2) {
		int nResult = n1 + n2;
//		System.out.println(nResult);
		return nResult;
	}
}


public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 5;
		int num2 = 7;
		
		Calc myCalc = new Calc(num1, num2);
		int num3 = myCalc.Add(num1, num2);
		
		int num4 = num3 * 10 - 20;
		System.out.println(num4);
	}

}
