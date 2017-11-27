package study.list;

/*
 * [ List ]
 * 
 *  -순서(index)가 있는 컬렉션.
 *  -중복 객체 저장 O
 *  -포지션을 통한 접근 가능 (배열처럼. get(index), remove(index)
 *  -특정 객체의 위치 search가 가능. (indexOf, lastIndexOf)
 *  -전용 Iterator가 추가적으로 존재함. (listIterator)
 *  -RangeView 가능.(일부를 추출해 컬렉션을 만들어 낼 수 있음) (subList)
 *  
 *  -자주 쓰이는 List 계열 컬렉션
 *  
 *  1) Vector     : (배열 기반) ArrayList의 구버전. (동기화 처리 : 무거움) 그렇게 많이 쓰이지 않음.
 *  2) ArrayList  : (배열 기반) 보통의 경우 가장 성능 좋음. (동기화 처리X) (전천후)
 *  3) LinkedList : 객체간 연결하여 *배열처럼* 작동하게 함. 특정 상황에서 성능이 좋음. (동기화 처리X)
 *                  1번 객체가 2번의 객체값을 알고, 2번은 1, 3번의 객체(주소)값을 알고...
 *                  중간 삽입 / 삭제 등의 변화가 많은 작업이라면 LinkedList가 최적!
 *  ?) 동기화(Synchronized) : 멀티쓰레드 상황에서만 볼 수 있음.
 *  
 *  
 */

import java.util.*;

public class Source01_List {
	public static void main(String[] args ) {
		List<String> lia = new Vector<>();
		List<String> lib = new ArrayList<>();
		List<String> lic = new LinkedList<>();
		
		lib.add("조조");
		lib.add("조조");
		System.out.println(lib.size());
		boolean b = lib.contains("조조");
		System.out.println(b);
		System.out.println(lib.toString());

// [index 접근]-----------------------------------------------------------------------
		
		// 1) add(int idx, E e) - 삽입
		lib.add(1, "사마의");
		System.out.println(lib.toString());
		
		// 2) set(int idx, E e) - 바꿔치기
		lib.set(2, "하후돈");
		System.out.println(lib.toString());
		
		// 3) remove(int idx)
		lib.remove(0);
		System.out.println(lib.toString());
		
		// 4) E get(int idx)
		String s = lib.get(1);
		System.out.println(s);
		
		// 5) addAll(int idx, Collection c) - 특정 위치에 컬렉션 몽땅 삽입
		
		lic.add("여뭉");
		lic.add("주유");
		lic.add("육손");
		lib.addAll(1, lic);
		System.out.println(lib.toString());
		
		// 6) indexOf(E e) - 없으면 -1, 있으면 해당 위치
		int i = lib.indexOf("관우");
		System.out.println(i);
		i = lib.indexOf("주유");
		System.out.println(i);
		
		// 데이터 중복 저장이 가능하기 때문에 indexOf / lastIndexOf의 값이 다를 수 있음.
		
		// 7) subList(fromIdx, toIdx) - fromIdx <=   < toIdx (원본은 노터치!)
		List<String> slist = lib.subList(1, 4);
		System.out.println(slist.toString());
		System.out.println(lib.toString());
		
//		lib.removeAll(slist); // 겹치는 객체들을 지워줘!
//		
//		System.out.println(lib.toString());
		
		int n = (int)(Math.random()*lib.size());
		int m = (int)(Math.random()*lib.size());
		System.out.println(n +" ↔ "+m);
		
		String temp = lib.get(m);
		lib.set(m, lib.get(n));
		lib.set(n, temp);
		
		System.out.println(lib.toString());
		
		
		
	}
}
