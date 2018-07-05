import java.util.*;

public class A04CopyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Immutable List
		List<String> src = Arrays.asList("Box", "Apple", "Toy", "Robot");
		System.out.println(src);
		
		//복사본 생성
		List<String> datas = new ArrayList<>(src);
		
		//정렬 및 출력
		Collections.sort(datas);
		System.out.println(datas);
		
		//정렬 이전상태로 덮어씌우기
		Collections.copy(datas, src);
		
		//출력
		System.out.println(datas);

	}

}
