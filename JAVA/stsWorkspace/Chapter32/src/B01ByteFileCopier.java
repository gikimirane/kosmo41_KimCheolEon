import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class B01ByteFileCopier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("대상 파일 : ");
//		b01.txt
		String src = scan.nextLine();
		
		System.out.print("사본 이름 : ");
		String dst = scan.nextLine();
		
		Instant start = Instant.now();
		
		try(InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dst)) {
			int data;
			while(true) {
				data = in.read(); // 1바이트씩 읽음
				if(data == -1) {
					break;
				}
				out.write(data);
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
