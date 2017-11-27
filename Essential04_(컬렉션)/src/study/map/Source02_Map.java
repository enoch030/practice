package study.map;

import java.util.*;

public class Source02_Map {
	public static void main(String[] args) {
//		//Map Generic은 <key Generic, Value Generic>을 모두 설정해야 함.
//		Map<String, Integer> si = new LinkedHashMap<>();
//		// key값이 Set으로 관리되기 때문에 중복 여부 판단이 가능한 기본 객체로 key type을 정함.
//		// (주로 String)
//		si.put("if", 3);
//		Integer i = si.get("if");
//		
//		Map<Integer,String> is = new LinkedHashMap<>();
//		is.put(1, "one");
//		String s = is.get(1);
		
//		=======================================================
		// Map을 이용해 알파벳별 등장 회수 체크
		
		String data = "applemango";
		Map<Character, Integer> counter = new TreeMap<>();
		
		for(int idx = 0; idx < data.length(); idx++ ) {
			char temp = data.charAt(idx);
			if( !counter.containsKey(temp) ) { // 없는 key값이니?
				counter.put(temp, 1);
			} else { // 있는 key값이야!
				Integer value = counter.get(temp);
				counter.put(temp, Integer.valueOf(value.intValue()+1));
			}
		}
		
		System.out.println(counter.toString()); // key값으로 정렬 (= key값을 TreeSet으로 정리)

//		=========================================================
		Map<Character, Integer> sum = new HashMap<>();
		sum.put('z', 30);
		sum.put('p', 10);
		sum.putAll(counter); // putAll해도 중복 key값의 value는 덮어씌워짐.
		System.out.println(sum.toString());
		sum.clear();
		System.out.println();
		
		
		
		
		
		
		
		
		
	}
}
