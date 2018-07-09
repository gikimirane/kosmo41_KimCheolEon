import java.util.*;

// TicTacToe
// 3줄 빙고
// 8개 경우의 수 


public class Ch13QuizTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		String[][] mArray = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };

		String inputChar = null;

		boolean checkPlayer = true;
		int player = 0;
		String icon = "";

		boolean num1 = true;
		boolean num2 = true;
		boolean num3 = true;
		boolean num4 = true;
		boolean num5 = true;
		boolean num6 = true;
		boolean num7 = true;
		boolean num8 = true;
		boolean num9 = true;

		player = 1;
		icon = "■";

		while (true) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

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

			System.out.println("Player " + player + ", please enter the number of the square");
			System.out.print("where you want to place your " + icon + " : ");
			inputChar = scan.next();

			switch (inputChar) {

			case "1":
				if (num1) {
					mArray[0][0] = icon;
					num1 = false;
				}
				break;

			case "2":
				if (num2) {
					mArray[0][1] = icon;
					num2 = false;
					break;
				}
				break;

			case "3":
				if (num3) {
					mArray[0][2] = icon;
					num3 = false;
					break;
				}
				break;

			case "4":
				if (num4) {
					mArray[1][0] = icon;
					num4 = false;
					break;
				}
				break;

			case "5":
				if (num5) {
					mArray[1][1] = icon;
					num5 = false;
					break;
				}
				break;

			case "6":
				if (num6) {
					mArray[1][2] = icon;
					num6 = false;
					break;
				}
				break;

			case "7":
				if (num7) {
					mArray[2][0] = icon;
					num7 = false;
					break;
				}
				break;

			case "8":
				if (num8) {
					mArray[2][1] = icon;
					num8 = false;
					break;
				}
				break;

			case "9":
				if (num9) {
					mArray[2][2] = icon;
					num9 = false;
					break;
				}
				break;
			}
			
			if (mArray[0][0].equals(icon) && mArray[0][1].equals(icon) && mArray[0][2].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[1][0].equals(icon) && mArray[1][1].equals(icon) && mArray[1][2].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[2][0].equals(icon) && mArray[2][1].equals(icon) && mArray[2][2].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[0][0].equals(icon) && mArray[1][0].equals(icon) && mArray[2][0].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[0][1].equals(icon) && mArray[1][1].equals(icon) && mArray[2][1].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[0][2].equals(icon) && mArray[1][2].equals(icon) && mArray[2][2].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[0][0].equals(icon) && mArray[1][1].equals(icon) && mArray[2][2].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			} else if (mArray[0][2].equals(icon) && mArray[1][1].equals(icon) && mArray[2][0].equals(icon)) {
				System.out.println("player " + player + " : Win!!");
				break;
			}
			
			checkPlayer = !checkPlayer;
			if (checkPlayer) {
				player = 1;
				icon = "■";
			} else {
				player = 2;
				icon = "♥";
			}
		}
		////////////////////////////////////////////// while
	}
}
