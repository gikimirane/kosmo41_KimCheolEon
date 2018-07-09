import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//시간대를 반영한 예제

public class B04ZoneDateTimeDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 한국출발 2017-09-09 14:30
		ZonedDateTime departure = 
				ZonedDateTime.of(LocalDateTime.of(2017, 12, 9, 14, 30), 
						ZoneId.of("Asia/Seoul"));
		System.out.println("Departure : " + departure);
		
		//파리 도착 2-17-09-09 17:25
		ZonedDateTime arribal = 
				ZonedDateTime.of(LocalDateTime.of(2017, 12, 9, 17, 25), 
						ZoneId.of("Europe/Paris"));
		System.out.println("Departure : " + arribal);
		
		//비행시간?
		System.out.println("비행시간 계산 : " + Duration.between(departure, arribal));
	}
}
