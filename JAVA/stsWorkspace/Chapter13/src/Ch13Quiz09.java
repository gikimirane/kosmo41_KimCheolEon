import java.util.Arrays;
import java.util.Scanner;

public class Ch13Quiz09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제 13-9. 배열 {210,19,72,129,34} 정렬하시오.");

		Scanner scan = new Scanner(System.in);

		 int[] numArray = new int[5];
//		int[] numArray = { 210, 19, 72, 129, 34 };

		 for(int i = 0; i < numArray.length; i++) {
		 System.out.println("숫자 입력 : ");
		 numArray[i] = scan.nextInt();
		 }

		System.out.println("숫자 입력 완료");

		System.out.println(Arrays.toString(numArray));
		System.out.println();

		int buffer = 0;
		for (int i = 0; i < numArray.length; i++) {
			for (int j = 1; j < numArray.length; j++) {

				if (numArray[j - 1] > numArray[j]) {
					buffer = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = buffer;
				}

			}
		}
		System.out.println(Arrays.toString(numArray));
	}
}
