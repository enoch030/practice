/*
 * [File 객체]
 * 
 *  - 현재 작동 중인 컴퓨터의 파일 시스템(파일 / 디렉토리) 을 제어하기 위한 클래스.
 * 
 * 1) File(String pathName) - full path  : 풀 경로 다 적음
 * 2) File(String parent, String child)  : 부모(상위)부분과 자식 이름 따로 설정.
 * 3) File(File parent, String child)
 * 
 *       ** method **
 * <정보 추출>
 * 4) String getParent()   : 부모 경로 반환. ( 부모의 absolutePath() ) 
 * 5) File getParentFile() : 부모를 File 객체로 반환.
 * 6) String[] list() 	   : 해당 File (디렉토리)안에 들어있는 애들(소속된 자식) 이름 전부 반환.
 *						     - 디렉토리가 아닌 파일일 경우 리스트를 요구하면 Null 나오면서 터짐. 
 *                           - 빈 폴더(디렉토리)의 리스트를 요구하면 0을 반환.
 * 7) File[] listFiles()   : 소속된 자식을 전부 File 타입으로 반환해 줌.
 * 
 */
import java.io.*;
import java.util.Date;

public class Source01_File {
	public static void main(String[] args) {
		//File 객체 생성
		// 1)
		File f1 = new File("c:\\Program Files\\Internet Explorer\\F12.dll"); // 시스템상의 풀 경로 (디렉터리)
		File f2 = new File("d:\\while.txt"); 	 // 시스템상의 풀 경로 (파일)
		// 2)
		File f3 = new File("c:\\","Recovery"); 	 // 부모(경로)와 대상 이름을 따로 설정해도 됨.
		// 3)
		File f4 = new File(f1, "JAVA");
		File f5 = new File(f4, "jdk1.8.0_144");
		File f6 = new File(f5, "bin");
		File f7 = new File(f6, "src.zip");
		
		File[] fs = new File[] {f1, f2, f3, f4, f5, f6, f7};
		for(int i = 0; i < fs.length; i++) {
			File t = fs[i];
			System.out.println((i+1)+" =========================");
			String path = t.getAbsolutePath(); // 절대 경로(소속까지 모두) 리턴해 줘!
			System.out.println("path? "+path);
			String name = t.getName();         // 파일/경로 이름 리턴해 줘!
			System.out.println("name? "+name); 
			System.out.println("exist? "+t.exists()); // 실제로 존재하니?
			System.out.println("isDirectory? "+t.isDirectory()); //디렉토리니?
			System.out.println("isFile? "+t.isFile());      //파일이니?
			System.out.println("isHidden? "+t.isHidden()); //숨김설정여부
			long t1 = t.length(); // 파일크기(byte) / 디렉토리의 경우 (몇 개가 소속되어 있는지)
			System.out.println("length? "+t1); 
			long t2 = t.lastModified(); // 최종 수정 시간 
			                            // (CurrentTimeMillis : 1970년도 ~ 로부터 흐른 시간 기준으로)
			System.out.println("lastModified? "+t2 + " / "+new Date(t2).toString());
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
