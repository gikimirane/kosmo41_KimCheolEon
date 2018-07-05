import java.util.*;

public class A02StringBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		list.add("Weapon");
		
		Collections.sort(list);
		
		//탐색의 결과는 인덱스 반환
		int search = Collections.binarySearch(list, "Robot");
		//대소문자 바뀌면 못찾음
//		int search = Collections.binarySearch(list, "ROBot");
		
//		System.out.println(search);
		//인덱스를 통한 get
		System.out.println(list.get(search));
	}

}