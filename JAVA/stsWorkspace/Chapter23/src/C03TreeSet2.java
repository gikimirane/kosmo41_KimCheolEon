import java.util.*;

class Person2 implements Comparable<Person2>{
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
	
	@Override
	public int compareTo(Person2 p) {
		//나이가 동일한 데이터는 추가되지 않는다.
		return this.age - p.age;
	}
}

// 위의 조건을 건드리지 않고, 새로 별도의 비교조건을 걸어서 시행
class PersonComparator implements Comparator<Person2>{
	public int compare(Person2 p1, Person2 p2) {
		return p2.age - p1.age;
	}
}

public class C03TreeSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeSet<Person2> tree = new TreeSet<>();
		TreeSet<Person2> tree = new TreeSet<>(new PersonComparator());
		
		tree.add(new Person2("YOON", 37));
		tree.add(new Person2("HONG", 53));
		tree.add(new Person2("PARK", 22));
		tree.add(new Person2("Test", 22));
		
		for(Person2 p : tree) {
			System.out.println(p);
		}

	}

}
