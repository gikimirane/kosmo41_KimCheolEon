class Point2 implements Cloneable {
	private int xPos;
	private int yPos;

	public Point2(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Rectangle implements Cloneable {
//	private Point2 upperLeft;
//	private Point2 lowerRight;
	public Point2 upperLeft;
	public Point2 lowerRight;

	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point2(x1, y1);
		lowerRight = new Point2(x2, y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
	
	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();
		
		System.out.print("우측 하단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
}

public class C02ShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle org = new Rectangle(1, 1, 9, 9);
		Rectangle cpy;
		
		try {
			cpy = (Rectangle)org.clone();
			
			org.changePos(2, 2, 7, 7);
			
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy)) {
				System.out.println("org, cpy 오브젝트 같음");
			}
			else {
				System.out.println("org, cpy 오브젝트 다름");
			}
			
			if(org.lowerRight.equals(cpy.lowerRight)) {
				System.out.println("org.lower 와 cpy.lower 가 같음");
			}
			else {
				System.out.println("org.lower 와 cpy.lower 가 다름");
			}
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
