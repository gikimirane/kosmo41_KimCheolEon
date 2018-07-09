import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

//두 LocalDateTime 인스턴스 간의 시각과 날짜의 차

public class A07LocalDateTimeDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 현재 시간
		LocalDateTime today = LocalDateTime.of(2020, 4, 25, 11, 20);
		LocalDateTime flight1 = LocalDateTime.of(2020, 5, 14, 11, 20);
		LocalDateTime flight2 = LocalDateTime.of(2020, 5, 13, 15, 30);

		// 빠른 항공편 선택
		LocalDateTime myFlight;
		if (flight1.isBefore(flight2)) {
			myFlight = flight1;
		} else {
			myFlight = flight2;
		}
		
		//빠른 항공편 탑승까지 남은 날짜
		Period day = Period.between(today.toLocalDate(), myFlight.toLocalDate());
		
		//빠른 항공편 탑승까지 남은 시간
		Duration time = Duration.between(today.toLocalTime(), myFlight.toLocalTime());
		
		System.out.println(day);
		System.out.println(time);

	}

}
