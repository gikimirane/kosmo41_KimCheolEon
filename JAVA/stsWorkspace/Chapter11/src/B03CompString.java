
public class B03CompString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st1 = "a";
		String st2 = "c";
		int cmp;

		if (st1.equals(st2)) {
			System.out.println("두 문자열은 같음");
		} else {
			System.out.println("두 문자열은 다름");
		}

		
//		System.out.println(st1.length());
		cmp = st1.compareTo(st2); // 설명을 읽어보니 비교는 유니코드값을 기반으로 한다고 함
		// 같은문자, 즉 equal로 true 면 0이 나옴
		// 다른문자일 때, 비교하려는 st1.이 0을 중심으로 (st2)보다 선행하는 만큼 - 값이 나오고, 뒤쪽이면 + 값 나옴
		
		System.out.println("st1.compareTo(st2) : " + cmp);
//		
//		cmp = st2.compareTo(st1);
//		System.out.println("st2.compareTo(st1) : " + cmp);

		if (cmp == 0) {
			System.out.println("두 문자열은 일치");
		} else if(cmp < 0) {
			System.out.println("st1 이 st2 보다 사전 앞에 위치함 : " + st1);
		}
		else {
			System.out.println("st2 이 st1 보다 사전 앞에 위치함 : " + st2);
		}
		
		System.out.println(st1.compareToIgnoreCase(st2));
		
		if(st1.compareToIgnoreCase(st2) == 0) {
			System.out.println("두 문자열은 같다.");
		}else {
			System.out.println("두 문자열은 다르다.");
		}

	}

}
