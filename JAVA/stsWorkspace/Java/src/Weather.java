
public class Weather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wdata today = new Wdata();
		
		today.month = 10;
		today.day = 5;
		today.sky = "맑음";
		
		System.out.println(today.month + "월 " +
							today.day + "일 " + 
							today.sky);	
	}

}

class Wdata{
	int month;
	int day;
	String sky;
}