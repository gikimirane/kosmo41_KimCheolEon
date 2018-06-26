
public class E01TwoDimenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] arr = new int [3][4];
		int num = 1;
		
		
		// length 를 활용하면 for 조건에 상수를 삽입 안해도 됨.
		// 2차원의 길이를 알려면 arr[i].length 를 하면 길이를 알 수 있음
		//배열에 값 저장
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num++;
			}
		}
		
		//배열 출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				 System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
