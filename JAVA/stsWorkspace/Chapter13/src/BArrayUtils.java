import java.util.Arrays;

public class BArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ar1 = new int[10];
		int[] ar2 = new int[10];
		
		//Arrays.fill(ar1, 7); //배열 ar1을 7로 초기화;
		
		for(int i = 0; i < 10; i++) {
			ar1[i] = i;
		}
		
		System.arraycopy(ar1, 0, ar2, 3, 4);
		//(arg1, arg2, arg3, arg4, arg5);
		//원본, 읽을 위치, 복사대상, 쓸 위치, 얼만큼 쓸지
		
		for(int i = 0; i < ar1.length; i++) {
			System.out.print(ar1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < ar2.length; i++) {
			System.out.print(ar2[i] + " ");
		}

	}

}
