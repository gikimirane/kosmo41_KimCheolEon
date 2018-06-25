
public class SwitchBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;

		switch (n) {

		/*case 1:
			System.out.println("case1 : Simple JAVA");
			break;
			
		case 2:
			System.out.println("case2 : Funny JAVA");
			break;
			
		case 3:
			System.out.println("case3 : Fantastic JAVA");
			break;*/
		
		case 1:			
		case 2:
		case 3:
			System.out.println("case3 : Fantastic JAVA");
			break;
			//이런 case 사용도 가능
			
		default:	// 어떤 case도 해당하지 않을 경우 default
			System.out.println("default : The best programming language");
		}

		System.out.println("Out : Do you like JAVA?");

	}
}