package study.set;

/*
 * [TreeSet]
 * 
 * -hashCode(), equals()가 아닌, compareTo()한 결과를 토대로 객체 저장.
 * -compareTo() 가 0이면 동일 객체로 판단. 저장 X
 *  (compareTo는 Comparable 인터페이스로 구현해야 함)
 * 
 */

import java.util.*;

public class Source05_Set {
	public static void main(String[] args) {
		Set<Bomb> set = new TreeSet<>();

		Bomb[] bombs = new Bomb[] {
				new Bomb(100.0, 3), new Bomb(90.0, 4), new Bomb(100.0, 3), new Bomb(90.0, 3),
		};
		
		System.out.println(bombs[0] instanceof Comparable); //true (= 해당 객체가 Comparable 계열이다)
		
		for(int i = 0; i < bombs.length; i++) {
			set.add(bombs[i]);
		}
		System.out.println(set.size());
		System.out.println(set.toString());
	}
}
