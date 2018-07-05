import java.util.*;

class strComp implements Comparator<String>{
	@Override
	public int compare(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}
}

public class A03StringBinarySearchByComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("BOX");
		list.add("ROBOT");
		list.add("APPLE");
		list.add("WEAPON");
		
		strComp comp = new strComp(); // 정렬과 탐색의 기준 
		Collections.sort(list, comp); // 정렬
		
		//탐색의 결과는 인덱스 반환, 이번엔 대소문자 무시하고 찾음
		int search = Collections.binarySearch(list, "Robot", comp);
		
//		System.out.println(search);
		//인덱스를 통한 get
		System.out.println(list.get(search));
	}
}
