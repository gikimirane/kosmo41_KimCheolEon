import java.util.*;

//비교를 위한 Comparator를 오버라이딩하자

class AgeComparator implements Comparator<Integer>{
//	@Override
	public int compare(Integer n1, Integer n2) {
		return n2.intValue() - n1.intValue();
	}
}

public class E04TreeMapReverseAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeMap<Integer, String> map = new TreeMap<>();
//		-- Age 역순
		TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());

		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");

		// Key만 담고있는 컬렉션 인스턴스 생성
		Set<Integer> keys = map.keySet();

		// 전체 Key 출력
		for (Integer n : keys) {
			System.out.print(n.toString() + "\t");
		}
		System.out.println();

		// 전체 value 출력 (for-each)
		for (Integer v : keys) {
			System.out.print(map.get(v).toString() + "\t");
		}
		System.out.println();

		// 전체 value 출력 (반복자)
		for (Iterator<Integer> itr = keys.iterator(); itr.hasNext();) {
			System.out.print(map.get(itr.next()) + "\t");
		}
	}

}
