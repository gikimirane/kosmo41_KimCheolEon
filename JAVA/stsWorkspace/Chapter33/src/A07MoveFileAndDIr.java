import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A07MoveFileAndDIr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//파일의 이동
//		Path src = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath\\src.txt");
//		Path dst = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath\\t1\\dst.txt");
		
		//폴더의 이동
		//어디서 쓰고있으면 좀 오류날 수가 있음
		Path src = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath2");
		Path dst = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath3");
		
		Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);

	}

}
