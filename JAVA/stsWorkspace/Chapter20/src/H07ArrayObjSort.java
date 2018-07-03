/*Exception in thread "main" java.lang.ClassCastException: Person1 cannot be cast to java.lang.Comparable
	at java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
	at java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
	at java.util.Arrays.sort(Arrays.java:1246)
	at H07ArrayObjSort.main(H07ArrayObjSort.java:64)*/

// Comparable 을 타고 간다.


import java.util.Arrays;

class Person1 implements Comparable{
	private String name;
	private int age;
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
//	Comparable.class 에 있음 -> public int compareTo(T o);
	@Override
	public int compareTo(Object o) {
		Person1 p = (Person1)o;
		
		//나이순 오름차순 정렬
//		if(this.age > p.age) {
//			return 1;
//		}
//		else if(this.age < p.age) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
		
		return this.age - p.age;
		
		
		//이름순 오름차순 정렬
//		if(this.name.compareTo(p.name) > 0 ) {
//			return 1;
//		}
//		else if(this.name.compareTo(p.name) < 0) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
		
//		int nNum = this.name.compareTo(p.name);
//		return nNum;
	}
	
	@Override
	public String toString() {
		return name + ": " + age;
	}
}

public class H07ArrayObjSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person1[] ar = new Person1[5];
		
		ar[0] = new Person1("Goo", 29);
		ar[1] = new Person1("Soo", 15);
		ar[2] = new Person1("Lee", 37);
		ar[3] = new Person1("Zee", 21);
		ar[4] = new Person1("Qee", 5);
		
		Arrays.sort(ar);
		
		for(Person1 p : ar) {
			System.out.println(p);
		}

	}

}
