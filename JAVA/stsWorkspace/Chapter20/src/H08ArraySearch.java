import java.util.Arrays;

public class H08ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ar = {33, 55, 11, 44, 22};
		Arrays.sort(ar);
		// 이진 탐색 이전에 정렬이 선행되어야 함.
		
		for(int n : ar) {
			System.out.print(n + "\t");
		}
		System.out.println();

		//배열 ar에서 33을 찾으시오
		int idx = Arrays.binarySearch(ar, 33);
		System.out.println("Index of 33 : " + idx);
		
	}

}
