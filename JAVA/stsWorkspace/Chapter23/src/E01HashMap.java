// Map 인데 Hash 가 붙었다는것은 빠른 읽기를 위함 (hashCode 기반)

import java.util.*;

public class E01HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");
		
		System.out.println("23번 : " + map.get(23));
		System.out.println("45번 : " + map.get(45));
		System.out.println("37번 : " + map.get(37));
		System.out.println();
		
		map.remove(45);
		
		System.out.println("45번 : " + map.get(45));		
	}

}
