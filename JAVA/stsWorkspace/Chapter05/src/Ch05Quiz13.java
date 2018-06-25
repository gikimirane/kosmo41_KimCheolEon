
public class Ch05Quiz13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제5-13. 구구단 출력, 가로형, 세로형 이쁘게");
		
		System.out.println("");
		System.out.println("가로");
		for(int j = 1; j < 10; j++) {
			System.out.println("");
			for(int i = 2; i < 10; i++) {
				System.out.print(i + " X " + j + " = " + (i*j) + "\t");
			}
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("세로");
		//어 뭐야 테스트 하다가 세로부터 만들어짐;;
		for(int i = 2; i < 10; i++) {
			System.out.println("");
			for(int j = 1; j < 10; j++) {
				System.out.print(i + " X " + j + " = " + (i*j) + "\t");
			}
		}
		
//		for(int i = 1; i < 10; i++) {
//			System.out.println(i+"단---------------------");
//			for(int j = 1; j < 10; j++) {
//				System.out.println(i + " X " + j + " = " + (i*j));
//			}
//		}

	}

}