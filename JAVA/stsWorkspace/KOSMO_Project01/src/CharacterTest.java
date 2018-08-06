
public class CharacterTest {

	public static void main(String[] args) {

		char test = 'a';

		String test2 = "9123cdefg";
		// 0 = 48
		// 9 = 57

		int MaxLength = test2.length() - 1;

		// for(int i = 0; i < MaxLength; i++) {
		// if(!((int)test2.charAt(i) >= 48 && (int)test2.charAt(i) <= 57)) {
		// System.out.println("오류입니다. : index-"+i);
		// return;
		// }
		// }

		for (int i = 0; i < MaxLength; i++) {
			switch (test2.charAt(i)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				break;
			default:
				System.out.println("오류입니다. : index-" + i);
				return;
			}
		}
	}

}
