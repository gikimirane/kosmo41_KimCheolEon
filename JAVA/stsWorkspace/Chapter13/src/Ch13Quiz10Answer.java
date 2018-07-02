
public class Ch13Quiz10Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		arrPrint(arr);

		for (int k = 0; k < 3; k++) {
			int[][] arr2 = new int[4][4];
			int x;
			int y;
			y = 0;
			for (int i = 0; i < 4; i++) {
				x=3;
				for (int j = 0; j < 4; j++) {
					arr2[i][j] = arr[x][y];
					x--;
				}
				y++;
			}
			// 원래 배열에 값을 다시 복사
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = arr2[i][j];
				}
			}
			arrPrint(arr2);
		}

	}

	//main 외부에 static 해야 메서드 불러올 수 있을걸?
	public static void arrPrint(int[][] arr) {
		for(int i=0; i <4; i++) {
			for(int j = 0; j<4; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
