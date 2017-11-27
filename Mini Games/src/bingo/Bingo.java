package bingo;

public class Bingo {
	int num;
	boolean flag;
	boolean user;

	public Bingo(int num) {
		this.num = num;
		this.flag = false;
	}

	public Bingo(int num, boolean user) {
		this.num = num;
		this.flag = false;
		this.user = user;
	}

	public String toString() {
		if (this.flag) {
			return " +";
		}
		if (this.user) {
			return this.num < 10 ? " " + this.num : Integer.toString(this.num, 10);
		}
		return " ?";
	}
}
