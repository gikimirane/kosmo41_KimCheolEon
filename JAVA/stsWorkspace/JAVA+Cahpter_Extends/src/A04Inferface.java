interface Hello{
	void hello();
}

interface Talk{
	void talk();
}

class Morning implements Hello, Talk{
	public void hello() {
		System.out.println("안녕하세요!");
	}
	public void talk() {
		System.out.println("날씨 좋네요.");
	}
}


public class A04Inferface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Morning mor = new Morning();
		
		mor.hello();
		mor.talk();
	}

}
