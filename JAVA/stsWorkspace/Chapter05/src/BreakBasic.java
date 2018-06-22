
public class BreakBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 1;
		boolean search = false;
		
		
		//처음 만나는 5의 배수이자 7의 배수 찾기
		while(num < 100) {
			if((num % 5) == 0 && (num % 7) == 0) {
				search = true;
				break;
			}
			num++;
		}
		
		if(search) {
			System.out.println("찾은 정수 : "+num);
		}
		else {
			System.out.println("없나?");
		}
		
	}

}
