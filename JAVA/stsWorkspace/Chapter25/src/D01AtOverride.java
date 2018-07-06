//interface ViewableA1{
//	public void showIt(String str);
//}
//
//class Viewer1 implements ViewableA1{
//	@Override
//	public void showIt(String str) {
//		System.out.println(str);
//	}
//}

public class D01AtOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ViewableA view = new ViewerA();
		view.showIt("Hello Annotation");
		
		view.brshowIt("Hello Annotation2");
	}
}
