package com.study.pattern03.strategy2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//게임 캐릭터 생성
		GameCharacter ch = new GameCharacter();
		ch.fire();
		
		//선택상황에 따라 전략적으로 무기를 선택한다. (사용자 주관)
		ch.setWeapon(new Arrow());
		ch.fire();
		
		ch.setWeapon(new Bullet());
		ch.fire();
		
		//유지보수사항 - 무기 : 미사일추가
		// Missile.java 추가
		// fire
		ch.setWeapon(new Missile());
		ch.fire();
		
		//fire, 라는 동일 알고리즘 - 선택적용(Arrow, Bullet)
		//전력패턴은 여기서 골라서 쓰는것
		// 일단 내부동작은 별도로 있겠지만
		//"동작" 의 기능에 한해서는 이렇게 계속 선택적으로 늘려갈 수 있음
	}
}
