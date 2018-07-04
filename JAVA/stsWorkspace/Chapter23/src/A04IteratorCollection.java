import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A04IteratorCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new LinkedList<>();
		
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Box");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		
		itr = list.iterator();
		
		String str;
		while(itr.hasNext()) {
			str = itr.next();
			if(str.equals("Box")){
				itr.remove();
			}
		}
		
		itr = list.iterator();
		//계속 반복자를 다시 획득하는데,
		// 하나로 계속 쓰면 숫자가 안맞을 수 있음
		// 반복문으로 돌리기 전에 한번 더 획득하고 씀이 안전함
		
		while(itr.hasNext()) {
			System.out.print(itr.next() + "\t");
		}
		System.out.println();		
	}

}
