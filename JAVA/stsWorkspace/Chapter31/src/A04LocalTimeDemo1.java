import java.time.LocalTime;

//2시간 10분뒤에 어때? : LocalTime 클래스

public class A04LocalTimeDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//현재시간
		LocalTime now = LocalTime.now();
		System.out.println("지금 시각 : " + now);
		
		//2시간 10분 뒤 예정
		LocalTime mt = now.plusHours(2);
		mt = mt.plusMinutes(10);
		
		System.out.println("예정 시간 : " + mt);
	}

}
