
public class Ch05Quiz13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("����5-13. ������ ���, ������, ������ �̻ڰ�");
		
		System.out.println("");
		System.out.println("����");
		for(int j = 1; j < 10; j++) {
			System.out.println("");
			for(int i = 2; i < 10; i++) {
				System.out.print(i + " X " + j + " = " + (i*j) + "\t");
			}
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("����");
		//�� ���� �׽�Ʈ �ϴٰ� ���κ��� �������;;
		for(int i = 2; i < 10; i++) {
			System.out.println("");
			for(int j = 1; j < 10; j++) {
				System.out.print(i + " X " + j + " = " + (i*j) + "\t");
			}
		}
		
//		for(int i = 1; i < 10; i++) {
//			System.out.println(i+"��---------------------");
//			for(int j = 1; j < 10; j++) {
//				System.out.println(i + " X " + j + " = " + (i*j));
//			}
//		}

	}

}
