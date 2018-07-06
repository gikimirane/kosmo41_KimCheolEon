
public class C02VargsOld {
	
//	public static void showAll(String[] vargs){
	public static void showAll(int[] vargs){
		System.out.println("LEN : " + vargs.length);
		
//		for(String s : vargs) {
		for(int s : vargs) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		showAll(new String[] {"Box"});
//		showAll(new String[] {"Box", "Toy"});
//		showAll(new String[] {"Box", "Toy", "Apple"});
		showAll(new int[] {1});
		showAll(new int[] {1, 2});
		showAll(new int[] {1, 2, 3});
	}
}

//매개변수의 가변인자 선언은 자바5 에서 추가된 문법이다
// 따라서 그 이전의 코드는 위와 같이 작성되어왔다
