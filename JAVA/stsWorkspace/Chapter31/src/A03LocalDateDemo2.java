import java.time.LocalDate;
import java.time.Period;

//날짜의 차를 표현하기 위한 Period 클래스

public class A03LocalDateDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);

//		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		LocalDate xmas = LocalDate.of(1993, 12, 12);
		System.out.println("Xmas : " + xmas);

		// 날짜 차 - 생일
		Period left = Period.between(today, xmas);
		System.out.println("Xmas까지 앞으로 : " + left.getYears() + " 년 "
		+ left.getMonths() + " 개월 " + left.getDays() + " 일");

	}

}
