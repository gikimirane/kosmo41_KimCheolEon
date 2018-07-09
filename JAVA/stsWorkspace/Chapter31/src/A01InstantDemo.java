import java.time.Duration;
import java.time.Instant;

//시간이 얼마나 걸렸지? : Instant 클래스

public class A01InstantDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Instant start = Instant.now();
		System.out.println("시작 : " + start.getEpochSecond());
		//반환값은 1970-01-01 00:00을 기준으로 지나온 시간 밀리초 단위
		
		System.out.println("Time files like an arrow");
		
		Instant end = Instant.now(); //현재 시각 정보
		System.out.println("끝 : " +end.getEpochSecond());
		
		//duration 은 시각차를 표현하기 위한 클래스
		Duration between = Duration.between(start, end); // 두 시각 차
		
		System.out.println("밀리 초 단위 차 : " + between.toMillis());
	}
}
//이 예제를 기반으로 병렬스트림과 순차 스트림의 성능테스트를 할 수도 있다.
