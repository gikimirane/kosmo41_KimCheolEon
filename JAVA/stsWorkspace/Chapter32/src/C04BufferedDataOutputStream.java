import java.io.*;

public class C04BufferedDataOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(DataOutputStream out = 
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("data.txt")))) {
			out.writeInt(370);
			out.writeDouble(3.14);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
