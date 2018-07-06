import java.util.*;

public class C02AnonymousCoparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
		
		//익명 클래스 사용의 예///////////////////
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};
		///////////////////////////////////////////
		
		Collections.sort(list, cmp);
		System.out.println(list);
	}
}
