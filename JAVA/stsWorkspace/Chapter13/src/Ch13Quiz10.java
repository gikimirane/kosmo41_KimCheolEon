// 똑같은 것을 여러번 할땐 메서드화 해서 처리하자

import java.util.Arrays;

public class Ch13Quiz10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제 13-10. 배열의 90도씩 회전");

//		 int[][] mArray = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
//		 14, 15, 16 } };
		int[][] mArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 17, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		int[][] mBuffer = new int[mArray.length][mArray[0].length];

		int length = mArray.length;

		////////// 원본 mArray 출력//////////
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(mArray[i][j] + "\t");
			}
			System.out.println();
		}

		// 90도 회전
		for (int i = 0, x = length - 1; i < length; i++) {
			for (int j = 0; j < length; j++) {
				mBuffer[j][i + x] = mArray[i][j];// 00 01 02 03, 10 11 12 13, 20 21 22 23
				// 00+3 10+3 20+3 30+3
				// 10+1 11+1 12+1 13+1
			}
			x = x - 2;
		}

		System.out.println();

		////////// mBuffer출력 & mArray에 mBuffer 값 싣기 //////////
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(mBuffer[i][j] + "\t");
				mArray[i][j] = mBuffer[i][j];
			}
			System.out.println();
		}

		// 90도 회전
		for (int i = 0, x = length - 1; i < length; i++) {
			for (int j = 0; j < length; j++) {
				mBuffer[j][i + x] = mArray[i][j];// 00 01 02 03, 10 11 12 13, 20 21 22 23
				// 00+3 10+3 20+3 30+3
				// 10+1 11+1 12+1 13+1
			}
			x--;
			x--;
		}

		System.out.println();

		////////// mBuffer출력 & mArray에 mBuffer 값 싣기 //////////
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(mBuffer[i][j] + "\t");
				mArray[i][j] = mBuffer[i][j];
			}
			System.out.println();
		}

		// 90도 회전
		for (int i = 0, x = length - 1; i < length; i++) {
			for (int j = 0; j < length; j++) {
				mBuffer[j][i + x] = mArray[i][j];// 00 01 02 03, 10 11 12 13, 20 21 22 23
				// 00+3 10+3 20+3 30+3
				// 10+1 11+1 12+1 13+1
			}
			x--;
			x--;
		}

		System.out.println();

		////////// mBuffer출력 & mArray에 mBuffer 값 싣기 //////////
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(mBuffer[i][j] + "\t");
				mArray[i][j] = mBuffer[i][j];
			}
			System.out.println();
		}

		// 90도 회전
		for (int i = 0, x = length - 1; i < length; i++) {
			for (int j = 0; j < length; j++) {
				mBuffer[j][i + x] = mArray[i][j];// 00 01 02 03, 10 11 12 13, 20 21 22 23
				// 00+3 10+3 20+3 30+3
				// 10+1 11+1 12+1 13+1
			}
			x--;
			x--;
		}
		System.out.println();
	}
}
