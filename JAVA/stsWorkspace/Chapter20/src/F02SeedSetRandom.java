import java.util.Random;

public class F02SeedSetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random(); //default
//		Random rand = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < 7; i++) {
			System.out.println(rand.nextInt(1000));
		}
	}

}
