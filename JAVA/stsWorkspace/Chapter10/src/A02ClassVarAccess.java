class AccessWay{
	static int num = 0;
	
	AccessWay(){
		incrCnt();
	}
	
	void incrCnt() {
		num++;
		// 방법1. 클래스 내부에서 이름을 통한 static 접근
		System.out.println("num = " + AccessWay.num);
	}
}

public class A02ClassVarAccess {
//	1. 메인 스태틱올림
//	2. 클래스 스태틱 올림
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		AccessWay way = new AccessWay();
//		3. 생성자 호출
		//이거 하나만 호출하는 순간 내부에서 다 돌음(AccessWay). void 라서 그런가? - 아 디폴트 생성자때문인듯
		
		way.num++;
		//방법2. 외부에서 인스턴스 생성 후 이름을 통한 접근
		System.out.println("num = " + AccessWay.num);
		
		AccessWay.num++;
		//방법 3. 외부에서 클래스의 이름을 통한 직접 접근 (대체로 관행적)
		System.out.println("num = " + AccessWay.num);
		
//		4. 쭉 진행
	}

}
