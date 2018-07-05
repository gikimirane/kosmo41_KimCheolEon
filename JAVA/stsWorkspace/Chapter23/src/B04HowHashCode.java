import java.util.*;

class Car{
	private String model;
	private String color;
	
	public Car(String m, String c) {
		model = m;
		color = c;
	}
	
	@Override
	public String toString() {
		return model + " : " + color;
	}
	
	@Override
	public int hashCode() {
		return (model.hashCode() + color.hashCode()) / 2;
		//모든 인스턴스 변수의 정보를 다 반영하여 해쉬값을 얻으려는 노력?
		//세밀하게 나눠진 만큼 탐색 속도가 높아진다?
	}
	
//	@Override
//	public int hashCode() {
//		return java.util.Objects.hash(model, color);
//	}
	//해쉬 알고리즘 일일이 정의하기 힘들면, 전달된 인자 모두 반영한 해쉬값 반환
	
	public boolean equals(Object obj) {
		String m = ((Car)obj).model;
		String c = ((Car)obj).color;
		
		if(model.equals(m) && color.equals(c)) {
			return true;
		}
		else {
			return false;
		}
	}
}

public class B04HowHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Car> set = new HashSet<>();
		
		set.add(new Car("HY_MD_301", "RED"));
		set.add(new Car("HY_MD_301", "BLACK"));
		set.add(new Car("HY_MD_302", "RED"));
		set.add(new Car("HY_MD_302", "WHITE"));
		set.add(new Car("HY_MD_301", "RED"));
		
		System.out.println("인스턴스 수 : " + set.size());
		
		for(Car car : set){
			System.out.println(car.toString());
		}
		
		

	}

}
