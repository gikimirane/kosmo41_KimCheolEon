import java.util.Scanner;

public class Ch06Quiz04Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int [] num = new int[10];
		
		int oddCnt = 0;
		int evenCnt = 9;
		
		for(int i = 0; i < 10; i++) {
			System.out.println("숫자입력 : ");
			int nTmp = s.nextInt();
			if (nTmp % 2 == 0){
				num[evenCnt] = nTmp;
				evenCnt--;				
			}
			else {
				num[oddCnt] = nTmp;
				oddCnt++;
			}
		}
		
		//결과 출력
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

}
