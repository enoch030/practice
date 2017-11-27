

import java.io.*;

public class Source04_File {
	public static void main(String[] args) {
		
		File target = new File("d:\\","temp");
		
		// 1) boolean mkdir() : 디렉토리 생성
		//    - 이미 존재하는 디렉터리거나, 파일 안에 디렉터리 생성을 시도하거나, 없는 부모 디렉터리를 인자로 주면 실패.
		boolean b = target.mkdir();
		System.out.println(b);

		// 2) boolean renameTo() : 이름 변경
		//    - 원본 대상이 없거나, 바꾸려는 이름이 이미 존재하는 이름일 때 실패.
		File m = new File("d:\\","temp2");
		boolean bb = target.renameTo(m); //target을 m으로 rename 함.
		System.out.println("rename? "+bb);
		
		// 3) boolean delete() : 삭제
		//    - 삭제하려는 대상이 없거나, 혹은 디렉터리의 경우 소속된 자식이 있을 경우 실패.
		//    - 소속된 자식을 전부 지워야 디렉토리를 지울 수 있음.
		boolean bbb = m.delete();
		System.out.println(bbb);
		
		File t = new File("c:\\Windows");
		System.out.println(t+" is exist? "+t.exists());
		System.out.println(t+" is directory? "+t.isDirectory());
		boolean f = t.delete();
		System.out.println(f); // 못 지움.
		
		
	}
}
