import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A06CopyFileAndDir {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//파일의 복사
//		Path src = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath\\src.txt");
//		Path dst = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath\\t1\\dst.txt");
		
		//폴더의 복사
		Path src = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath");
		Path dst = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\TestPath\\t1\\t2");
		
		Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
	}

}
