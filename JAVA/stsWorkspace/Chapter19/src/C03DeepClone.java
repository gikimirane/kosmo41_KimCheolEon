class Point3 implements Cloneable {
	private int xPos;
	private int yPos;

	public Point3(int x, int y) {
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

////////////////////////////////////////////////////////////////////////////////////

class Rectangle2 implements Cloneable {
	// private Point2 upperLeft;
	// private Point2 lowerRight;
	public Point3 upperLeft;
	public Point3 lowerRight;

	public Rectangle2(int x1, int y1, int x2, int y2) {
		upperLeft = new Point3(x1, y1);
		lowerRight = new Point3(x2, y2);
	}

	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// Object 클래스의 clone 메소드 호출 결과를 얻는다.
		Rectangle2 copy = (Rectangle2) super.clone();

		// 깊은 복사의 형태로 복사본을 수정
		copy.upperLeft = (Point3) upperLeft.clone();
		copy.lowerRight = (Point3) lowerRight.clone();

		// 완성된 복사본의 참조를 반환
		return copy;
	}

	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();

		System.out.print("우측 하단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
}

public class C03DeepClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle2 org = new Rectangle2(1, 1, 2, 2);
		Rectangle2 cpy;

		try {
			cpy = (Rectangle2) org.clone();

			org.changePos(3, 3, 5, 5);

			org.showPosition();
			cpy.showPosition();

			if (org.equals(cpy)) {
				System.out.println("org, cpy 오브젝트 같음");
			} else {
				System.out.println("org, cpy 오브젝트 다름");
			}

			if (org.lowerRight.equals(cpy.lowerRight)) {
				System.out.println("org.lower 와 cpy.lower 가 같음");
			} else {
				System.out.println("org.lower 와 cpy.lower 가 다름");
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
