import java.util.*;

public class H01ArraysCopyOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// copyof 는 새로 만들어서 넣는거고
		// arraycopy는 이미 만들어진 친구한테 복사함
		
		double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		//배열 전체를 복사
		double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
		
		//세번째 요소까지 복사
		double[] arCpy2 = Arrays.copyOf(arOrg, 3);
		
		for(double d : arCpy1) {
			System.out.printf(d + "\t");
		}
		System.out.println();
		
		for(double d : arCpy2) {
			System.out.printf(d + "\t");
		}
		System.out.println();
	}

}
