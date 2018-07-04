import java.util.LinkedList;
import java.util.List;

public class A03EnhancedForCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new LinkedList<>();

		list.add("Toy");
		list.add("Box");
		list.add("Robot");
		list.add("Robot");
		list.remove(0);

		for (String s : list) {
			System.out.print(s + "\t");
		}
		System.out.println();

		list.remove(0);

		for (String s : list) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

}
