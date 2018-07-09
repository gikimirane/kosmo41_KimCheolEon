import java.time.Duration;
import java.time.LocalTime;

//LocalTime 클래스와 Duration 클래스

public class A05LocalTimeDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PC방 이용시작 시각
		LocalTime start = LocalTime.of(14, 24, 35);
		System.out.println("PC 이용시작 시각 : " + start);
		
		//PC방 이용종료 시각
		LocalTime end = LocalTime.of(17, 31, 19);
		System.out.println("PC 이용종료 시각 : " + end);
		
		//이용 시간
		Duration between = Duration.between(start, end);
		System.out.println("총 이용시간 : " + between);
		System.out.println("총 이용시간 : " + between.toHours() + " : "
		+ between.toMinutes() + " : " + between.toMillis());

	}

}
