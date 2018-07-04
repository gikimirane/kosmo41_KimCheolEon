import java.util.ArrayList;
import java.util.List;

//import java.util.*;

public class A01ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();
		
		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Robot");
		list.remove(0);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
		
		list.remove(0);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();		
	}
}

// 배열 기반 자료구조이지만 공간의 확 보 및 확장은
// ArrayList 인스턴스가 스스로 처리한다.
