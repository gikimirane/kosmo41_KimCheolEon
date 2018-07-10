import java.io.*;

public class E03ObjectInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Object.bin"))) {

			E01Sbox box1 = (E01Sbox) oi.readObject(); // 인스턴스 복원
			System.out.println(box1.get());
			
			E01Sbox box2 = (E01Sbox) oi.readObject(); // 인스턴스 복원
			System.out.println(box2.get());

		} catch (ClassNotFoundException e) { //얘 없으니까 오류나네
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
