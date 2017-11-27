package cmd;

import java.io.*;
import java.util.Date;

public class CMDShellMain {
	public static void main(String[] args) {
		System.out.println();
		Date d = new Date(System.currentTimeMillis());
		System.out.println("Connected to CMD : " + d.toString());

		Console con = System.console();

		File wd = new File("c:\\Users"); // SORA CMD 디폴트 경로.
		while (true) {
			String cmd = con.readLine(wd.getAbsolutePath() + " (종료:Q) >");
			
			if(cmd.charAt(0)=='Q' || cmd.charAt(0)=='q') { // 종료 
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			String[] cmdArr = cmd.split("\\s+");
			String directory;
//			System.out.println(cmdArr.length);
			File tmp;
			
			
			
			if (cmdArr.length < 2) { // 명령어가 다 입력되지 않은 경우
				if(cmdArr[0].equalsIgnoreCase("cd..")) { // cd.. 일 경우
					if(wd.getParentFile() != null) { // 상위 경로가 존재할 경우
						tmp = wd.getParentFile();
						wd = tmp;
						continue;
					}
				} else if (!cmdArr[0].equalsIgnoreCase("dir") || !cmdArr[0].equalsIgnoreCase("cd")) {
					System.out.println("제대로 된 입력이 아닙니다.");
					continue;
				}
			}

			switch (cmdArr[0]) {
			case "CD": case "cd": case "Cd":

				// -------------------------------------------------------------------------[
				// 명령어 유효성 검사 ]
				String[] cmdArr2 = cmd.split("\\s+",2);
			
				if (cmdArr2.length == 1) { // 5) cd라고 칠 경우 - 현재 경로 보여줌.
					System.out.println(wd.getAbsolutePath());
					continue;
				}
				
				directory = cmdArr[1];

				if (directory.equals("..")) { // 2) cd.. - 상위경로로 이동
					if (wd.getParentFile() != null) { // 상위 경로가 있으면
						tmp = wd.getParentFile();
					} else { // 상위 경로가 없으면
						tmp = wd;
					}
				} else { // 3) cd 멀쩡한 경로
					tmp = new File(wd, directory);
					System.out.println(tmp.getName());
					if (!tmp.exists()) { // 존재하지 않는 경로
						System.out.println("존재하지 않는 경로입니다."); 
						continue;
					}
					if (!tmp.isDirectory()) { // 알고보니 경로가 디렉토리가 아닐 때
						System.out.println("경로가 올바르지 않습니다.");
						continue;
					}
				}

				wd = tmp;
				break;

			case "dir": case "DIR":	case "Dir":
				// --------------------------------------------------[명령어 유효성 검사 ]
				File[] files = wd.listFiles();
				for (int i = 0; i < files.length; i++) {
					if(files[i].isHidden()) {
						continue;
					}
					long mt = files[i].lastModified();
					String detail = new Date(mt).toString()+"\t";
					
					if(files[i].isDirectory()) {
						detail += "<DIR>\t";
					} else {
						detail += files[i].length();
					}
					detail += files[i].getName();
					System.out.println(detail);
				}
				break;

			case "mkdir": case "MKDIR": case "Mkdir":
				directory = cmdArr[1];
				tmp = new File(wd,directory);
				
				if(tmp.exists()) {
					System.out.println("하위 디렉터리 또는 파일"+directory+" (이)가 이미 있습니다.");
					System.out.println("");
				}
				System.out.println(directory+" (이)가 생성되었습니다.");
				
			case "rename": case "RENAME": case "Rename": // 1) 인자 3개 필요함.
				File src = new File(wd, cmdArr[1]);
				if(src.exists()) {
					File dst = new File(wd, cmdArr[2]);
					if(dst.exists()) {
						System.out.println("중복되는 파일 이름이 있거나, 파일을 찾을 수 없습니다.");
					} else {
						src.renameTo(dst);
					}
				} else {
					System.out.println("지정된 파일을 찾을 수 없습니다.");
				}
			}
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
