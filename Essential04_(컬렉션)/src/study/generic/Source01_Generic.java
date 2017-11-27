package study.generic;

/*
 *  [ Generic ]
 *  
 *  - jdk 1.5버전부터 생긴 문법.
 *  - default는 Object지만, 일반적으로 <Object>로 명시하고 사용함.
 *  - 기본형으로는 Generic 설정 불가.
 *  - Object 하위의 "객체" 타입으로 설정해야 함.
 *    (반드시 클래스여야 하는 건 아님. Runnable같은 인터페이스는 가능)
 * 
 *  * 컬렉션 클래스들도 애초 설계는 Object 형태로 관리할 용도였음.
 *    하지만 지금은 어떤 타입의 객체를 저장할 지 지정(Generic)하고 사용하도록 권장.
 * 
 */
import java.util.*;

class Sample<E> { // 여기서 <> Generic 설정해두지 않으면 Object로 설정돼버림.
	E data;
	
	Sample() {
	}
	
	E currentData() { // getter
		return data;
	}
	void changeData(E data) { //setter
		this.data = data;
	}
}

public class Source01_Generic {
	public static void main(String[] args) {
		Sample<String> sp = new Sample<String>(); //매개변수를 Object가 아니라 <>안의 객체로 제한하는 것
		sp.changeData("ss");
		
		Set set = new HashSet();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
