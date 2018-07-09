import java.util.Random;
import java.util.Scanner;

/*
 * 설계
 * 랜덤숫자 생성 (게임시작)
 * 3자리 숫자 입력 > 숫자 분리
 * 비교(배열 | 배열) > 자리 비교 > 값 비교 > ball or Strike
 * +1 Count
 * 
 */


public class Ch13QuizBaseball {
	
//	static final int nLimit = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제 13-BaseBall. 숫자야구 게임");
				
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		
		int inputNumber = 0;
		int[] inputNumberArray = new int[3];
		int[] randNumber = new int[3];
		int ballCount = 0;
		int strikeCount = 0;
		int gameCount = 0;
		
		while(true) {
			randNumber[0] = rand.nextInt(10);
			randNumber[1] = rand.nextInt(10);
			randNumber[2] = rand.nextInt(10);
						
			if(randNumber[0] != randNumber[1] && randNumber[1] != randNumber[2] && randNumber[2] != randNumber[0]) {
				break;
			}
		}
		
		//Test 3자리 랜덤출력
//		System.out.print(randNumber[0]);
//		System.out.print(randNumber[1]);
//		System.out.print(randNumber[2]);
					
		while(true) {
			
			ballCount = 0;
			strikeCount = 0;
			
			if(gameCount == 10) {
				System.out.println("[ ㄴ패배  ] 게임을 종료합니다");
				break;				
			}
			
			
			gameCount++;
			
			System.out.println("세자리 숫자를 입력해주세요." + "(" + gameCount + " 회)");
			inputNumber = scan.nextInt();
			
			//예 - 378할때 계산하면...
			inputNumberArray[0] = inputNumber / 100;			//3
			inputNumberArray[1] = (inputNumber % 100) / 10; 	//100 나누고 나머지 78을 10 나누면 : 7
			inputNumberArray[2] = inputNumber % 10;				//10으로 다 쪼개고 남은값 8
			
			
			// ball & strike 탐색 부분 -  x:y(lope) 로 대조함
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if( randNumber[i] == inputNumberArray[j]) {
						if(i == j) {
							strikeCount++;
							continue;
						}
						ballCount++;
					}
				}
			}
			
			System.out.println();
			System.out.println(inputNumberArray[0] + " : " + inputNumberArray[1] + " : " + inputNumberArray[2]);
			System.out.println(strikeCount + " Strike\t" + ballCount + " ballCount");
			
			if(strikeCount == 3) {
				System.out.println("[ 정답  ] 게임을 종료합니다");
				break;
			}
			System.out.println();			
		}
	}
}
