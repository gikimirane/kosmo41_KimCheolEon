import java.util.*;

//매개변수가 있고 반환하지 않는 람다식
//만약, 리턴이 있으면 함부로 중괄호 못줄임.

interface Printable{
	void print(String s); //매개변수 하나, 반환형 void
}

public class A02OneParamNoReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Printable p;
		
		//줄임없는 표현
		p = (String s) -> { System.out.println(s); };
		p.print("Lambda exp one.");
		
		//중괄호 생략
		p = (String s) -> System.out.println(s);
		p.print("Lambda exp two.");
		
		//매개변수 형 생략
		p = (s) -> System.out.println(s);
		p.print("Lambda exp three.");
		
		//매개변수 소괄호 생략
		p = s -> System.out.println(s);
		p.print("Lambda exp four.");

	}

}

/*
	메서드 몸체가 둘 이상의 문장으로 이뤄져있거나,
	매개변수의 수가 둘 이상인 경우에는 각각
	중괄호와 소괄호의 생략이 불가능하다
*/
