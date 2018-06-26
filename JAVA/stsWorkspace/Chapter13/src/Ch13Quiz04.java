import java.util.Arrays;
import java.util.Scanner;

class ArrayInsert{
	void insert(int[] array) {
		
		int[] buffer = new int[10];

//		for (int i = 0, j = 0; i < array.length; i++) {
//			if (array[i] % 2 == 0) {
//				buffer[j] = array[i];
//				j++;
//			}
//		}
//		
//		for (int i = 0, j= array.length; i< array.length; i++) {
//			if(array[i] % 2 == 1) {
//				buffer[j-1] = array[i];
//				j--;
//			}
//		}
		
		for (int x = 0, y = 0, z= array.length; x < array.length; x++) {
			if (array[x] % 2 == 0) {
				buffer[y] = array[x];
				y++;
			}
			if (array[x] % 2 ==1) {
				buffer[z-1] = array[x];
				z--;
			}
		}
		
		System.out.println("배열(toString) : " + Arrays.toString(buffer));
		
	}
}

public class Ch13Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("문제13-04. 길이10배열, 홀짝에 따라 배열 양끝에서 채우기");

		Scanner scan = new Scanner(System.in);
		ArrayInsert numInsert = new ArrayInsert();
		
		int[] nArray = new int[10];

		for (int i = 0; i < nArray.length; i++) {
			System.out.println("정수를 입력하세요 : ");
			nArray[i] = scan.nextInt();
		}
		
		numInsert.insert(nArray);
	}

}
