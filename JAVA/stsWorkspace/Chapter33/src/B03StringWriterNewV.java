import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B03StringWriterNewV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ks = "공부에 있어서 - - -";
		String es = "My life for aiur - - -";
		
		Path fp = Paths.get("String.txt");
		
		try(BufferedWriter bw = Files.newBufferedWriter(fp)) {
			bw.write(ks, 0, ks.length());
			bw.newLine();
			bw.write(es, 0, es.length());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
