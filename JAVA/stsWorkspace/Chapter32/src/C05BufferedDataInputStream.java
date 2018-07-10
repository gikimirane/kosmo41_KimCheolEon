import java.io.*;

public class C05BufferedDataInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(DataInputStream in = 
				new DataInputStream(
						new BufferedInputStream(
								new FileInputStream("data.txt")))) {
			int num1 = in.readInt();
			double num2 = in.readDouble();
			
			System.out.println(num1);
			System.out.println(num2);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		

	}

}
