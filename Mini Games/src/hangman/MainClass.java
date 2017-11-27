package hangman;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] quiz = "LION,TIGER,RABBIT,GIRAFFE,ELEPHANT".split(",");
		String theme = "동물 이름";
		
		Set<Character> set = new HashSet<>();
		
		
		String guess = "";
		int life = 5;


		int idx = (int) (Math.random() * quiz.length);
		StringBuilder show = new StringBuilder(quiz[idx]);
		for (int i = 0; i < quiz[idx].length(); i++) {
			show.setCharAt(i, '?');
		}
		char p;
		int pi = 0;

		System.out.println("주제는 " + theme + "입니다.");
		hangman: while (life > 0) {

			while (true) {
				System.out.println("정답을 입력하세요.");
				System.out.println(show);
				guess = sc.nextLine();
				guess = guess.toUpperCase();
				
				char[] player = guess.toCharArray();
				p = player[0];
				boolean b = set.add(p);
				
				if (player.length > 1) {
					System.out.println("한 단어씩 입력하세요.");
				} else if (!(p >= 'A' && p <= 'Z')) {
					System.out.println("알파벳만 입력하세요.");
				} else if (quiz[idx].indexOf(p) != -1) {
					pi = quiz[idx].indexOf(p);

					if (b != true) {
						System.out.println("중복된 단어입니다!");
						String showSet = "";
						Iterator<Character> it = set.iterator();
						while(true) {
							showSet += it.next();
							if(it.hasNext())
								showSet += ", ";
							else
								break;
						}
						System.out.println("지금까지 입력한 글자: "+showSet);
						System.out.println("남은 기회: " + (--life));
						continue hangman;
					} else {
						break;
					}
				} else {
					System.out.println("땡!!!");
					System.out.println("남은 기회: " + (--life));
					if (life < 1)
						break hangman;
				}
			}

			while (pi != -1) {
				show.setCharAt(pi, p);
				pi = quiz[idx].indexOf(p, ++pi);
			}
			System.out.println(show);
			if (show.toString().equals(quiz[idx])) {
				System.out.println("정답입니다!!");
				System.out.println("정답 : " + quiz[idx]);
				break;
			}  
		}
		
		if (life < 1 && !(show.toString().equals(quiz[idx])) ){
			System.out.println("정답 : " + quiz[idx]);
			System.out.println("사...망...ㅠㅠ");
		}

	}
}
