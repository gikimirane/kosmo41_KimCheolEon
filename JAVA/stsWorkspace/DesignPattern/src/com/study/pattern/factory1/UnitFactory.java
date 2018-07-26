package com.study.pattern.factory1;

enum UnitType {
	Marine, Firebat, Medic
}

public class UnitFactory {
	// createUnit Ctrl + space, public change
	// main new 사용하기 싫어서 static 추가
	public static Unit createUnit(UnitType type) {

		Unit unit = null;

		switch (type) {
		
		//구체적 생성방법을 지정하여 생성
		// 생성시 파라미터가 있다면 생성자에 추가할 수도 있다.
		case Marine:
			// 자식을 부모에게 대입 가능
			unit = new Marine();
			break;
		case Firebat:
			unit = new Firebat();
			break;
		case Medic:
			unit = new Medic();
			break;
//		default:
//			break;
			
		}

		return unit;
	}

}
