import java.util.*;

public class A07BasicTypeArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);	//저장 과정에서 오토박싱 진행
		list.add(20);
		list.add(30);
		
//		char test = 'c';
//		char test2 = "c";
		
		int n;
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
			n = itr.next();		// 오토 언박싱 진행
			System.out.print(n + '\t');
		}
		System.out.println();
	}
}
