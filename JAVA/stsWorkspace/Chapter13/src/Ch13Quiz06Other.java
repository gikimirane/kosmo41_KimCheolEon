
public class Ch13Quiz06Other {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제13-06Other. 2차원 배열, 2,3,4 단 구구단 저장 및 출력");
		
		int [][] mArray = new int[3][9];
		
//		System.out.println(mArray.length);
//		System.out.println(mArray[1].length);
		
		//mArray.length = 3
		//mArray[].length = 9
		
//		i = 0~3
		for(int i = 0; i < mArray.length; i++) {
			//j = 0~9
			for(int j = 0; j < mArray[i].length; j++) {
				mArray[i][j] = (i+2) * (j+1);
			}
		}
		
		
		for(int i = 0; i < mArray.length; i++) {
			for(int j = 0; j < mArray[i].length; j++) {
//				System.out.printf("%d x %d = %d \t", (i+2), (j+1), mArray[i][j]);
				System.out.print((i+2) + " x " + (j+1)+ " " + " = ");
				System.out.print(mArray[i][j] + "\t");
			}
			System.out.println();
		}
		
		

	}

}
