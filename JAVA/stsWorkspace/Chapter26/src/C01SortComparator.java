import java.util.*;

////////////////////////////////////////////////////
class StrComp implements Comparator<String>{
	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}
////////////////////////////////////////////////////

public class C01SortComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");
		
		/////////////////////////////////////////
		StrComp cmp = new StrComp();
		/////////////////////////////////////////
		
		Collections.sort(list, cmp);
		System.out.println(list);
	}
}
