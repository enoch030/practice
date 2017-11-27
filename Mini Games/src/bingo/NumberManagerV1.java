package bingo;

import java.io.PrintStream;
import java.util.Arrays;

public class NumberManagerV1 extends NumberManager {
	public NumberManagerV1(BingoPan pan) {
		super(pan);
	}

	private int index = 0;

	public boolean contains(int n) {
		for (int i = 0; i < this.nums.length; i++) {
			if (this.nums[i] == n) {
				return true;
			}
		}
		return false;
	}

	public void add(int n) {
		this.nums[this.index] = n;
		this.index += 1;
	}

	public int pick() {
		int n = (int) (Math.random() * this.nums.length) + 1;
		while (contains(n)) {
			n = (int) (Math.random() * this.nums.length) + 1;
		}
		return n;
	}

	public int pick(BingoPan com) {
		int[] rows = new int[com.size];
		int[] cols = new int[com.size];
		int[] cross = new int[2];
		int[] picked = new int[3];
		int[] max = new int[3];
		int i = 0;
		int idx = 0;
		int check = 0;
		int[] tmp = new int[3];
		int rnum = 0;
		for (int r = 0; r < com.pan.length; r++) {
			check = 0;
			for (int c = 0; c < com.pan[r].length; c++) {
				if (com.pan[r][c].flag) {
					check++;
				}
			}
			if (check < com.size) {
				rows[idx] = check;
			} else {
				rows[idx] = 0;
			}
			idx++;
		}
		idx = 0;
		for (int c = 0; c < com.pan.length; c++) {
			check = 0;
			for (int r = 0; r < com.pan.length; r++) {
				if (com.pan[r][c].flag) {
					check++;
				}
			}
			if (check < com.size) {
				cols[idx] = check;
			} else {
				cols[idx] = 0;
			}
			idx++;
		}
		int cross1 = 0;
		int cross2 = 0;
		for (int n = 0; n < com.size; n++) {
			if (com.pan[n][n].flag) {
				cross1++;
				if (cross1 < com.size) {
					cross[0] = cross1;
				}
			}
			if (com.pan[n][(com.size - 1 - n)].flag) {
				cross2++;
				if (cross2 < com.size) {
					cross[1] = cross2;
				}
			}
		}
		max[0] = rows[0];
		max[1] = cols[0];
		max[2] = cross[0];
		for (idx = 1; idx < com.size; idx++) {
			if (rows[idx] > max[0]) {
				max[0] = rows[idx];
				tmp[0] = idx;
			}
		}
		for (idx = 1; idx < com.size; idx++) {
			if (cols[idx] > max[1]) {
				max[1] = cols[idx];
				tmp[1] = idx;
			}
		}
		if (cross[1] > max[2]) {
			max[2] = cross[1];
			tmp[2] = 1;
		}
		for (int c = 0; c < com.pan[tmp[0]].length; c++) {
			if (!com.pan[tmp[0]][c].flag) {
				picked[0] = com.pan[tmp[0]][c].num;
				break;
			}
		}
		for (int r = 0; r < com.pan.length; r++) {
			if (!com.pan[r][tmp[1]].flag) {
				picked[1] = com.pan[r][tmp[1]].num;
				break;
			}
		}
		for (int n = 0; n < com.pan.length; n++) {
			if (tmp[2] == 0) {
				if (!com.pan[n][n].flag) {
					picked[2] = com.pan[n][n].num;
					break;
				}
			} else if (!com.pan[n][(4 - n)].flag) {
				picked[2] = com.pan[n][(4 - n)].num;
				break;
			}
		}

		rnum = max[0];
		int temp = 0;
		for (i = 1; i < max.length; i++) {
			if (max[i] > rnum) {
				rnum = max[i];
				temp = i;
			}
		}
		for (i = 0; i < picked.length; i++) {
			if (picked[i] == 0) {
				return pick();
			}
		}
		return picked[temp];
	}
}
