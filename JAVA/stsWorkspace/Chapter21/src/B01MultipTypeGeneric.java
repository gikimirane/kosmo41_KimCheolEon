class DBox<L, R>{
	private L left;
	private R right;
	
	public void set(L l, R r) {
		left = l;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + " & " + right;
	}
}

public class B01MultipTypeGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBox<String, Integer> box = new DBox<String, Integer>();
		
		box.set("Apple", 25);
		
		System.out.println(box);
	}
}
