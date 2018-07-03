class Point implements Cloneable{
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone(); //object 클래스의 clone 메소드 호출
		
	}//원래 클론이 protected 라는데 public 으로 바꾸기 위한 작업
}

public class C01InstanceClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point org = new Point(3, 8);
		Point cpy;
		
		try {
			cpy = (Point)org.clone();
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy)) {
				System.out.println("같은 내용");
			}
			else {
				System.out.println("다른 내용");
			}
			
			if(org == cpy) {
				System.out.println("같은 인스턴스");
			}
			else {
				System.out.println("다른 인스턴스");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
