
public class H02ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// copyof 는 새로 만들어서 넣는거고
		// arraycopy는 이미 만들어진 친구한테 복사함

		double[] org = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		double[] cpy = new double[3];

		// 배열 org의 인덱스 1에서 배열 cpy 인덱스 0으로 세개의 요소 복사
		System.arraycopy(org, 1, cpy, 0, 3);

		for (double d : cpy) {
			System.out.print(d + "\t");
		}
		System.out.println();
	}
}
