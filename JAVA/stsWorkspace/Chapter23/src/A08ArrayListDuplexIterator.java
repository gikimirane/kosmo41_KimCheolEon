import java.util.*;

public class A08ArrayListDuplexIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "BBGun");
		list = new ArrayList<>(list);
		
		ListIterator<String> litr = list.listIterator();
		String str;
		
		//정방향
		while(litr.hasNext()) { //다음 있냐? - true / false
			str = litr.next(); // 있으면 버퍼 저장
			System.out.print(str + "\t");
			
			if(str.equals("Toy")) { //정방향에서 Toy 발견시 add
				litr.add("neAdd2");//list 에 add 하면 끝에 가는데, 
									//iterator 에 add 해서 읽고 add
			}
		}
		System.out.println();
		System.out.println();
		
		//역방향
		while(litr.hasPrevious()) {
			str = litr.previous();
			System.out.print(str + "\t");
			
			if(str.equals("Robot")) {
				litr.add("prAdd2");
			} // 어? 이게 왜 prAdd2 까지 나올까
			// 뒤앞 뒤앞 뒤앞
			// 거꾸로 간다고 해서  앞뒤 앞뒤 앞뒤 가 아님;;
		}
		System.out.println();
		System.out.println();
		
		//정방향 출력
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
			System.out.print(itr.next() + "\t");
		}
		
	}

}
