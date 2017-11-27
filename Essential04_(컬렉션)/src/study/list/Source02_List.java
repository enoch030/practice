package study.list;

import java.util.*;

public class Source02_List {
	public static void main(String[] args) {
		
		List<Integer> li = new Vector<>();
		// 1.0 ~ 1.2(ArrayList등장시점) 이전에 설계된 클래스의 경우
		// 인자로 Vector를 요구하는 class들이 있음.
		
		for(int num = 10; num <= 100; num+=10) {
			li.add(num);
		}
		System.out.println(li.toString());
		
		ListIterator<Integer> it = li.listIterator();
		System.out.println(it.nextIndex() +"..."+it.previousIndex());
		
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
		}
		System.out.println(it.hasNext()+" / "+it.hasPrevious());
		
		// ListIterator : 거꾸로도 접근 할 수 있음. (hasPrevious() / previous())
		while(it.hasPrevious()) {
			Integer i = it.previous();
			System.out.println(i);
		}
		
		// 하지만 List에서는 Iterator 아니라도 for문으로도 가능.
		for(int idx = 0; idx < li.size(); idx++) {
			Integer s = li.get(idx);
			System.out.println(s);
		}
		Integer iz = new Integer(30);
		int z = li.indexOf(iz);
		System.out.println(z); // List 계열도 Set계열처럼 hashCode()/equals()같으면 동일 객체로 판단.
		
		
	}
}
