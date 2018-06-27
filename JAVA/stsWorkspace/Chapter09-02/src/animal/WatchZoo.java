package animal;

public class WatchZoo {
	public void makeTiger2() {
//		MyTiger는 public 으로 선언했었기 때문에 이 패키지에서 생성 가능
		zoo.MyTiger hosun = new zoo.MyTiger();
	}
	
	public void makeTiger3() {
//		Tiger는 zoo 에서 default 였기 때문에 이 패키지에서 인스턴스 생성 불가
//		zoo.Tiger hosun = new zoo.Tiger();
	}

}
