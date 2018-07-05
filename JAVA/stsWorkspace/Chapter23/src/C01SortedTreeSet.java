import java.util.*;

public class C01SortedTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		tree.add(4);
		tree.add(3);
		tree.add(1);
		tree.add(2);
		
		System.out.println("인스턴스 수 : " + tree.size());
		
		//for - each
		for(Integer n : tree) {
			System.out.print(n.toString() + "\t");
			//이 또한 마찬가지로 toString()
		}
		System.out.println();
		
		//Iterator 반복자 : ** 반복자 인스턴스의 참조순서는 오름차순 특징
		for(Iterator<Integer> itr = tree.iterator(); itr.hasNext(); ) {
//			System.out.print(itr.next() + "\t");
			//안전하기로는 이게 맞을듯
			System.out.print(itr.next().toString() + "\t");
		}
		
	}

}
