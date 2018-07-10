import java.io.*;

public class D01SimpleWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Writer out = new FileWriter("d01.txt")) {
			out.write('A');
			out.write('한');
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
