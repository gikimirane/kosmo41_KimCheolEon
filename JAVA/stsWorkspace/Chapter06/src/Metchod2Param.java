
public class Metchod2Param {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double myHeight = 175.9;
		
		hiEveryone(12, 12.5);
		hiEveryone(13, myHeight);		

		byEverone();
	}
	
	public static void hiEveryone(int age, double height) {
		System.out.println("--call hi--");
		System.out.println("제 나이는" + age + "세 입니다.");
		System.out.println("저의 키는" + height + "cm 입니다.");		
	}
	
	public static void byEverone() {
		System.out.println("--call by--");
		System.out.println("다음에 뵙겠습니다.");
	}

}
