import java.io.*;

public class D03TextWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Writer out = new FileWriter("abc.txt")) {
			for (int ch = (int) 'A'; ch < (int) ('Z' + 1); ch++) {
				out.write(ch);
			}
			
			out.write(13);
			out.write(10);
//			ASCII 코드상, 캐리지리턴, 라인피드 = 엔터
			
			for (int ch = (int) 'A' + 32; ch < (int) ('Z' + 1 + 32); ch++) {
				out.write(ch);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
