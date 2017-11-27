package study.collection;

import java.util.*;
/*
 *  [ Collection Bulk Operation ]
 *      (컬렉션 전체 작업)
 *  
 *  - 컬렉션 간 변환 가능.
 *  
 *  1) boolean containsAll(Collection c)
 *    : c가 가진 객체를 모두 가지고 있니?
 * 
 *  2) boolean addAll(Collection c)
 *    : c가 가진 객체를 모두 저장해라. (하나라도 저장하면 true, 하나도 저장 안 되면 false)
 *      (List/Queue 계열은 중복 저장 ok, 늘 true일 거임! Set은 false 일 가능성이 있음. 중복 불가이므로)
 * 
 *  3) boolean removeAll(Collection c)
 *    : c가 가진 객체를 모두 지워라. (하나라도 지우면 true)
 *  
 *  4) boolean retainAll(Collection c) 
 *    : c와 중복된 내용만 남기고 지워라. (교집합만 남김)
 *    
 *  5) void clear()
 *    : 컬렉션 초기화.
 * 
 *  6) Object[] toArray()
 *    : 컬렉션이 가진 객체를 Object형 배열에 담아 줌.
 *    
 */
public class Source04_Collection {
	public static void main(String[] args) {
		
		Collection c1 = new Vector();
		c1.add("유비");
		c1.add("조조");
		c1.add("손책");
		c1.add("주유");
		c1.add("제갈량");
		
		Collection c2 = new HashSet(c1);
		Collection c3 = new PriorityQueue(c2);
		
		System.out.println(c2.toString()); // 컬렉션의 toString : 갖고 있는 객체들의 toString 일괄 출력
		
		Collection p = new Stack();
		p.add("사마의");
		p.add("유비");
		
		// boolean containsAll(Collection) / boolean addAll(Collection) / boolean removeAll(Collection)
		// boolean retainAll(Collection) / void clear()
		
//		1)
		boolean b1 = c2.containsAll(p);  
		System.out.println(b1); // false 
		System.out.println(c2.toString());
//		2)
		boolean b2 = c2.addAll(p);
		System.out.println(b2);
		System.out.println(c2.toString());
//		3)
//		boolean b3 = c2.removeAll(p);
//		System.out.println(b3);
//		System.out.println(c2.toString());
		
//		4)
		boolean b4 = c2.retainAll(p);
		System.out.println(b4);
		System.out.println(c2.toString());
		
//		6)
		Object[] arr = c2.toArray();
		System.out.println(arr.length);
		
		
		
	}
}
