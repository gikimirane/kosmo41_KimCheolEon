//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Consumer;
import java.util.*;
import java.util.function.*;

//staic 메소드의 참조 : 람다식 기반 예제
//collections 클래스의 reverse 메소드 기반 예제 + Consumer<T> , void accecpt(T t)
// Chapter28 생략

public class A01ArrangeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//불변상태
		List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
		//변할수 있게 new 해서 고침
		ls = new ArrayList(ls);
		
		//reverse 메소드 호출 중심의 람다식?
		Consumer<List<Integer>> c = l -> Collections.reverse(l);
		c.accept(ls); // 순서 뒤집기 진행?
		System.out.println(ls);

	}

}
