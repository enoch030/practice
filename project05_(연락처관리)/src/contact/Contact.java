package contact;

import java.io.Serializable;

public class Contact implements Serializable { // 연락처 중복 불가!
	String name;
	String phone;
	
	public Contact() {}
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
//		System.out.println("hashCode 불렀닝?");
		int n = 0;
		int p = 0;
		for(int i = 0; i < name.length(); i++) {
			n += name.charAt(i);
		}
		for(int i = 0; i < phone.length(); i++) {
			p += phone.charAt(i);
		}
		return n*31 + p * 11;
	}
	
	@Override
	public boolean equals(Object obj) {
//		System.out.println("equals 불렀닝?");
		if(this == obj)
			return true;
		if(obj instanceof Contact) {
			Contact other = (Contact)obj;
			return other.name.equals(this.name) && other.phone.equals(this.phone);
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String toString() {
		return name+" ("+phone+")";
	}

	
	
}
