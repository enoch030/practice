package study.map;

/*
 * [ Collection View ]
 * 
 *  1) Set keySet()        - key값만 모아서 Set으로 만들어줌. 
 *                           (set이 싫으면 Collection도 상관 없음. 더 상위니까)
 *                           
 *  2) Collection values() - value만 모아서 컬렉션으로 반환해 줌. 
 *                           value는 중복값이 존재할 수 있으므로 Set계열은 아닐 것.
 *                           
 *  3) Set entrySet()      - key와 value를 한 쌍으로 묶은 객체(Entry-interface)를 Set으로 반환해 줌.
 * 	   (Map과 collection은 계열이 아예 다르지만, entrySet을 통해 Map을 Collection화 해준다고 생각해도 무방.
 *      Map은 value로 key에 접근할 방법이 없으므로 entrySet을 활용해야 함.)
 * 
 */


import java.util.*;
import java.util.Map.Entry;

public class Source03_Map {
	public static void main(String[] args) {

		Map<Character, Integer> counter = new TreeMap<>();
		String data = "applemango";
		for (int idx = 0; idx < data.length(); idx++) {
			char temp = data.charAt(idx);
			if (!counter.containsKey(temp)) { // 없는 key값이니?
				counter.put(temp, 1);
			} else { // 있는 key값이야!
				Integer value = counter.get(temp);
				counter.put(temp, Integer.valueOf(value.intValue() + 1));
			}
		}
		System.out.println(counter.toString());
		Integer i = counter.get('y');
		System.out.println(i);
		
// [Collection View] ---------------------------------------------------------------------------
		
		// 1) Set keySet()
		Set<Character> keys = counter.keySet(); // key type이 Character기 때문에 Set<Character>
		System.out.println(keys.toString());
		
		// 2) Collection values()
		Collection<Integer> values = counter.values();
		System.out.println(values.getClass().getSimpleName());
		System.out.println(values);
		
		// 3) Set entrySet()
		Set<Entry<Character, Integer>> entry = counter.entrySet();
		
		
		for ( Entry<Character, Integer> e : entry) {
			System.out.println("→"+e.toString());
			System.out.println(e.getKey()+" → "+e.getValue());
		}
		
		System.out.println(entry.toString());
		
		
		
		
		
		
		
		
		
		
		
	}
}
