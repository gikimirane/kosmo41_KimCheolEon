import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class B02KBFileCopier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("대상 파일 : ");
//		b02.txt
		String src = scan.nextLine();
		
		System.out.print("사본 이름 : ");
		String dst = scan.nextLine();
		
		try(InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dst)) {
			byte buf[] = new byte[1024];
			int len;
			
			Instant start = Instant.now();
			
			while(true) {
				len = in.read(buf); // 배열 buf로 데이터를 읽고, (더 없으면 -1 반환)
				if(len == -1) {
					break;
				}
				out.write(buf, 0, len); //len 바이트 만큼 데이터를 저장한다
			}
			Instant end = Instant.now();
//			Duration between = Duration.between(start, end); // 두 시각 차
//			System.out.println("밀리 초 단위 차 : " + between.toMillis());
			System.out.println("밀리 초 단위 차 : " + Duration.between(start, end).toMillis());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
