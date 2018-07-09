import java.util.Arrays;
import java.util.stream.IntStream;

public class A01StreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 1, 2, 3, 4, 5 };
		
		//배열 ar로부터 스트림 생성
		IntStream stm1 = Arrays.stream(ar); 
		
		//중간파이프 - 홀수들이네?, 중간연산 진행
		IntStream stm2 = stm1.filter(n -> n%2 == 1);

		//최종파이프 - 최종 연산
		int sum = stm2.sum();
		
		System.out.println(sum);
	}

}
