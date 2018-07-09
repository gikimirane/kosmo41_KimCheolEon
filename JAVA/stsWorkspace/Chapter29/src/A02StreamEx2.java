import java.util.Arrays;
import java.util.stream.IntStream;

public class A02StreamEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 1, 2, 3, 4, 5 };
		
		//이렇게 생략 가능;;
		int sum = Arrays.stream(ar)
				.filter(n -> n % 2 == 1)
				.sum(); //sum 통과결과 반환

//		// 배열 ar로부터 스트림 생성
//		IntStream stm1 = Arrays.stream(ar);
//
//		// 중간파이프 - 홀수들이네?, 중간연산 진행
//		IntStream stm2 = stm1.filter(n -> n % 2 == 1);
//
//		// 최종파이프 - 최종 연산
//		int sum = stm2.sum();

		System.out.println(sum);

	}

}
