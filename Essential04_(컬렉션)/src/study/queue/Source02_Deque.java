package study.queue;

import java.util.*;

/*
 * [Deque]
 * 
 *   -양방향 접근 가능. (=listIterator)
 *   
 *   1) insert = addFirst, offerFirst, addLast, offerLast
 *   2) examine = getFirst, peekFirst, getLast, peekLast
 *   3) remove = removeFirst, pollFirst, removeLast, pollLast
 * 
 */

public class Source02_Deque {
	public static void main(String[] args) {
		Deque <Integer>dq = new ArrayDeque<>();
		dq.offerFirst(3);
		dq.offerLast(9);
		dq.offerFirst(11);
		dq.offerFirst(41);
		dq.addLast(99);
		System.out.println(dq.toString());
		System.out.println(dq.peekFirst());
		System.out.println(dq.getLast());
		System.out.println("poll..."); 
		System.out.println(dq.pollFirst());
		System.out.println(dq.pollFirst());
		System.out.println(dq.pollLast());
		System.out.println(dq.toString());
		
		
		
		
		
	}
}
