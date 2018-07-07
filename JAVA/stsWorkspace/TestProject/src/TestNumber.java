
public class TestNumber {

	// public static int[][] makeCodi(int x, int y) {
	//
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 9 x 2
		// int[][] mNumber = {
		// {0,0},
		// {0,1},
		// {0,2},
		// {1,0},
		// {1,1},
		// {1,2},
		// {2,0},
		// {2,1},
		// {2,2}
		// };
		// int x,y;
		//
		//
		// for(int i = 0; i < 9; i++) {
		// x=mNumber[i][0];
		// y=mNumber[i][1];
		// System.out.println(x + " " + y);
		//
		// }
		int x = 3;
		int y = 3;
		int[][] array = new int[9][2];

		int x1;
		int y1;
		int count = x * y;

		for (int i = 0; i < count; i++) {
			x1 = i / x;
			y1 = i % x;
			array[i][0] = x1;
			array[i][1] = y1;

			System.out.println(x1 + " , " + y1);
		}

		for (int i = 0; i < 9; i++) {
			System.out.printf("%2d,%2d\n", array[i][0], array[i][1]);
		}
		System.out.println();
	}

}
