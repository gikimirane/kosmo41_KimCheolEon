import java.util.*;

// list -> Hash -> list
// 중복 인스턴스 삭제하고 돌아오기
// 심지어 영문 정렬까지 됨. (사실 정렬만 바랄 경우에는 .sort 하면 됨)

public class C05ConvertCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("Box", "Toy", "Box", "Toy");
		ArrayList<String> arrlist = new ArrayList<>(list);
		
		for(String s : arrlist) {
			System.out.print(s.toString() + "\t");
		}
		System.out.println();
		
		// 중복인스턴스를 걸러보자 -> 중복을 허용않는 Hash로 전환
		HashSet<String> set = new HashSet<>(arrlist);
		
		// 원래대로 복귀
		arrlist = new ArrayList<>(set);
		
		for(String s : arrlist) {
			System.out.print(s.toString() + "\t");
		}
		System.out.println();
	}
}
