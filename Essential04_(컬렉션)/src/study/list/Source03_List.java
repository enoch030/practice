package study.list;

import java.util.*;

public class Source03_List {
	public static void main(String[] args) {
		String[] arr = "SUN.NUM.TUE.WED.THU.FRI.SAT".split("\\.");
		System.out.println(arr.length);
		List<String> list = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(list.get(4));
		List<String> slist = list.subList(2, 5);
//		list.remove(5); // subList 사용 중에 원본에 변화가 일어나면 예외 발생(동시 수정 불가 에러)!
//		slist.set(2, "thu"); // list원본 바뀜.
		slist.remove(2);
		System.out.println(slist.get(1));
		System.out.println(list.get(4)); // FRI. subList가 지우니까 원본도 지워짐.
		
		// subList에서 원본에 손대는 건 예외 발생하지 않음.
		// subList에서 사용 중인데 원본에서 변화 발생하면 예외 발생.
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
