package hangman;

import java.io.Console;

public class Hangman_Set {
	public static void main(String[] args) {
		
		
		
		
		
		// 1단계. 게임 밑 작업 #==========================================================
		Console c = System.console();
		String ctg = "그리스 신";
		String[] quizs = "STARCRAFT,WARCRAFT,LINEAGE,OVERWATCH,BATTLEGROUND".split(",");
		// 문자열배열중에 하나를 랜덤픽하시고,
		String quiz = quizs[ (int)(Math.random()*quizs.length) ];
		System.out.println("주제는 .. " + ctg+" 입니다.");
		// StringBuilder 하나를 만들어서, 퀴즈length만큼 "?" 혹은 "_"를 append
		StringBuilder show = new StringBuilder();
		while(show.length()<quiz.length()) {
			show.append("?");
		}
		// 2단계. 게임 유도 ==============================================================
		int limit =5;
		while(limit>0 ) {
			String in = c.readLine("%s (남은기회:%s) : ", show.toString(), limit);
			if(in.length()>=2) {
				System.out.println("한문자씩 입력바랍니다.");
				continue;
			}
			char ch = in.toUpperCase().charAt(0);	//
			int cnt =0;	// 몇번 작업한건지 개수 체크용
			
			int from = 0;
			while(true) {
				int idx = quiz.indexOf(ch, from);
				if(idx == -1) 
					break;
				else {
					show.setCharAt(idx, ch);
					cnt++;
					from = idx +1;
				}
			}
			
			
			/*for(int i=0; i<quiz.length() ; i++) {
				if(quiz.charAt(i) == ch) {
					show.setCharAt(i, ch);
					cnt++;
				}
			}*/
			if(cnt==0) {	// 그래서 0이면 한번도 못한거니까 까고,
				System.out.println(ch+" 는(은) 없는 문자입니다.");
				limit--;
			}
			if(show.toString().equals(quiz)) {
				System.out.println("축하드립니다.");
				break;
			}
		}
		System.out.println("정답은 [" + quiz+"]");
		
		// 1. StringBuilder 상태를 출력
		// 2. 사용자로부터 문자를 입력받으시고..(  String charAt(0) 해서.. 문자뽑아서 처리)
		// 3. 해당문자의 위치를 픽한 String에서 찾아야되고..
		// 4. StringBuilder에서 그 위치에 해당하는 문자를 사용자가 입력한걸로 변경 
		
		// 1▷▷▷▷▷4 까지의 과정을 반복처리하시면 됨.
		// 언제까지? StringBuilder의 문자열과 pick한 문자열이 같아지거나,
		// 혹은 카운트가 소진될때까지..
		
		
		// 요구사항! 
		// 1. 사용자는 무조건 한문자씩 입력해야 함. -(2문자 이상입력시 룰위배 라고 처리) 
		// 2. 사용자는 대문자나 소문자로 입력을 한다.
		// 3. 같은 문자 입력하는건 유저의 선택.
		
		// 생각해볼것..? 컴과의 대전으로 된다면... 클래스를 만들어서 처리하는게 좋음.
	}
}




