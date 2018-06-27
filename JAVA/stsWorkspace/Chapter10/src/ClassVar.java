class InstCnt{
	
	// static 이라서 메모리에 계속 존재함
	// 때문에, new 해서 새 객체 만들어도 0으로 초기화되지 않음
	static int instNum = 0;
	
	InstCnt(){
		instNum ++;
		System.out.println("인스턴스 생성 : " + instNum);
	}
}

public class ClassVar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();	

	}

}
