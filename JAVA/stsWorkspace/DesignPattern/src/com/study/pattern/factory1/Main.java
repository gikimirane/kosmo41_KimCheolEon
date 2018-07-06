/*
 * SimpleFactory Pattern
 */

package com.study.pattern.factory1;

//FactoryUse
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//구체적 생성방법 몰라도 됨.
		// 타입지정만 하면 됨
		Unit unit1 = UnitFactory.createUnit(UnitType.Marine);
		Unit unit2 = UnitFactory.createUnit(UnitType.Firebat);
		Unit unit3 = UnitFactory.createUnit(UnitType.Medic);
		
		unit1.move();
		unit2.move();
		unit3.move();
	}

}
