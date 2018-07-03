
// 아 얘를 a s w z 를 랜덤으로 돌리는데
// 0 1 2 3 이렇게대충 정수로 해서 그냥 막돌리면 랜덤으로 이동하겠네
// 아 그르네 어

//System.out.println(Arrays.deepEquals(test1, test2));
//좋은거 찾았다

import java.util.Arrays;
import java.util.Scanner;

class WhiteSpace {
	public void space() {
		for (int i = 0; i < 101; i++) {
			System.out.println();
		}
	}
}

public class Ch13QuizThreeByThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String inputChar = null;

		WhiteSpace cls = new WhiteSpace();

		String[][] mArray = { { "1", "2", "3" }, { "4", "x", "5" }, { "6", "7", "8" } };

		int row = mArray.length;
		int column = mArray[0].length;
		int posX = 0;
		int posY = 0;

		int tposX = 0;
		int tposY = 0;

		String buffer = null;
		String[][] bufferArray = new String[row][column];

		//////////////////////////////////////////////////////////////////////////////////////////////////

		while (true) {

			cls.space();

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					System.out.print(mArray[i][j] + " ");
					bufferArray[i][j] = mArray[i][j];
				}
				System.out.println();
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (bufferArray[i][j].equals("x")) {
						posX = i; // default 2
						posY = j; // default 2
					}
				}
			}
			
			System.out.println(posX);
			System.out.println(posY);

			System.out.println();
			System.out.println("[ Mover ] a:Left s:Right w:Up d:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.printf("키를 입력해주세요 : ");
			inputChar = scan.next();

//			switch (inputChar) {
//
//			case "A":
//			case "a":
//				tposX = posX;
//				tposY = posY - 1;
//				if (tposY > 0) {
//					buffer = bufferArray[posX][posY];
//					bufferArray[posX][posY] = "x";
//					bufferArray[tposX][tposY] = buffer;
//				} else {
//					continue;
//				}
//				break;
//
//			case "d":
//			case "D":
//				tposX = posX;
//				tposY = posY + 1;
//				if (tposY < row) {
//					buffer = bufferArray[posX][posY];
//					bufferArray[posX][posY] = bufferArray[tposX][tposY];
//				} else {
//					continue;
//				}
//				break;
//
//			case "w":
//			case "W":
//				tposX = posX - 1;
//				tposY = posY;
//				if (tposX > 0) {
//					buffer = bufferArray[posX][posY];
//					bufferArray[posX][posY] = bufferArray[tposX][tposY];
//				} else {
//					continue;
//				}
//				break;
//
//			case "S":
//			case "s":
//				tposX = posX + 1;
//				tposY = posY;
//				if (tposX < column) {
//					buffer = bufferArray[posX][posY];
//					bufferArray[posX][posY] = bufferArray[tposX][tposY];
//				} else {
//					continue;
//				}
//				break;
//			}

		}

	}
}
