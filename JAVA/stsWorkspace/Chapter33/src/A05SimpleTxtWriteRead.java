import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class A05SimpleTxtWriteRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path fp = Paths.get("D:\\kchy12345\\SourceTree\\simple.txt");
		
		String st1 = "One Simple String";
		String st2 = "Two Not Simple String";
		List<String> list1 = Arrays.asList(st1, st2);
		
		//파일에 문자 데이터 쓰기
		Files.write(fp, list1);
		
		//파일로부터 문자 데이터 읽기
		List<String> list2 = Files.readAllLines(fp);
		System.out.println(list2);
	}
}
