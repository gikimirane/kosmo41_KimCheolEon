import java.util.*;

public class A01CollectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Weapon");
		list = new ArrayList<>(list);
		
		//정렬이전 출력
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		System.out.println();
		
		//정렬 - sort
		Collections.sort(list);
		
		//정렬 이후 출력
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
			System.out.print(itr.next() + "\t");
		}
	}

}
