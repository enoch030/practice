package bingo;

import java.util.Arrays;

public class BingoPan {
	Bingo[][] pan;
	boolean user;
	int size;

	public BingoPan() {
		this(false, 0);
	}

	public BingoPan(boolean user) {
		this(user, 0);
	}

	public BingoPan(boolean user, int size) {
		this.user = user;

		if (size < 1) {
			size = 5;
		}
		this.size = size;
		this.pan = new Bingo[this.size][this.size];
		init();
	}

	private void init() { // 빙고판에 숫자 세팅
		int num = 1;
		while (num <= this.size * this.size) {
			int row = (int) (Math.random() * this.size);
			int col = (int) (Math.random() * this.size);
			if (this.pan[row][col] == null) {
				this.pan[row][col] = new Bingo(num++, this.user);
			}
		}
	}

	public void printToConsole() {
		for (int row = 0; row < this.pan.length; row++) {
			String s = Arrays.toString(this.pan[row]);
			System.out.println(s);
		}
		System.out.println();
	}

	static void combinePrintToConsole(BingoPan p1, BingoPan p2) {
		for (int r = 0; r < p1.pan.length; r++) {
			String sp1 = Arrays.toString(p1.pan[r]);
			String sp2 = Arrays.toString(p2.pan[r]);
			System.out.println(sp1 + "\t" + sp2);
		}
	}

	public void markingBingo(int n) {
		for (int r = 0; r < this.pan.length; r++) {
			for (int c = 0; c < this.pan[r].length; c++) {
				if (this.pan[r][c].num == n) {
					this.pan[r][c].flag = true;
					break;
				}
			}
		}
	}

	public int checkBingo() {
		int bingo, cross1, cross2;
		bingo = cross1 = cross2 = 0;

		for (int r = 0; r < this.size; r++) {
			for (int c = 0, count = 0; c < this.pan[r].length; c++) {
				if (this.pan[r][c].flag) {
					count++;
					if (count == this.size)
						bingo++;
				}
			}
		}
		for (int c = 0; c < this.size; c++) {
			for (int r = 0, count = 0; r < this.size; r++) {
				if (this.pan[r][c].flag) {
					count++;
					if (count == this.size)
						bingo++;
				}
			}
		}
		
		for (int i = 0; i < this.size; i++) {
			if (this.pan[i][i].flag) {
				cross1++;
			}
			if (this.pan[i][(this.size - 1 - i)].flag) {
				cross2++;
			}
		}
		if (cross1 == this.size)
			bingo++;
		if (cross2 == this.size)
			bingo++;
		return bingo;
	}
}
