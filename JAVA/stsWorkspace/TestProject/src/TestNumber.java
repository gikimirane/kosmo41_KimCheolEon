
public class TestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mNumber = {
				{0,0},
				{0,1},
				{0,2},
				{1,0},
				{1,1},
				{1,2},
				{2,0},
				{2,1},
				{2,2}
				};
		int x,y;

		
		for(int i = 0; i < 9; i++) {
			x=mNumber[i][0];
			y=mNumber[i][1];
			System.out.println(x + " " + y);
			
		}
		
		
	}

}
