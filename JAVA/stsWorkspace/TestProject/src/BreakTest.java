
public class BreakTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//break; 가 모든 루프를 탈출하는가, 한 루프만 탈출하는가?
		for(int i = 0; i < 10; i++) {
//			System.out.println("숫자 : " + i);
			System.out.println("i : " + i);
			for(int j = 0; j < 10; j++) {
				System.out.println("j : " + j);
				break;
			}
			System.out.println("한 루프 탈출 : ");
			break;
		}
		System.out.println("완전 탈출 ");
	}
	//결론 : 현재 돌고 있는 루프 탈출

}
