// Buffered Reader

import java.io.*;

public class D05StringReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(BufferedReader br = new BufferedReader(new FileReader("src.txt"))) {
			String str;
			
			while(true) {
				str = br.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
