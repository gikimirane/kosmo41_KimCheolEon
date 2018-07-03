class INum{
	private int num;
	public INum(int num) {
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.num == ((INum)obj).num) //INum타입으로 Object 를 받아서 this.num 와 비교 
			return true;
		else
			return false;
	}
}


public class B01ObjectEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		INum num1 = new INum(10);
		INum num2 = new INum(12);
		INum num3 = new INum(10);
		
		// 결국 equals 메소드는 내부의 값을 본다는 소리
		// (== 하면 참조값 주소가 다르니까 비교불가)
		if(num1.equals(num2)) {
			System.out.println("num1, num2 내용은 동일함");
		}
		else {
			System.out.println("num1, num2 내용 다름");
		}
		
		if(num1.equals(num3)) {
			System.out.println("num1, num3 내용은 동일함");
		}
		else {
			System.out.println("num1, num3 내용 다름");
		}
		//Answer;
		//인스턴스의 내용 비교를 위한 기능을 equals 메서드에 담아 정의한다.
		//equals 는 object 클래스의 메서드이다.		
	}

}
