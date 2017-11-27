package bingo;

import java.util.Scanner;

public class BingoGame {
	public static void main(String[] args) {
		BingoPan com = null;
		BingoPan player = null;
		Scanner cin = new Scanner(System.in);

		int size = 0;
		int game = 0;
		int turn = 1;
		int pBingo;
		int cBingo;
		int pChk = 0;
		int cChk = 0;
		int pScore = 0;
		int cScore = 0;
		int draw = 0;
		int select = 0;
		int mode = 0;
		String winner = "";
		String menu = "===== [빙고 게임] =====\n1. 게임 시작\n2. 전적\n3. 난이도\n4. 현재 설정\n0. 종료하기\n▶";

		for (;;) {

			System.out.println(menu);
			select = cin.nextInt();

			switch (select) {
			case 1:
				player = new BingoPan(true, size);
				com = new BingoPan(false, size);
				NumberManagerV1 mng = new NumberManagerV1(com);
				turn = 1;
				pChk = 0;
				cChk = 0;
				cBingo = 0;
				pBingo = 0;

				for (;;) {
					if (turn > 1) {
						pBingo = player.checkBingo();
						cBingo = com.checkBingo();
						if (pBingo > pChk) {
							System.out.println("\t☆★☆★플레이어 :" + pBingo + " 빙고!★☆★☆");
							System.out.println();
							pChk++;

							if (pBingo >= com.size) {
								winner = "player";
								pScore++;
								game++;
								System.out.println("▼ 플레이어\t\t" + (com.size > 5 ? "\t\t\t" : "")
										+ (mode != 2 ? "이지모드" : "노말모드") + " 컴퓨터 ▼");
								BingoPan.combinePrintToConsole(player, com);
								System.out.println();
								System.out.println("플레이어 : " + pBingo + " 빙고");
								System.out.println("컴퓨터   : " + cBingo + " 빙고");
								break;
							}
						}
						if (cBingo > cChk) {
							System.out.println("\t☆★☆★computer :" + cBingo + " 빙고!★☆★☆");
							System.out.println();
							cChk++;
							if (cBingo >= com.size) {
								winner = "computer";
								cScore++;
								game++;
								System.out.println("▼ 플레이어\t\t" + (com.size > 5 ? "\t\t\t" : "")
										+ (mode != 2 ? "이지모드" : "노말모드") + " 컴퓨터 ▼");
								BingoPan.combinePrintToConsole(player, com);
								System.out.println();
								System.out.println("플레이어 : " + pBingo + " 빙고");
								System.out.println("컴퓨터  : " + cBingo + " 빙고");
								break;
							}
						}
					}
					int num = 0;
					System.out.println(
							"▼ 플레이어\t\t" + (com.size > 5 ? "\t\t\t" : "") + (mode != 2 ? "이지모드" : "노말모드") + " 컴퓨터 ▼");
					BingoPan.combinePrintToConsole(player, com);
					System.out.println();

					if (turn % 2 != 0) {
						System.out.println("숫자를 입력하세요----------");
						for (;;) {
							num = cin.nextInt();
							if (num <= 0 || (num > com.size * com.size)) {
								System.out.println("다시 입력하세요(1 ~ " + com.size * com.size + ")\n");
							} else {
								if (!mng.contains(num))
									break;
								System.out.println("이미 외친 숫자입니다. 다시 입력하세요\n");
							}
						}
						System.out.println();
					} else {
						if (mode == 2) {
							num = mng.pick(com);
						} else {
							num = mng.pick();
						}
						System.out.println("com: " + num + "\n");
					}
					turn++;

					mng.add(num);
					player.markingBingo(num);
					com.markingBingo(num);
				}

				if (cBingo == pBingo) {
					System.out.println("\t☆★☆★ 무승부!!★☆★☆");
					draw++;
				} else {
					System.out.println("\t☆★☆★ 승자:" + winner + "!!★☆★☆");
					System.out.println();
				}
				break;
			case 2:
				System.out.println("===== 게임 전적 =====");
				System.out.println("player: " + game + "전/ " + pScore + "승/ "+draw+"무/ " +cScore + "패");
				System.out.println();
				break;
			case 3:
				System.out.println("===== 난이도 =====");
				System.out.println("1. 빙고 크기 설정\n2. 빙고 모드 설정\n");
				int selLv = 0;
				for (;;) {
					selLv = cin.nextInt();
					if ((selLv > 0) && (selLv <= 2))
						break;
					System.out.println("숫자를 잘 못 입력하셨습니다.");
					System.err.println("다시 입력하세요.\n");
				}
				if (selLv == 1) {
					System.out.println("원하는 빙고 크기(홀수)를 입력하세요\n");
					for (;;) {
						size = cin.nextInt();
						if (size % 2 != 1) {
							System.out.println("짝수를 입력하셨습니다.");
							System.err.println("다시 입력하세요.\n");
						} else {
							if (size >= 5) {
								break;
							}
							System.out.println("빙고 크기가 너무 작습니다.");
							System.err.println("다시 입력하세요.\n");
						}
					}
				} else if (selLv == 2) {
					System.out.println("1. 이지 모드\n2. 노말 모드\n");
					int selMod = 0;
					for (;;) {
						selMod = cin.nextInt();
						if ((selMod > 0) && (selMod <= 2)) {
							mode = selMod;
							break;
						}
						System.out.println("숫자를 잘 못 입력하셨습니다.");
						System.err.println("다시 입력하세요.\n");
					}
				}
				break;
			case 4:
				System.out.println("===== 현재 설정 =====");
				System.out.println("빙고 크기 : " + (size == 0 ? "5" : Integer.valueOf(size)));
				System.out.println("게임 모드 : " + (mode != 2 ? "이지 모드" : "노말 모드"));
				break;
			case 0:
				System.out.println("게임을 종료합니다..");
				break;
			default:
				System.out.println("숫자를 잘 못 입력하셨습니다.");
			}
		}
	}
}
