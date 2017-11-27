package bingo;

import java.util.Arrays;

public abstract class NumberManager {
	int[] nums;

	public NumberManager(BingoPan pan) {
		this.nums = new int[pan.size * pan.size];
	}

	public abstract boolean contains(int paramInt);

	public abstract void add(int paramInt);

	public abstract int pick();

	public String toString() {
		return Arrays.toString(this.nums);
	}
}
