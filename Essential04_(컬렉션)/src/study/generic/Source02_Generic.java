package study.generic;

class Tester<T extends CharSequence> {
//class Tester<T extends Number> {
	void execute(T t) {
		
	}
}

public class Source02_Generic {
	public static void main(String[] args) {
		
//		Tester <String> t = new Tester(); // bound mismatch. Number계열만 가능. Integer, Double...
//		Tester <Double> t = new Tester();
//		t.execute(3.0);
		
		
		// CharSequence 인터페이스를 상속받은 모든 객체들 가능!
		Tester<String> t = new Tester<String>();
		Tester<StringBuilder> tt = new Tester<StringBuilder>();
		
	}
}
