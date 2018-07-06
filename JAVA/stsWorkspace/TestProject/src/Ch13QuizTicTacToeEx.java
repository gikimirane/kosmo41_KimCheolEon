// choice = nextInt()
// row  = --choice / 3;
// column = choice % 3;

import java.util.*;

public class Ch13QuizTicTacToeEx {

	static String[][] mArray = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
	
	public static void printArray() {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[i].length; j++) {
				System.out.print(mArray[i][j]);
				if (j == mArray[i].length - 1) {
					continue;
				}
				System.out.print("  |  ");
			}
			System.out.println();
			if (i == mArray.length - 1) {
				continue;
			}
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
		}
		System.out.println();		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	
		boolean[] checkNum = { true, true, true, true, true, true, true, true, true, true }; //0 번 더미
		
		int[][] cellLocation = { { 0, 0 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
		int[][][] checkCells = { 
				{ { 0, 0 }, { 0, 0 }, { 0, 0 } },//더미 데이터
				{ { 0, 0 }, { 0, 1 }, { 0, 2 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 } }, { { 2, 0 }, { 2, 1 }, { 2, 2 } },
				{ { 0, 0 }, { 1, 0 }, { 2, 0 } }, { { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 2, 0 }, { 2, 1 }, { 2, 2 } },
				{ { 0, 0 }, { 1, 1 }, { 2, 2 } }, { { 0, 2 }, { 1, 1 }, { 2, 0 } } 
			};// 9x3x2

		int inputNum = 0;
		boolean checkPlayer = true;
		int player = 0;
		String icon = "";

		player = 1;
		icon = "■";

		//최초출력
		printArray();

		//루프 시작
		while (true) {
			System.out.println("Player " + player + ", please enter the number of the square");
			System.out.print("where you want to place your " + icon + " : ");
			inputNum = scan.nextInt();

			// 선택
			if (checkNum[inputNum]) {
				mArray[cellLocation[inputNum][0]][cellLocation[inputNum][1]] = icon;
				checkNum[inputNum] = false;
			}
			else {
				printArray();
			}
			printArray();			

			// 검증
			for (int i = 1; i < 9; i++) {
				if (mArray[checkCells[i][0][0]][checkCells[i][0][1]].equals(icon)
						&& mArray[checkCells[i][1][0]][checkCells[i][1][1]].equals(icon)
						&& mArray[checkCells[i][2][0]][checkCells[i][2][1]].equals(icon)) {
							System.out.println("player " + player + " : Win!!");	
							return;
				}
			}
			checkPlayer = !checkPlayer;
			if (checkPlayer) { player = 1; icon = "■"; } 
			else { player = 2; icon = "♥"; }
		}
	}
}
