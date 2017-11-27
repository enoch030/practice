package study.map;

/*
 *  [ Map ]
 *  
 *  - Collection을 물려 받은 게 아니라 독립적인 인터페이스
 *    (List, Set, Queue와는 계열이 아예 다름)
 *  - 관리할 객체(value)값만 넘기면 됐던 List, Set, Queue와 달리
 *    Map은 저장할 value에 key 값을 설정해서 넘겨야 함.
 *  - key값으로 객체를 관리함.
 *  - 동일 value 중복 저장 가능.
 *  - key값은 중복 불가능.
 *    
 *  - 대표적인 맵 계열 컬렉션 (key를 set계열로 관리함.)
 *  1) HashMap       - HashSet으로 key 관리
 *  2) LinkedHashMap - LinkedHashSet으로 key 관리
 *  3) TreeMap       - TreeSet으로 key 관리
 *  
 *  - 특수 맵
 *  1) Properties
 *  
 *  - 기본 메소드
 *  1) put(key, value) : 저장할 객체의 이름(key)과 객체값을 인자로 넘기면 저장됨.
 *  					 중복 key값으로 객체를 저장하면 객체가 덮어씌워짐.
 *  2) get(key)        : 해당 key값을 가진 객체를 리턴해 줘!
 *  3) remove(key)     : 지우면서 그 객체값 반환함.
 *  4) containsKey
 *  5) containsValue
 *  6) size
 *  7) isEmpty
 * 
 */

import java.util.*;

public class Source01_Map {
	public static void main(String[] args) {
		
		Map map = new HashMap();
		System.out.println(map.isEmpty());
		// 1) put - key값은 중복 불가. 저장할 객체(value)는 중복 상관 없음.
		map.put("one", 1); // 실제 저장된 객체는 Integer(1), key값(이 객체의 이름)은 "one"
		map.put("하나", 1);
		map.put("one", 11); // key값이 동일해서 값이 덮어씌워졌음.
		System.out.println(map.size());
		
		// 2) get - 없는 객체를 요구하면 null이 뜸. 에러가 터지진 않음.
		Object o = map.get("one");
		System.out.println( (o instanceof Integer)+" / "+o);
		Object oo = map.get("two");
		System.out.println(oo);
		
		// 3) remove - 없는 객체를 요청하면 null이 뜸.
//		System.out.println(map.remove("one")); // 1
		System.out.println(map.remove("two")); // null
		
		// 4) containsKey(key)
		boolean b1 = map.containsKey("one");
		System.out.println(b1);
		
		System.out.println(map.containsValue(1));
		
		System.out.println(map.toString());
		
		
		
		
		
	}
}
