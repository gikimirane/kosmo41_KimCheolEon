import java.util.*;

public class D02LinkedlistDeque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//이 문장도 사용 가능
//		Deque<String> deq = new ArrayDeque<>(); 
		Deque<String> deq = new LinkedList<>();
		
		// 정방향 offer
		deq.offerFirst("f1_Box");
		deq.offerFirst("f2_Toy");
		deq.offerFirst("f3_Robot");
		
		//정방향 poll
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println();
		
		//역방향 offer
		deq.offerLast("l1_Box");
		deq.offerLast("l2_Toy");
		deq.offerLast("l3_Robot");
		
		//역방향 poll
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		
		System.out.println();
		
		//뒤로 넣고
		deq.offerLast("l1_Box");
		deq.offerLast("l2_Toy");
		deq.offerLast("l3_Robot");
		
		//앞에서 꺼내기 - 일반 queue
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
	}

}
