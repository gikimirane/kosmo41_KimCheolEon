import java.util.*;

public class D01LinkedlistQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<String> que = new LinkedList<>();
		
		System.out.println(que.offer("t")); // 제대로 들어가면 true 반환이로군
		
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		System.out.println(que.size()); //queue 의 사이즈는 줄어들음
		
		//무엇이 나올지 확인
		System.out.println("next : " + que.peek());
		
		System.out.println(que.poll());
		System.out.println(que.poll());
		
		System.out.println("next : " + que.peek());
		
		System.out.println(que.poll());
		System.out.println(que.poll());
		System.out.println(que.poll()); //꺼낼 대상이 없으면 null 반환
		System.out.println("next : " + que.peek()); // 확인 대상 없으면 null 반환
		
		System.out.println(que.size());
	}
}
