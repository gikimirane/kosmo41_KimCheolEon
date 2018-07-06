
public interface ViewableA {
//	public void showIt(String str);
	@Deprecated
	void showIt(String str);
	// 인터페이스는 굳이 퍼블릭 안적어도 디폴트가 public
	void brshowIt(String str);
}
