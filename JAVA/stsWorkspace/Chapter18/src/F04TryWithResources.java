import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class F04TryWithResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path file = Paths.get("C:\\javastudy\\Simple.txt");
		
		//try 구문을 빠져나갈 때 다음 문장을 안정적으로 자동 실행 writer.close();
		try(BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write('A');
			writer.write('Z');
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
