
public class Ch05Quiz09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("¹®Á¦5-9. 1~100 Â¦¼ö ÇÕ. ´Ü do-while »ç¿ë");
		
		int num = 0;
		int buffer = 0;
		
		do {
			num++;
			if((num % 2) == 0) {
				System.out.println("buffer += " + num);
				buffer += num;
			}
		}while(num <= 100);
		
		System.out.println("ÃÑ ÇÕ : " + buffer);
	}
}
