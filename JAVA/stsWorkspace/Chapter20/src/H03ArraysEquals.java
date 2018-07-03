import java.util.Arrays;

public class H03ArraysEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//두 배열에 저장된 데이터의 수, 순서 그리고 내용이 같을 때 
		//true를 반환한다.(배열의 길이가 다를 경우에느 false 반환한다
		
		int[] ar1 = {1,2,3,4,5};
		int[] ar2 = Arrays.copyOf(ar1, ar1.length);
		
		System.out.println(Arrays.equals(ar1, ar2));
		
		//같은 인스턴스인가?
		if(ar1 == ar2) {
			System.out.println("yes");
		}
		System.out.println("no");

	}

}
