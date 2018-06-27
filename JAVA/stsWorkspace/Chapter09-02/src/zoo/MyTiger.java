package zoo;


//Tiger default 선언 - 동일 패키지 내에서만 인스턴스 생성 가능
class Tiger{
//	빈 클래스
}

//MyTiger는 public 선언 - 어디서든 인스턴스 생성 가능
public class MyTiger {
	public void makeTiger1() {
		
		//Tiger 와 같은 패키지라서 default 불러올 수 있음
		Tiger hodol = new Tiger();
	}

}
