import java.util.Arrays;

class Box{
	private String conts;
	private String contarry;
	
	Box(String cont){
		this.conts = cont;
	}
	
//	Box(String[] contarry){
////		this.contarry = contarry;
//	}

	//toString 주석처리하면 객체의 주소값이 튀어나옴
	public String toString() {
		return conts; //문자열 반환해줌
	}
	
//	public String toString(String[] ar) {
//		return conts; //문자열 반환해줌
//	}
}

public class A01ToStringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder stb = new StringBuilder("12");
		
		stb.append(34);
		
		System.out.println(stb.toString());
		System.out.println(stb);
		
		Box box = new Box("Camera");
		System.out.println(box.toString());
		System.out.println(box);
		
		
		int[] num = {1,2,3,4};
		System.out.println(num);
		System.out.println(Arrays.toString(num));
		String Text = new String();
		Text = Arrays.toString(num);
		System.out.println(Text);
	}

}
