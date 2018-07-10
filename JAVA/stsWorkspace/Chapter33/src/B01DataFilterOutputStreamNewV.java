import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B01DataFilterOutputStreamNewV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path fp = Paths.get("data.dat");
		
		try (DataOutputStream out = 
				new DataOutputStream(
						Files.newOutputStream(fp))){
			out.writeInt(370);
			out.writeDouble(3.14);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
