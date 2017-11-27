import java.io.*;

public class Source03_File {
	public static void main(String[] args) {
		
		File java = new File("C:\\Program Files\\Java\\jdk1.8.0_144");
		File f1 = new File(java, "bin");
		
		String[] list = f1.list(); // 해당 File 안에 들어있는 애들(=소속된 자식들) 이름이 나옴. -디렉토리에서 추출
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		
		File[] cf = java.listFiles(); // 자식들을 전부 File 타입으로 만들어줌.
		for(int i = 0; i < cf.length; i++) {
			String fn = cf[i].getName();
			String ap = cf[i].getAbsolutePath();
			System.out.println(fn+" ("+ap+")");
		}
		
		
		//==================================================================================
		
		File f2 = new File(java, "src.zip");
		String[] f2list = f2.list(); // 파일은 하위 자식이 있을 수 없으므로 Null!
		System.out.println(f2list);
		
		File f3 = new File("C:\\새 폴더"); // 빈 폴더(디렉토리)의 list를 요구하면 0이 나옴! Null은 아님!
		String[] f3list = f3.list();
		System.out.println(f3.length());
		
		
		
		
		
		
		
		
	}
}
