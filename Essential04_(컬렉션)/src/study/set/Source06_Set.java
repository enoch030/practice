package study.set;

import java.util.*;

public class Source06_Set {
	public static void main(String[] args) {
		
		CarNumber[] cn = new CarNumber[15];
		
		for(int i = 0; i < cn.length; i++) {
			int t = (int)(Math.random()*2)*10+1; // 차종 랜덤 뽑기
			int r = (int)(Math.random()*2);
			char u = "가바".charAt(r); // 차 용도 랜덤 뽑기
			int s = (int)(Math.random()*2)*1000+30; // 차 일련번호 랜덤 뽑기
			cn[i] = new CarNumber(t,u,s);
			System.out.println(i+": "+cn[i].toString());
		}
		
		//================================================================================
		Set<CarNumber> set1 = new TreeSet<>(); // 한 번만 등장한 객체들 모으기.
		Set<CarNumber> set2 = new TreeSet<>(); // 두 번 이상 등장한 객체들 모으기.

		
		
		
		//cn에는 중복을 제외하고 총 몇 대의 차량이??
		
		for(int i = 0; i < cn.length; i++) {
			boolean b = set1.add(cn[i]);
			if(b != true)
				set2.add(cn[i]);
		}
		System.out.println("총 "+set1.size()+" 대");
		
		set2.retainAll(set1);
		set1.removeAll(set2);

		
		// type => use => serial 순 정렬
		System.out.println(set1.toString());
		System.out.println(set2.toString());
		
		
		
		
		
	}
}
