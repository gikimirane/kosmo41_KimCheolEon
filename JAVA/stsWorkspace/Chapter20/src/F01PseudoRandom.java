import java.util.Random;

public class F01PseudoRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random(12);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(rand.nextInt(1000));
		}

	}

}
