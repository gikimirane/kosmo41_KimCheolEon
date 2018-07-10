import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import javax.swing.text.Position;

public class C01FileCopierNIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("대상 파일 : ");
		Path p1 = Paths.get(scan.nextLine());
		
		System.out.print("사본 파일 : ");
		Path p2 = Paths.get(scan.nextLine());
		
		//Non - direct
		ByteBuffer buf = ByteBuffer.allocate(1024);
		//direct
//		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		
		Instant start = Instant.now();
		
		try (FileChannel ifc = FileChannel.open(p1, StandardOpenOption.READ);
				FileChannel ofc = FileChannel.open(p2, StandardOpenOption.WRITE, 
						StandardOpenOption.CREATE)){
			int num;
			while(true) {
				num = ifc.read(buf);
				if(num == -1) {
					break;
				}
				buf.flip();
				ofc.write(buf);
				buf.clear();
			}
			Instant end = Instant.now();
//			Duration between = Duration.between(start, end); // 두 시각 차
//			System.out.println("밀리 초 단위 차 : " + between.toMillis());
			System.out.println("밀리 초 단위 차 : " + Duration.between(start, end).toMillis());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
