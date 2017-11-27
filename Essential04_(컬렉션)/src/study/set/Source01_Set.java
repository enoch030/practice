package study.set;

/*
 * [ Set ]
 * 
 * - 중복 저장 불가. 
 * 	 (객체 자체는 다른 객체일 지라도, 동일하다고 판단되면 중복! 저장 안 함!)
 *   (=> String및 Wrapper 객체는 데이터가 같으면 같다고 판단함. 
 * 		
 * - 자주 쓰이는 class는
 *   HashSet       : 속도 가장 빠름. 순서 X
 *   LinkedHashSet : HashSet보다 느림. 순서 O
 *   
 *   TreeSet       : 저장한 객체의 value로 정렬됨.
 *   
 * 
 */
import java.util.*;

public class Source01_Set {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<>(); // 선언할 때 Generic 지정했으면 뒤에는 <>로 둬도 됨!!
		Set<String> s2 = new LinkedHashSet<>();
		Set<String> s3 = new TreeSet<>();
		
		String[] data = "jan,feb,mar,feb,apr,may,may,jun,jan".toUpperCase().split(",");
		System.out.println(data[1] == data[3]); //false. 동일 객체는 아니지만 동일하다고 판단되므로 저장 안 함.
		
		for(int i = 0; i<data.length; i++) {
			boolean b1 = s1.add(data[i]);
			boolean b2 = s2.add(data[i]);
			boolean b3 = s3.add(data[i]);
			System.out.println(b1+".."+b2+".."+b3);
		}
		
		System.out.println(s1.toString()); //[FEB, JUN, APR, MAY, JAN, MAR]
		// HashSet : 객체가 가진 HashCode별 정렬되기 때문에 사람 눈엔 무뜬금 출력. 저장 순서 개무시됨.
		System.out.println(s2.toString()); //[JAN, FEB, MAR, APR, MAY, JUN]
		// LinkedHashSet : 입력 순서대로 정렬됨.
		System.out.println(s3.toString()); //[APR, FEB, JAN, JUN, MAR, MAY]
		// TreeSet : iterator가 값이 적은 것부터 차례로 접근. (=알파벳 순)
		
		
		
	}
}
