
public class StringMatchesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "김철언:/to 김철언";
		
		if (s.matches(".*:/.*") == true) {
			// sendAllMsg("인터셉트ALL");
			System.out.println(s);
		}

	}

}
