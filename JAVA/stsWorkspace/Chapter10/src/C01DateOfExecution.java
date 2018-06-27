import java.time.LocalDate;

public class C01DateOfExecution {
	
	static String date;

	// static 초기화 블록
	// 인스턴스 생성 관계 없이 static 변수가 메모리 공간에 할당될 때 실행됨
	static {
		LocalDate nDate = LocalDate.now();
		date = nDate.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(date);	
		
		System.out.println(Math.PI);
	
	}

}
