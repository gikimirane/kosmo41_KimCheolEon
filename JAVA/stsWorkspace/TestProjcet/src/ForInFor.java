
public class ForInFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// for(int i = 0; i < 3; i++) {
		// System.out.println("---------------------");
		// for(int j = 0; j < 3; j++) {
		// System.out.printf("[%d, %d] ", i, j);
		// }
		// System.out.println('\n');
		// }
		
/*		for (int i = 0; i < 3; i++) {
			System.out.println("i = " + i);
			for (int j = 0; j < 3; j++) {
				System.out.println("   j= "+j);
			}
			System.out.println("---------------------");
		}*/
		
/*		for(int i = 1; i < 10; i++) {
			System.out.println(i+"´Ü---------------------");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}*/
		
		int i = 0;
		int j = 0;
		while(i<10) {
			i++;
			System.out.println(i+"´Ü---------------------");
			while(j<10) {
				j++;
				System.out.println(i + " X " + j + " = " + (i*j));
				continue;
			}
		}
		

	}

}
