package study.set;

import java.util.*;

public class Source02_Set {
	public static void main(String[] args) {
		// 실제로는 다른 객체지만 같다고 판단하는 이유
		
		Integer i = new Integer(44);
		Integer ii = new Integer(44);
		System.out.println(i == ii); // false. 다른 객체임.
		
		Set<Integer> set = new HashSet<>();
		set.add(i);
		set.add(ii);
		System.out.println(set.size());
		
		// HashSet, LinkedHashSet 같은 경우
		
		boolean b = i.equals(ii);
		System.out.println(b); // intValue해서 값 비교 진행. true일 경우,
		boolean bb = (i.hashCode() == ii.hashCode()); // 두 객체의 hashCode도 같으면 같은 객체라고 판단.
		// (hashCode() : 자기 value를 return하도록 오버라이드 되어 있음.)
		// String의 경우에도 hashCode 오버라이드 되어 있음. 같은 문자면 hashcode가 같다고 나옴.
		System.out.println(bb); //true
		
		
//[TreeSet의 경우]=======================================================
		
		Set<Integer> set2 = new TreeSet<>();
		set2.add(i);
		set2.add(ii);
		System.out.println(set2.size());
		int t = i.compareTo(ii); // compareTo한 결과가 0이면 같은 객체로 판단.
		System.out.println(t);
		
		
		
		
	}
}
