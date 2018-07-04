import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A06ConversionCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Immutable 인스턴스
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		// list.add("Test"); // UnsupportedOperationException Error

		// 사용 시작
		list = new ArrayList<>(list);
		list.add("Test");

		// 반복문 출력
		for (Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();

		list.remove(1); // Test

		// ArrayList -> LinkedList 변환
		list = new LinkedList(list);

		for (Iterator<String> itr = list.iterator(); itr.hasNext();) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();

	}

}
