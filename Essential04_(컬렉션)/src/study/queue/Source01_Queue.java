package study.queue;

import java.util.*;

/*
 * [ Queue ]
 * 
 *  -넣은 순서대로 데이터를 뽑아올 수 있음. (FIFO)
 *   (먼저 add한 데이터 먼저 출력)
 *  -중복 저장 가능
 *  
 *  1) E elemnet()        == E peek()
 *  2) boolean offer(E e) == boolean add(E e)
 *  3) E poll()           == E remove()
 * 
 */

public class Source01_Queue {
	public static void main(String[] args) {
		Queue<String> q1 = new ArrayDeque<>(); 
		q1.add("전사");
		q1.offer("전사");
		q1.add("사냥꾼");
		System.out.println(q1.size());
		
		String s = q1.element();
		System.out.println(s);
		System.out.println(q1.peek());
		//==============================================
		String s2 = q1.remove(); // 지운 값을 출력해 줌.
		System.out.println(s2); 
		System.out.println(q1.size()); // 지워졌기 때문에 사이즈 줄어듬
		
		String s3 = q1.poll();
		System.out.println(s3+" "+q1.size());
		String s4 = q1.remove();
		System.out.println(s4+" "+q1.size());
		
		System.out.println(q1.isEmpty());
//		String s5 = q1.remove(); // 터짐
		String s5 = q1.poll(); // 터지진 않고 null 반환해줌.
		System.out.println(s5);
		
		
	}
}
