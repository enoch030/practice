package study.map;

import java.util.*;
import java.util.Map.Entry;

public class Source04_Map {
	public static void main (String[] args) {
		
		String[] arr = "FIRE,WATER,WIND,EARTH".split(",");
		Map<String, int[]> map = new LinkedHashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			int rand = (int)(Math.random()*3)+2;
			map.put(arr[i], new int[rand]);
		}
		
		System.out.println(map.toString());
		
		// 3칸 이상의 배열이 설정된 key값만 출력.
		
		System.out.println("\nEntrySet 활용==============================\n");
		
		Set< Entry<String, int[]>> entry = map.entrySet();
		
		for( Entry<String, int[]> e : entry) {
			if (e.getValue().length >= 4) {
				System.out.println(e.getKey());
			}
		}
		
		System.out.println("\nKeySet 활용==============================\n");
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator(); 
		
		while(it.hasNext()) {
			String temp = it.next();
			if (map.get(temp).length >= 4)
				System.out.println(temp);
		}
		
		
		
		
	}
}
