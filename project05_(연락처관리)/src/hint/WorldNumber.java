package hint;

import java.util.*;
import java.io.*;

public class WorldNumber {
	public static void main(String[] args) {
		Map<Integer, List<String> > nums = new TreeMap<>(); // key의 오름차순 정렬 효과를 위해 TreeMap 사용!
		Console cons = System.console();
		
		while(true) {
			// 등록 형식 : add 1 one  || add 3 셋 || add 3 three
			// 검색 형식 : list 1 -> key값 1에 저장된 List를 보여주기.
			String w = cons.readLine("WN >");
			String[] ar = w.split("\\s+");
			switch(ar[0]) {
			case "add" :
				if(ar.length < 3) {
					System.out.println("잘못된 사용법 입니다. \n사용예) add 숫자 단어");
					continue; //(while의 } 로 직행함
				} else {
					if(nums.get(Integer.parseInt(ar[1])) == null) {
						nums.put(Integer.parseInt(ar[1]), new ArrayList<>());
					}
					nums.get(Integer.parseInt(ar[1])).add(ar[2]) ; 
				}
				break;
			case "list" :
				System.out.println(nums.toString());
				break;
			default : System.out.println("처리할 수 없는 명령입니다.");
			}
			System.out.println();
		}
		
		
	}
}
