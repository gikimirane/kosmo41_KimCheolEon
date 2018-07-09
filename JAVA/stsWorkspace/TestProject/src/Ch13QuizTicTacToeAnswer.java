import java.util.*;

public class Ch13QuizTicTacToeAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int player = 0;
		int winner = 0;
		int choice = 0;
		int row = 0;
		int column = 0;

		char board[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, };

		Scanner s = new Scanner(System.in);

		for (int i = 0; i < 9 && winner == 0; i++) {
			System.out.println();
			System.out.println();
			System.out.printf(" %c | %c | %c\n", board[0][0], board[0][1], board[0][2]);
			System.out.printf("---|---|---\n");
			System.out.printf(" %c | %c | %c\n", board[1][0], board[1][1], board[1][2]);
			System.out.printf("---|---|---\n");
			System.out.printf(" %c | %c | %c\n", board[2][0], board[2][1], board[2][2]);

			player = i % 2 + 1;

			do {
				System.out.printf("\n" + "Player %d, please enter the number of the square\n"
						+ "where you want to place youre %c : ", player, (player == 1) ? 'X' : 'O');

				choice = s.nextInt();

				row = --choice / 3;
				column = choice % 3;
				// 여기가 핵심
			} while (choice < 0 || choice > 8 || board[row][column] > '9');

			board[row][column] = (player == 1) ? 'X' : 'O';

			if ((board[0][0] == board[1][1] && board[0][0] == board[2][2])
					|| (board[0][2] == board[1][1] && board[0][2] == board[2][0])) {
				winner = player;
			} else {
				for (int line = 0; line <= 2; line++) {
					if ((board[line][0] == board[line][1] && board[line][0] == board[line][2])
							|| (board[0][line] == board[1][line] && board[0][line] == board[2][line])) {
						winner = player;
					}
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.printf(" %c | %c | %c\n", board[0][0], board[0][1], board[0][2]);
		System.out.printf("---|---|---\n");
		System.out.printf(" %c | %c | %c\n", board[1][0], board[1][1], board[1][2]);
		System.out.printf("---|---|---\n");
		System.out.printf(" %c | %c | %c\n", board[2][0], board[2][1], board[2][2]);

		if (winner == 0) {
			System.out.println("The game is a draw");
		} else {
			System.out.printf("Player %d has wonn", winner);
		}
	}
}
