import java.time.ZoneId;

public class B02ZoneIdDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//시간대별 문자열 정보 전체 출력
		//컬렉션 이라서 안에있는거 그냥 다 꺼내버리는듯?
		//ZoneId뿐 아니라 많은게 있다
//		ZoneId.getAvailableZoneIds()
//		.stream()
//		.sorted()
//		.forEach(s -> System.out.println(s));
		
		//아시아 지역만 필터
		ZoneId.getAvailableZoneIds()
		.stream()
		.filter(s -> s.startsWith("Asia"))
		.sorted()
		.forEach(s -> System.out.println(s));

	}

}
