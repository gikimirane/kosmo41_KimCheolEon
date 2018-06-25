
public class ContinueBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;
		int count = 0;
		
	
		while(num < 100) {
			num++;
			if(((num % 5) != 0) || ((num % 7) != 0)) {
				num++;
				continue;
			}
			count++;
			System.out.println(num);
		}
		System.out.println("count : "+count);
	}
}