import java.io.*;
import java.util.*;

public class HashMapEx {

	public static void main(String[] args) {

		// Map<ket, value> -> 키는 중복허용하지 않음
		// 키 중복일 때 값 변경
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("만화", "마녀배달부 키키");
		map.put("호러", "스크림");
		map.put("영화", "황혼에서 새벽까지");
		
		System.out.println(map);
		System.out.println();
		
		String key;
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			key = (String)it.next();
			System.out.println(map.get(key));
		}
		System.out.println();
		
		map.put("영화", "놀자..."); //동일한 키는 값을 변경? - 아, 덮어씌운다는 소린가
		System.out.println(map);
		System.out.println();

	}

}
