// 코스1. hashCode 오버라이딩을 통한 분류 규칙
// 코스2. equals 오버라이딩을 통한 인스턴스 중복의 기준 정의
//(내부 equal, 인스턴스equal)

import java.util.*;

class Num{
	private int num;
	public Num(int n) {
		num = n;
	}
	
	@Override
	public String toString() {
		return String.valueOf(num);
	}
	
	@Override
	public int hashCode() {
		return num % 3; // num 값이 같으면 부류도 같다. 사용자 정의 분류
	}
	
//	 이게 있으면 내용을 비교할 수 있어서 중복의 기준 재정의 가능
//	@Override
//	public boolean equals(Object obj) {
//		if(num == ((Num)obj).num) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
}


public class B0203HashSetEquality {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Num> set = new HashSet<>();
		
		// add 할때 true여야 add가 됨
		set.add(new Num(10));
		set.add(new Num(10));
		set.add(new Num(30));
		
		System.out.println("인스턴스 수: " + set.size());
		
		for(Num n : set) {
			System.out.print(n.toString() + "\t");
		}
		System.out.println();
	}
}
