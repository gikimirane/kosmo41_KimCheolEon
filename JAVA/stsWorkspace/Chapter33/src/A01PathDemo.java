import java.nio.file.Path;
import java.nio.file.Paths;

public class A01PathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//절대 경로
		Path pt1 = Paths.get("C:\\JavaStudy\\PathDemo.java");
		
		//루트 디렉토리 반환
		Path pt2 = pt1.getRoot();
		
		//부모 디렉토리 반환
		Path pt3 = pt1.getParent();
		
		//파일 이름 반환
		Path pt4 = pt1.getFileName();
		
		//get 반환은 해당 파일및 경로의 존재여부에 상관없이 반환
		
		System.out.println("Absolute : " + pt1);
		System.out.println("Root : " + pt2);
		System.out.println("Parent : " + pt3);
		System.out.println("File : " + pt4);
	}

}
