package study.collection;

import java.util.*;

/*
 * [ set ]
 * 
 *  -가장 많이 쓰이는 객체 : HashSet()
 *  -중복 저장 X
 *  
 */

public class Source03_Collection {
	public static void main(String[] args) {
		Collection c = new HashSet(); // set 계열에서 가장 많이 쓰이는 객체.

		System.out.println(c.isEmpty());
		c.add("자바");
		c.add(4); // Auto-Boxing ==> Integer로 Auto wrapping.

		StringBuilder sb = new StringBuilder("HANGMAN");
		c.add(sb);
		boolean z = c.add(sb);
		System.out.println(z);
		System.out.println(c.size());

		Iterator it = c.iterator();
		
//		(1)번 방법-----------------------------------------------------------
//		for (int cnt = 1; cnt <= c.size(); cnt++) {
//			boolean b = it.hasNext(); // 접근할 수 있는 객체가 있니?
//			System.out.println("hasNext()? " + b);
//			Object o = it.next(); // 객체값 리턴 + 다음 객체로 커서 이동.
//			System.out.println(o.getClass().getName());
//		}
		
		while(it.hasNext()) {
			Object o = it.next(); // 객체를 지워버리는 것이 아니라 값만 리턴.
			System.out.println(o.getClass().getSimpleName());
			if(o instanceof StringBuilder) {
				((StringBuilder) o).append("--");
			}
		}
		System.out.println(sb.toString());

	}
}
