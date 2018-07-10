import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class C03BufferedOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("대상 파일 : ");
//		b01.txt
		String src = scan.nextLine();
		
		System.out.print("사본 이름 : ");
		String dst = scan.nextLine();
		
		Instant start = Instant.now();
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
			int data;
			
			while(true) {
				data = in.read(); //바이트단위 복사이지만 버퍼링이므로 속도가 빠르다?
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
