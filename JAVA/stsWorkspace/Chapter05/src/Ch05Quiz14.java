/*문제 05-14
다음 식을 만족하는 모든 A와 Z를 구하는 프로그램을 작성하라
 AZ
+ZA
-----
 99
단, A와 Z는 서로다른 숫자이다.*/

public class Ch05Quiz14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문제5-14. AZ + ZA = 99 를 만족하는 A와 Z를 구하라");

		// 이거 너무 야매인듯 기각
		// int i = -1;
		// int j = 10;
		// while(true) {
		// i++;
		// j--;
		// System.out.println(i +""+ j);
		// System.out.println(j +""+ i);
		// System.out.println("-----");
		// System.out.println((i+j)+""+(j+i));
		//
		// if(i == 9) {
		// break;
		// }
		// System.out.println("");
		// System.out.println("");
		// }

		for (int i = 0, j = 9; i < 10; i++, j--) {
			// System.out.println(i + ", " + (9-i));
			// System.out.println((9-i) + ", " + i);
			// System.out.println((i+(9-i)) + ", " + (i+(9-i)));
			System.out.println(i + "" + j);
			System.out.println(j + "" + i);
			System.out.println("-----");
			System.out.println((i + j) + "" + (i + j));
			System.out.println();
		}
	}
}
