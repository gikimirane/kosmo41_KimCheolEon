
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
			//�̷� case ��뵵 ����
			
		default:	// � case�� �ش����� ���� ��� default
			System.out.println("default : The best programming language");
		}

		System.out.println("Out : Do you like JAVA?");

	}
}
