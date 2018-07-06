import java.util.*;

public class Ch23QuizCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> kyo = new ArrayList<>();
		List<Integer> cha = new ArrayList<>();
		List<Integer> hap = new ArrayList<>();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		// 교집합 차집합 합집합을 구하시오
		//교집합
		kyo.addAll(list1);
		kyo.retainAll(list2); //list2 의 내용만을 보관한다
		
		//차집합
//		cha.addAll(list1);
//		cha.removeAll(list2); //list2 의 내용을 삭제한다.
		cha.addAll(list2);
		cha.removeAll(list1);

		// 심지어 이것도 잘못풀음;;
//		hap.addAll(list1);
//		hap.addAll(list2);
//		hap.removeAll(kyo);
		
		hap.addAll(list1);
		hap.removeAll(list2);
		hap.addAll(list2);
		
//		hap.addAll(list1);
//		hap.addAll(list2);		
//		HashSet<Integer> set = new HashSet<>(hap);
//		hap = new ArrayList<>(set);
		// ---------------------------------

		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
		System.out.println("kyo = " + kyo);
		System.out.println("cha = " + cha);
		System.out.println("hap = " + hap);

	}

}
