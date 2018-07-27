import java.util.ArrayList;
import java.util.HashMap;

public class HashMapArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> personMap1 = new HashMap<String, String>();
		personMap1.put("이름", "테스트");
		personMap1.put("나이", "30");
		personMap1.put("직업", "유저");

		HashMap<String, String> personMap2 = new HashMap<String, String>();
		personMap2.put("이름", "테스트2");
		personMap2.put("나이", "20");
		personMap2.put("직업", "관리자");

		list.add(personMap1);
		list.add(personMap2);

		HashMap<String, String> takeMap1 = (HashMap<String, String>) list.get(0);
		String name1 = takeMap1.get("이름");
		String age1 = takeMap1.get("나이");
		String job1 = takeMap1.get("직업");
		
		HashMap<String, String> takeMap2 = (HashMap<String, String>) list.get(1);
		String name2 = takeMap2.get("이름");
		String age2 = takeMap2.get("나이");
		String job2 = takeMap2.get("직업");
		
		
		System.out.println(name1 + ", " + age1 + ", " + job1);
		System.out.println(name2 + ", " + age2 + ", " + job2);

	}

}
