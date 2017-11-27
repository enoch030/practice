package study.set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Bomb implements Comparable<Bomb> {
	double power; // 폭탄 데미지
	int radius;  // 폭탄 반경
	
	Bomb(double power, int radius) {
		this.power = power;
		this.radius = radius;
	}
	
	@Override
	public int hashCode() { // 같은 데이터 가졌으면 같은 hashCode를 갖도록 구현
//		System.out.println("hashCode called...");
		return (int)((radius * 31) + (power * 100));
	}
	
	@Override
	public boolean equals(Object obj) { 
//		System.out.println("equals called...");
//		super.equals(obj); // ==> this == obj만 판단함.
		if(obj == this) {
			return true;
		}
		if(obj instanceof Bomb) {
			Bomb bomb = (Bomb)obj;
			return this.power == bomb.power && this.radius == bomb.radius;
		}
		return false;
	}
	
	@Override
	public int compareTo(Bomb o) {
		//this 객체와 o 객체 비교결과 자신이 작으면 -1, 같으면 0, 자신이 크면 1 return
		if(radius == o.radius && power == o.power)
			return 0;
		else {
			if(power == o.power)
				return radius - o.radius;
			else
				return (int)(power - o.power);
		}
	}

	@Override
	public String toString() {
		return "power=" + power + ", radius=" + radius;
	}
	
	
	
	
	
}

public class Source03_Set {
	public static void main(String[] args) {
		Bomb[] bombs = new Bomb[] {
				new Bomb(100.0, 3), new Bomb(90.0, 4), new Bomb(100.0, 3), new Bomb(90.0, 3),
		};
		
		Set<Bomb> set = new LinkedHashSet<>();
//		System.out.println(bombs[0].equals(bombs[1])); //false. equals를 오버라이드 해야 함. 
		
		Bomb b = bombs[0];
		for(int i = 0; i < bombs.length; i++) {
			set.add(bombs[i]); // 3개가 아니라 4개라고 나옴... 중복 처리 왜 안 함!!!!○ㅁ○!!!!!
			 				   //                              은 오버라이드 안 해서 그럼.
			System.out.println(bombs[i].hashCode());
			System.out.println(b.equals(bombs[i]));
		}
		System.out.println(set.size());
		
		
	}
}
