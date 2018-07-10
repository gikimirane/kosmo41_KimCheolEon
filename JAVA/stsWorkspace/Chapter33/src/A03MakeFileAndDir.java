import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A03MakeFileAndDir {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		Path fp = Paths.get("D:\\kchy12345\\SourceTree\\JAVA\\create.txt");
//		fp = Files.createFile(fp);	// 파일생성 - 그 경로에 같은 파일있을시 에러
//		System.out.println("File : " + fp);
		
//		Path dp1 = Paths.get("D:\\kchy12345\\SourceTree\\TEST");
//		dp1 = Files.createDirectory(dp1); // 폴더생성 - 그 경로에 같은 폴더 있을시 에러
//		System.out.println("Dir1 : " + dp1);
//		
		Path dp2 = Paths.get("D:\\kchy12345\\SourceTree2\\JAVA");
		dp2 = Files.createDirectories(dp2); // 폴더생성 - 없으면 새로만들거나, 있어도 무방함
		System.out.println("Dir2 : " + dp2);

	}

}
