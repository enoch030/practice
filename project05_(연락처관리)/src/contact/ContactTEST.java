package contact;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContactTEST {
	public static void main(String[] args) {
		Set<Contact> filter = new LinkedHashSet<>();
		String in = "add 토니 01011112222 히어로";
		String[] ins = in.split("\\s+");
		
		Contact c1 = new Contact(ins[1], ins[2]);
		System.out.println(filter.add(c1));
		
		Contact c2 = new Contact(ins[1], ins[2]);
		System.out.println("중복? "+ (c1==c2));
		System.out.println(filter.add(c2));
		
		
	}
}
