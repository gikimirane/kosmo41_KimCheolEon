
// 아 얘를 a s w z 를 랜덤으로 돌리는데
// 0 1 2 3 이렇게대충 정수로 해서 그냥 막돌리면 랜덤으로 이동하겠네
// 아 그르네 어

//System.out.println(Arrays.deepEquals(test1, test2));
//좋은거 찾았다

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ThreeByThree {

	String buffer = null;

	public void Space() {
		for (int i = 0; i < 101; i++) {
			System.out.println();
		}
	}

	public void ArrayPrint(String[][] array, int row, int col) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String[][] PositionMove(String[][] array, String odder, int x, int y) {

		int tposX = 0;
		int tposY = 0;
		switch (odder) {

		case "A":
		case "a":
			tposX = x;
			tposY = y + 1;
			if (tposY < 3) { // 아니 이걸 0을 포함 안시키면 인덱스가 안맞지;; 멍청했다;;
				buffer = array[x][y]; // x값
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			} else {
				// break;
			}
			break;

		case "d":
		case "D":
			tposX = x;
			tposY = y - 1;
			if (tposY >= 0) { // 아니 이걸 0을 포함 안시키면 인덱스가 안맞지;; 멍청했다;;
				buffer = array[x][y]; // x값
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			} else {
				// break;
			}
			break;

		case "w":
		case "W":
			tposX = x + 1;
			tposY = y;
			if (tposX < 3) {
				buffer = array[x][y]; // x값
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			} else {
				// break;
			}
			break;

		case "S":
		case "s":
			tposX = x - 1;
			tposY = y;
			if (tposX >= 0) {
				buffer = array[x][y]; // x값
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			} else {
				// break;
			}
			break;

		}
		return array;
	}

}

public class Ch13QuizThreeByThreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String inputChar = null;

		ThreeByThree TbT = new ThreeByThree();

		//원본배열
		String[][] mArray = { { "1", "2", "3" }, { "4", "x", "5" }, { "6", "7", "8" } };
		
		//비교대상
		String[][] cArray = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "x" } };
		//랜덤에 쓰일 배열
		String[] odderArray = {"a", "d", "w", "s"};

		int row = mArray.length;
		int column = mArray[0].length;
		int posX = 0;
		int posY = 0;
		int randNum = 0;

		String buffer = null;
		String[][] bufferArray = new String[row][column];

		//////////////////////////////////////////////////////////////////////////////////////////////////

		for(int i = 0; i < 100; i++) {
			randNum = rand.nextInt(4);
			bufferArray = TbT.PositionMove(mArray, odderArray[randNum], posX, posY);
		}
		
		while (true) {

			if(Arrays.deepEquals(bufferArray, cArray)){
				System.out.println("정답입니다! 게임을 종료합니다.");
				break;
			}
			
			TbT.Space();

			TbT.ArrayPrint(mArray, row, column);

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (mArray[i][j].equals("x")) {
						posX = i; // default 2
						posY = j; // default 2
					}
				}
			}

			System.out.println();
			System.out.println("[ Mover ] a:Left d:Right w:Up s:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.printf("키를 입력해주세요 : ");
			inputChar = scan.next();

			if (inputChar.equals("k") || inputChar.equals("K")) {
				System.out.println("나가고 집에갑니다 ㅠㅠ");
				break;
			}

			bufferArray = TbT.PositionMove(mArray, inputChar, posX, posY);
		}


	}
}
