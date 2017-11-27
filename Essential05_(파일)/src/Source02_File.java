import java.io.*;

public class Source02_File {
	public static void main(String[] args) {
		File base = new File("c:\\Program Files","Java");
		System.out.println(base.exists());
		
		// 1) getParent() : 부모 경로 반환해줘! ( 부모의 absolutePath() ) 
		String p = base.getParent();
		System.out.println(p);
		
		// 2) getParentFile() : 부모를 File 객체로 반환.
		File pfile = base.getParentFile(); 
		System.out.println(pfile.getName()+" & "+pfile.getAbsolutePath());
		File pfile2 = pfile.getParentFile();
		System.out.println(pfile2.getName() + " & "+pfile2.getAbsolutePath()); // 안 나옴. 이름이 루트(\)라.
	
		File pfile3 = pfile2.getParentFile(); // 더 이상의 상위가 없으면 Null
//		System.out.println(pfile3.getAbsolutePath());// 터짐!!!
		
		
		
		
		
		
		
		
	}
}
