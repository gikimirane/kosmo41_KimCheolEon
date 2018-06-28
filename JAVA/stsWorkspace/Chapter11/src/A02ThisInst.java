// 키워드 this 를 통한 인스턴스 변수의 접근

class SimpleBox{
	private int data;
	
	SimpleBox(int data){
		this.data = data;		
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}

public class A02ThisInst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleBox box = new SimpleBox(99);
		
		System.out.println(box.getData());
		
		box.setData(77);
		System.out.println(box.getData());
	}

}
