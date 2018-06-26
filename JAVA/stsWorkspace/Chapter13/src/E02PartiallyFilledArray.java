
public class E02PartiallyFilledArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 11 }, { 22, 33 }, { 44, 55, 66 } };
		
//		int[][] arr = new int [3][3];
//		int num = 11;
//		
//		for(int i=0, j=0; i<arr.length && j<arr[i].length; i++, j++) {
//			if(i == j) {
//				arr[i][j] = num;
//				num++;
//			}
//		}

		// 배열 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
