import java.util.Scanner;

class WhiteSpace{
	void space() {
		for(int i = 0; i < 101; i++) {
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
		
		String[][] mArray = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "x"}
		};
		
		int row = mArray.length;
		int column = mArray[0].length;
		int posX = 0;
		int posY = 0;
		String buffer = null;
		
		String[][] bufferArray = new String[row][column];
		
		cls.space();
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(mArray[i][j] + "  ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(mArray[i][j].equals("x")) {
					posX = i;
					posY = j;
				}
			}
		}		
		
		System.out.println();
		System.out.printf("[  Mover ] a:Left  s:Right  w:Up  z:Down\n");
		//아 얘를 a s w z 를 랜덤으로 돌리는데
		// 0 1 2 3 이렇게대충 정수로 해서 그냥 막돌리면 랜덤으로 이동하겠네
		// 아 그르네 어
		System.out.printf("[  Exit  ] k:Exit\n");
		System.out.printf("키를 입력해주세요 : ");
		inputChar = scan.next();

		
		System.out.println(posX);
		System.out.println(posY);
	}

}
