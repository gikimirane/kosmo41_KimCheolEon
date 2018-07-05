import java.util.*;

public class B01SetCollectionFeature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<>();
		
		set.add("Toy");
		set.add("Box");
		set.add("Robot");
		set.add("Box");
		
		System.out.println("인스턴스 수 : " + set.size());
		
		//반복자를 이용한 출력
		for(Iterator<String> itr = set.iterator(); itr.hasNext(); ) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		
		//for-each 문을 이용한 출력
		for(String s : set) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

}

//Set<E> 인터페이스를 구현하는 제네릭 클래스들은 다음 두 가지 특성을 갖는다.
// 저장순서가 유지되지 않는다
// 데이터의 중복저장을 허용하지 않는다