package study.collection;

import java.util.*;

/*
 *  Collection의 공통 목적 : 객체 관리
 *               공통 특징 : 컬렉션에 갖고 있지 않은 객체는 다 저장 함. (계열에 따라 중복 저장 여부가 달라짐.)
 *	
 *	<basic operation>
 *	
 *	 -int size() : 관리 중인 객체 개수
 *   -boolean isEmpty() : size가 0이면 true
 *   -boolean contains(Object) : 특정 객체를 가지고 있는지
 *   -boolean add(Object) : 객체 저장 후 성공 여부 반환
 *   -boolean remove(Object) : 특정 객체 삭제 성공 여부 반환
 *   -Iterator iterator() (객체 값 뽑아 쓸 수 있게끔 커서 역할을 해주는 녀석) : 탐색 객체 반환
 * 
 */

public class Source02_Collection {
	public static void main(String[] args) {

		Collection[] collections = new Collection[] { new Vector(), new LinkedList(), new PriorityQueue(),
				new ArrayList(), new Stack(), new LinkedHashSet() };

		Collection c = collections[(int) (Math.random() * collections.length)];

		String name = c.getClass().getName(); // 당첨된 콜렉션의 클래스명이 추출됨.
		System.out.println(name);
		String type = "";

		if (c instanceof Set)
			type += "Set ";
		if (c instanceof List)
			type += "List ";
		if (c instanceof Queue)
			type += "Queue";

		System.out.println(type + "계열 입니다.");

		// ==========================================================================

		int[] ar = new int[] { 1, 2, 3, 4 };
		String str = "java";
		c.add(str);

		if (Math.random() > 0.5) {
			for (int cnt = 1; cnt <= 3; cnt++) {
				boolean ca = c.add(ar); // 컬렉션 타입에 따라 객체 저장이 실패할 수도.
				System.out.println("ADD event : " + ca);
			}
		}

		System.out.println(c.contains(ar));

		System.out.println(c.size() + " / isEmpty? " + c.isEmpty());

		boolean z = c.remove(ar);
		System.out.println("remove = " + z);

		Iterator it = c.iterator();

	}
}
