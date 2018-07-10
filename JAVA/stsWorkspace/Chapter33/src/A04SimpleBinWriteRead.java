import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class A04SimpleBinWriteRead {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//이 경로가 없거나, 같은 이름 있을 시 에러
		Path fp = Paths.get("D:\\kchy12345\\SourceTree\\simple.bin");
		
		fp = Files.createFile(fp);

		byte buf1[] = { 0x13, 0x14, 0x15 };
		
		for(byte b : buf1) {
			System.out.print(b + "\t");
		}
		System.out.println();
		
		Files.write(fp, buf1, StandardOpenOption.APPEND);
		
		byte buf2[] = Files.readAllBytes(fp);
		
		for(byte b : buf2) {
			System.out.print(b + "\t");
		}
		System.out.println();

	}

}
