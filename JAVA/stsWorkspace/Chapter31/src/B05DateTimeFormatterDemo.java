import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class B05DateTimeFormatterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ZonedDateTime date = ZonedDateTime.of(
				LocalDateTime.of(2019, 4, 25, 11, 20), ZoneId.of("Asia/Seoul"));
		
		//출력 포맷정보는 java.time.format.DateTimeFormmater 인스턴스에 담는다.
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yy-M-d");
		DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-dd, H:m:s");
		DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss VV");
		//교재 544p 참고
		DateTimeFormatter fm4 = DateTimeFormatter.ofPattern("G yyyy-MMM-dd E, HH:mm:ss a VV Z z");
		
		System.out.println(date.format(fm1));
		System.out.println(date.format(fm2));
		System.out.println(date.format(fm3));
		System.out.println(date.format(fm4));

	}

}
