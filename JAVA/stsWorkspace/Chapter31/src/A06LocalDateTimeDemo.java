import java.time.LocalDateTime;

//지금으로부터 22시간 35분 뒤의 시각과 날짜는? : LocalDateTime 클래스
//LocalDate는 날짜 정보를, LocalTime은 시각정보를,
//LocalDateTime은 시각과 날짜 둘다 나타냄

//협정세계시 : Coordinated Universal Time, UTC
//에 대한 조정을 나중에 고민하게 되긴 할것임

public class A06LocalDateTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//현재 날짜와 시각
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		//영국 바이어와 미팅...
		LocalDateTime mt = dt.plusHours(22);
		mt = mt.plusMinutes(35);
		
		//약속 시간
		System.out.println(mt);
	}
}
