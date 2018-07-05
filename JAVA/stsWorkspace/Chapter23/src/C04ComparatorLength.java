import java.util.*;

class StringComparator implements Comparator<String>{
	public int compare(String s1, String s2) {
		
		if(s1.length() - s2.length() == 0) {
//			return java.util.Comparator.compare(s1, s1);
			System.out.println("글자 같음");
		}
		
		return s1.length() - s2.length();
	}
}

public class C04ComparatorLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeSet<String> tree = new TreeSet<>();	//abc 순서
		TreeSet<String> tree = new TreeSet<>(new StringComparator()); //문자열길이순
		tree.add("Box12");
		tree.add("Rabbit");
		tree.add("Robot");
		
		for(String s : tree) {
			System.out.println(s.toCharArray());
		}
		
		String str = "test";
		str.compareTo(str);
	}

}
