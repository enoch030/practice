package contact;
/*
 * [ 연락처 관리 프로그램 ]
 * 
 * - 연락처 중복 저장 안 됨! 
 *   (Set 계열을 List로 묶어서 관리 = Set은 연락처 객체, List는 그룹 관리)
 * - 입력 예) add 피카츄 01011112222 포켓몬  
 *   (add하면 연락처 등록, name = 피카츄, phone = 010 ~ List<String> 포켓몬(key값) )
 *   입력 예) list 친구
 *   "친구" List를 보여주면 됨.
 * 
 */

import java.util.*;
import java.util.Map.*;
import java.io.*;

public class ContactMain {
	public static void main(String[] args) {
		Map<String, List<Contact>> map = new TreeMap<>();
		Set<Contact> set = new HashSet<>(); // 사용자 입력값 저장(중복체크)
		
		
		Console cs = System.console();

		System.out.println("====[ 연락처 관리 프로그램 ]====");
		System.out.println("연락처 등록 예) add 아이언맨 010-1234-4567 히어로");
		System.out.println("그룹 보기 예) list 히어로");

		while (true) {
			String user = cs.readLine("\n명령을 입력하세요(종료:Q)>");
			if(user.equalsIgnoreCase("Q")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			String[] orders = user.split("\\s+");
			String name, phone, group;

			switch (orders[0]) { // 명령 종류 확인 : 등록 ? 그룹 보기 ?
			case "add": case "ADD": case "Add":
				if (orders.length < 4) { // 인자가 다 입력되지 않았을 때
					System.out.println("잘못된 사용법 입니다. \n사용예) add 이름 연락처 그룹");
					continue;
				} else {
					name = orders[1];
					phone = orders[2];
					group = orders[3]; // map의 key
					if (!set.add(new Contact(name,phone))) { // 등록된 연락처라면
						
						Set<Entry <String, List<Contact>>> entry = map.entrySet();
						for(Entry<String, List<Contact>> e : entry) {
							List<Contact> clist = e.getValue();
							System.out.println(clist.toString());
							
							if(clist.contains(new Contact(name,phone))) {
								String key = e.getKey();
								System.out.println(clist.toString() + " 은(는) "+key+ "에 이미 저장된 연락처 입니다. 저장되지 않습니다.");
								continue;
							} else if(clist.get(1).equals(phone)) {
								String key = e.getKey();
								System.out.println(phone+" 은(는)"+key+" 에 이미 저장된 번호입니다.");
							}
						}
					} /*else if (!set.add(phone)) { // 등록된 연락처(번호)라면
						System.out.println(phone + "은(는) 이미 저장된 연락처 입니다. 저장되지 않습니다.");
						continue;
						
					}*/
					if (map.get(group) == null) { // 만약 없는 그룹이라면 그룹 생성
						map.put((group), new ArrayList<Contact>());
					}
					map.get(group).add(new Contact(name, phone));
					System.out.println("연락처가 등록되었습니다.");
				}
				break;
			case "list": case "LIST": case "List":
				if (orders.length < 2) { // 인자가 다 입력되지 않았을 때
					System.out.println("잘못된 사용법 입니다. \n사용예) list 그룹");
					continue;
				}
				group = orders[1];
				if (map.get(group) == null) { // 없는 그룹을 요청할 때
					System.out.println("없는 그룹입니다.");
					continue;
				}
				System.out.println(map.get(group).toString());
				break;
			default:
				System.out.println("처리할 수 없는 명령입니다.");
			}
		}

		
		
		
		
		
		
		
		
		
	}
}
