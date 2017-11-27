package study.collection;

import java.util.*;
import java.util.stream.Stream;

/*
 *  [ Traversing Collection ]
 *  (객체 접근 / 컬렉션 순회)
 *  
 *  1) toArray() 이용
 *  
 *  2) iterator() 이용
 *  
 *  3) for-each 이용
 *  
 *  4) Stream stream() 이용 (jdk 1.8이상에서만 작동)
 *     stream().forEach (o -> System.out.println(o));
 *           (컬렉션에서 뽑은 걸 o에 저장 -> 세팅 후 할 작업 코드(함수 한 개))
 *     => 복잡한 작업은 힘듦. 그냥 순회만.
 *     
 */


public class Source05_Collection {
	public static void main(String[] args) {
		
		Collection c = new LinkedHashSet();
		c.add("밀짚모자_루피");
		c.add("혁명군_사보");
		c.add("흰수염_에이스");
		c.add("혁명군_드래곤");
		c.add("해군_거프");
		
		
//		3)
		for(Object o : c) {  // while(it.hasNext())  Object o = it.next();
			System.out.println(o);
			if(o instanceof String) {
				boolean b = ((String)o).startsWith("혁명군");
				System.out.println(b);
			}
		}
		
		System.out.println("=================================");
//		4)
		Stream s = c.stream();
//		s.forEach(o -> System.out.println(o));
		c.stream().forEach(o -> System.out.println(o));
		
		
		
		
		
		
	}
}
