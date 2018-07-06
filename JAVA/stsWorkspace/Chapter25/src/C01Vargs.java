
public class C01Vargs {

	public static void showAll(String... vargs) {
		System.out.println("LEN : " + vargs.length);

		for (String s : vargs) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		showAll("Box");
		showAll("Box", "Toy");
		showAll("Box", "Toy", "Apple");

	}

}
