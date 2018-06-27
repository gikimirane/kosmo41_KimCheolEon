
public class Ch13Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		System.out.println("문제13-07. NxM 배열을 MxN 으로 바꿔보기");
		
		int [][] mArray = new int[2][4];
				
		// 2x4 초기화
		for(int i= 0, nCount = 0; i < mArray.length; i++) {
			for(int j = 0; j < mArray[i].length; j++) {
				mArray[i][j] = ++nCount;
			}
		}
		
//		2x4 출력
		for(int i = 0; i < mArray.length; i++) {
			for(int j = 0; j < mArray[i].length; j++) {
				System.out.print(mArray[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		//새 배열 선언 및 길이는 기존배열에서 따옴
		int [][] mArray2 = new int[mArray[0].length][mArray.length];

		// 4x2 전치
		for(int i= 0; i < mArray2.length; i++) {
			for(int j = 0; j < mArray2[i].length; j++) {
				mArray2[i][j] = mArray[j][i];
			}
		}
		
		// 4x2 전치출력
		for(int i = 0; i < mArray2.length; i++) {
			for(int j = 0; j < mArray2[i].length; j++) {
				System.out.print(mArray2[i][j] + "\t");
			}
			System.out.println();
		}
		

	}

}
