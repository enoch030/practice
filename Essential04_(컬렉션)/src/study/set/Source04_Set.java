package study.set;

import java.util.*;

class CarNumber implements Comparable<CarNumber> {
	int type; // 차종
	char use; // 용도
	int serial; // 일련번호

	CarNumber(int type, char use, int serial) {
		this.type = type;
		this.use = use;
		this.serial = serial;
	}

	public String toString() {
		String t = String.valueOf(type);
		String s = String.valueOf(serial);

		if (type < 10) {
			t = "0" + type;
		}

		switch (s.length()) {
		case 1:
			s = "000" + s;
			break;
		case 2:
			s = "00" + s;
			break;
		case 3:
			s = "0" + s;
			break;
		}
		return t + " " + use + " " + s;
	}

	@Override
	public int compareTo(CarNumber o) {
		if (type != o.type) {
			return type - o.type;
		} else {
			if (use != o.use)
				return use - o.use;
			else
				return serial - o.serial;
		}
	}

	// ==========================================[우클릭 & source & Generate hashCode()
	// and equals()]

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serial;
		result = prime * result + type;
		result = prime * result + use;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarNumber other = (CarNumber) obj;
		if (serial != other.serial)
			return false;
		if (type != other.type)
			return false;
		if (use != other.use)
			return false;
		return true;
	}

	// @Override
	// public int hashCode() {
	// return type*31 + use*11 + serial*53<<1;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if(obj == this) {
	// return true;
	// }
	// if(obj instanceof CarNumber) {
	// CarNumber cnum = (CarNumber)obj;
	// return cnum.type == this.type && cnum.use == this.use && cnum.serial ==
	// this.serial;
	// }
	// return false;
	// }

}

public class Source04_Set {
	public static void main(String[] args) {
		Set<CarNumber> set = new HashSet<>();
		CarNumber[] cn = new CarNumber[15];

		for (int i = 0; i < cn.length; i++) {
			int t = (int) (Math.random() * 2) * 10 + 1; // 차종 랜덤 뽑기
			int r = (int) (Math.random() * 2);
			char u = "가바".charAt(r); // 차 용도 랜덤 뽑기
			int s = (int) (Math.random() * 2) * 1000 + 30; // 차 일련번호 랜덤 뽑기
			cn[i] = new CarNumber(t, u, s);
			System.out.println(i + ": " + cn[i].toString());
		}

		// ================================================================================

		// cn에는 중복을 제외하고 총 몇 대의 차량이??

		for (int i = 0; i < cn.length; i++) {
			set.add(cn[i]);

		}

		System.out.println("총 " + set.size() + " 대");

	}
}
