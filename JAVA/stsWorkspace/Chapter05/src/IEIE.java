
public class IEIE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 99;
		
		// 0보다 작은 값 : 음수
		if(num < 0) {
			System.out.println("0 미만");
		}
		// 0을 초과하고 100 미만인 수
		else if(num > 0 && num < 100) {
			System.out.println("0 초과 100 미만");
		}
		// 나머지 그 외
		else {
			System.out.println("그 외");
		}
	}

}