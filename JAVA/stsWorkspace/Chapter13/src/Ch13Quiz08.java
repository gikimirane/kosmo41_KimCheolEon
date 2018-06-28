import java.util.Scanner;

public class Ch13Quiz08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제13-08. 성적관리 프로그램 출력 예에 따라 표로 표현");
		
		int [][] mArray = new int[4][4];
		
		Scanner scan = new Scanner(System.in);
		
		String [] Name = new String[] {"이순신","강감찬","을지문","권율"};
		String [] gName = new String[] {"국어","영어","수학","국사"};
		int [] columnTotal = new int[4];
		int [] rowTotal = new int[4];
		
//		System.out.println(Name[0]);
		
		for(int i = 0; i < mArray.length; i++) { 
			for(int j = 0; j < mArray[i].length; j++) { // i=0, j=0
				System.out.println(Name[i] + " 의 " + gName[j] + "점수 : ");
				mArray[j][i] = scan.nextInt();
				
				//오예 나온다
				rowTotal[j] += mArray[j][i];
				columnTotal[i] += mArray[j][i];
			}
			
		}
//		System.out.println(rowTotal[0]);
//		System.out.println(rowTotal[1]);
//		System.out.println(rowTotal[2]);
//		System.out.println(rowTotal[3]);
		
//		System.out.println(columnTotal[0]);
//		System.out.println(columnTotal[1]);
//		System.out.println(columnTotal[2]);
//		System.out.println(columnTotal[3]);
		
		System.out.print("구분\t" );
		for(int i = 0; i < Name.length; i++) {
			System.out.print(Name[i] + "\t");			
		}
		System.out.println("총점");

		//출력 테스트
		for(int i = 0; i < mArray.length; i++) {
			System.out.print(gName[i]);
			for(int j = 0; j < mArray[i].length; j++) {
				System.out.print("\t" + mArray[i][j]);
			}
			System.out.print("\t" + rowTotal[i]);
			System.out.println();
		}
		System.out.print("총점");
		for(int i = 0; i < columnTotal.length; i++) {
			System.out.print("\t"+columnTotal[i]);
		}
		
		
		//이런 케이스문 방식도 응용 가능
//		for(int i = 0; i < 4; i++) {
//			switch(i) {
//			case 0:
//				System.out.println();
//				break;
//			case 1:
//				System.out.println();
//				break;
//			}
//		}
		
	}
}
