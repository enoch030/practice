package study.map;
/*
 *  특정한 key 하나에 여러 value를 관리하고 싶다면?
 * 
 * 
 */

import java.util.*;

public class Source05_MultiMap {
	public static void main(String[] args) {

		// key - Integer , 거기에 해당하는 word를 List로 처리하는 MultiMap 관리.
		
		Map<Integer,List<String>> nums = new TreeMap<>();
		
		if(nums.get(1) == null) {
			nums.put(1, new ArrayList<String>());
		}
		nums.get(1).add("하나");
		nums.get(1).add("one");
		nums.get(1).add("一");
		
		
		
		
		
	}
}
