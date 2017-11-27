package study.collection;

import java.util.*;

/*
 *  [ 컬렉션 ] (=컨테이너)
 *  
 *   -데이터 관리용 객체(인터페이스) (저장, 검색, 조작 등)
 *   -수십여가지의 class가 있으나, 크게 두 분류로 나뉨.
 *   
 *   1) Collection 계열
 *   	-Set / List / Queue
 *   2) Map 계열
 *   
 */
@SuppressWarnings("unused")

public class Source01_collection {
	public static void main (String[] args) {
		Collection[] c = new Collection[] { new TreeSet(), new Vector(), new PriorityQueue(),
											new ArrayList(), new Stack(), new LinkedHashSet() };
		Map[] m = new Map[] { new Hashtable(), new Properties(), new HashMap() }; // Vector() 생성 불가! 계열이 다름!
		
		for(int i = 0; i < c.length; i++) {
			boolean b1 = c[i] instanceof Set;
			boolean b2 = c[i] instanceof List;
			boolean b3 = c[i] instanceof Queue;
			System.out.println(i+": "+b1+" / "+b2+" / "+b3);
		}
		
		
		
		
		
		
		
		
	}
}
