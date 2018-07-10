import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class C02FileRandomAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path fp = Paths.get("data.dat");
		
		ByteBuffer wb = ByteBuffer.allocate(1024); //버퍼생성
		
		wb.putInt(120);
		wb.putInt(240);
		wb.putDouble(0.94);
		wb.putDouble(0.75);
		
		//하나의 채널 생성
		try(FileChannel fc = FileChannel.open(fp, StandardOpenOption.CREATE,
				StandardOpenOption.READ, StandardOpenOption.WRITE)) {
			
			//파일에 쓰기
			//4 4 8 8 찍고 25번째에 와있음
			wb.flip();
			fc.write(wb);
			
			//파일 읽기
			ByteBuffer rb = ByteBuffer.allocate(1024); //버퍼생성
			//그래서 포지션 0부터 찍음
			fc.position(0); //채널 포지션 맨 앞 이동
			System.out.println(rb.toString());
			
			fc.read(rb);
			System.out.println(rb.toString());			
			
			//이하 버퍼로부터 읽기
			rb.flip();
			//flip 하니까 0으로 뛰네
			System.out.println(rb.toString());
			
			System.out.println(rb.getInt());
			System.out.println(rb.toString());
			
			rb.position(Integer.BYTES * 2);
			System.out.println(rb.toString());
			
			//Integer.BYTES : int 형 정수의 크기에 대한 상수 (=4)
			System.out.println(rb.getDouble());
			System.out.println(rb.toString());
			
			System.out.println(rb.getDouble());
			System.out.println(rb.toString());
			
			rb.position(Integer.BYTES);
			System.out.println(rb.toString());
			System.out.println(rb.getInt());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
