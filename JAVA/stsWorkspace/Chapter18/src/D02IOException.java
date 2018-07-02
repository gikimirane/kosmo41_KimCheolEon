import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D02IOException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//해당 경로에 실제 폴더가 있다면 오류x
		Path file = Paths.get("C:\\javastudy\\Simple.txt");
		System.out.println("\\");
		System.out.println("\"");
		System.out.println("\t");
		BufferedWriter writer = null;
		
		try {
			writer = Files.newBufferedWriter(file);
			writer.write('A');	// IOException 발생가능
			writer.write('Z');	// IOException 발생가능
			
			if(writer != null) {
				writer.close(); // IOException 발생가능
			}
		}
		//Exception 을 상속하는 예외는 반드시 처리를 해야 한다.
		//그렇지 않으면 컴파일 오류로 감
		catch (IOException e){
			e.printStackTrace();
		}	
	}

}
