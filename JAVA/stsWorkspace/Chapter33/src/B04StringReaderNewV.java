import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B04StringReaderNewV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path fp = Paths.get("String.txt");

		try (BufferedReader br = Files.newBufferedReader(fp)) {
			String str;

			while (true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
