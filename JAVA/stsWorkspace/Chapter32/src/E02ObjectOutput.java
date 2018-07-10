import java.io.*;

//만약 여기에 같이 E01SBox 넣을거면 public 떼야함

public class E02ObjectOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		E01Sbox box1 = new E01Sbox("Robot");
		E01Sbox box2 = new E01Sbox("Strawberry");
		
		try (ObjectOutputStream oo = 
				new ObjectOutputStream(
						new FileOutputStream("Object.bin"))){
			
			oo.writeObject(box1);	//box1 이 참조하는 인스턴스 저장
			oo.writeObject(box2);	//box2 가 참조하는 인스턴스 저장
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
