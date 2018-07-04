import java.util.LinkedList;
import java.util.List;

public class A02LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new LinkedList<>();

		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Robot");
		list.remove(0);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();

		list.remove(0);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();

	}

}
