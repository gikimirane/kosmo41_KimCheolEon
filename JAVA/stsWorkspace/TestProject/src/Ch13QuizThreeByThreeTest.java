// 방법1. x 가 이동할 좌표를 바로 계산하고 확인
//아래로 이동시 두번 이동한이유 : 연산하고 브레이크걸고 나와야하는데, 밑에 아직 남아서 위로갔다가 아래 가면 아직 남아있어서 한번 더 내려감
//이 방법을 시행하면 이동한 곳에 확정적으로 x가 들어가므로 변수가 하나더 필요하지 않음

// 방법2. 내가 한것 (X좌표를 잡고 이동하며, 조건확인)

// 자꾸 문제가 안풀리길래 내가 이동할수 없는 문제를 만들었나 싶었는데, 1번 랜덤 돌리고 보니까 돌아감

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ThreeByThree {
	public void Space() {
		// 100번 줄바꿈을 통한 cls
		for (int i = 0; i < 101; i++) {
			System.out.println();
		}
	}

	public void ArrayPrint(String[][] array, int row, int col) {
		// 2차원 배열의 출력
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String[][] PositionMove(String[][] array, String odder, int x, int y) {

		// 이동할 인덱스의 좌표 및 array bound check 용도
		int tposX = 0;
		int tposY = 0;
		
		String buffer = null;
		
		switch (odder) {
		// 어차피 해당 메서드가 while(true) 안에 있어서 아무리 반환하고 끝내도 다시 돌아오긴 할거라서 else 부분 미지정
		// 아마 else 필요없을 것이라 생각되어 일단 삭제
		case "A":
		case "a":
			tposX = x;
			tposY = y + 1;
			if (tposY < 3) {
				buffer = array[x][y];
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			}
			break;

		case "d":
		case "D":
			tposX = x;
			tposY = y - 1;
			if (tposY >= 0) {
				buffer = array[x][y];
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			}
			break;

		case "w":
		case "W":
			tposX = x + 1;
			tposY = y;
			if (tposX < 3) {
				buffer = array[x][y];
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
			}
			break;

		case "S":
		case "s":
			tposX = x - 1;
			tposY = y;
			if (tposX >= 0) {
				buffer = array[x][y];
				array[x][y] = array[tposX][tposY];
				array[tposX][tposY] = buffer;
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

		// 원본배열 - 최초 및 섞고 재사용되는 배열
		String[][] mArray = { { "x", "1", "2" }, { "3", "4", "5" }, { "6", "7", "8" } };

		// 비교대상 - 정답
		String[][] cArray = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "x" } };

		// 랜덤셔플에 쓰일 배열 (index 호출을 통한 셔플)
		String[] odderArray = { "a", "d", "w", "s" };

		// 배열 길이는 자주 활용할것이므로 변수를 통해 미리 뽑아둠
		int row = mArray.length;
		int column = mArray[0].length;

		// x의 위치 할당 변수
		int posX = 0;
		int posY = 0;

		// 랜덤으로 숫자를 뽑을 변수 (index 제어용)
		int randNum = 0;

		String buffer = null;
		String[][] bufferArray = new String[row][column];

		//////////////////////////////////////////////////////////////////////////////////////////////////

		// 랜덤 셔플 부분
		for (int i = 0; i < 100; i++) {
			randNum = rand.nextInt(4);
			bufferArray = TbT.PositionMove(mArray, odderArray[randNum], posX, posY);
		}

		while (true) {

			if (Arrays.deepEquals(bufferArray, cArray)) {
				System.out.println("정답입니다! 게임을 종료합니다.");
				break;
			}

			TbT.Space();

			TbT.ArrayPrint(mArray, row, column);

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (mArray[i][j].equals("x")) {
						posX = i;
						posY = j;
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
