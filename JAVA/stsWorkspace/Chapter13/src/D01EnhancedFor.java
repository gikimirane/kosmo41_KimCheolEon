
public class D01EnhancedFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ar = {1,2,3,4,5};
		
//		for(int i = 0; i < ar.length; i++) {
//			System.out.println(ar[i]);
//		}
		
		int buffer = 0;
		//JSP 할때 봤던게 무슨 문법인가 했더니 이거였구나
		for(int e : ar) {
			System.out.println(e);
			buffer += e;
		}
		System.out.println("총합 : " + buffer);

	}

}
