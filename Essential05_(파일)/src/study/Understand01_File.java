package study;

import java.io.File;

import javax.swing.JFileChooser;

public class Understand01_File {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		File file = jfc.getSelectedFile();

		String path = file.getAbsolutePath();
		System.out.println("PATH = "+ path);
		
		// 선택한 파일의 이름
		// 		부모 디렉터리 (String indexOf / lastIndexOf / substring
		// 파일 크기: 두 가지 버전으로 출력. 1) byte, 2) 데이터 크기에 따라 MB/KB/byte로 단위 변환해서.
		// 1024 byte => 1kb
		// 1024 kb   => 1mb
		// 1024 mb   => 1GB
		// 1024 gb   => 1TB
		// 1024 tb   => 1PB
		String name = file.getName();
		System.out.println("NAME = "+name);
		int i = path.lastIndexOf(name);
		System.out.println("부모 디렉터리 = "+path.substring(0,(i-1)));
		long size = file.length();
		System.out.println("파일 크기 = "+size+" byte");
		
		double length = 0;
		String str = "";
		
		if(size < 1024) {
			System.out.println(size +" byte");
		} else if(size >= 1024 && size < 1024*1024) {
			length = size/1024.0;
			str =  Double.toString(length);
			String sstr = str.substring(0,3);
			if(sstr.contains(".")) {
				sstr += str.charAt(3);
			}
			System.out.println(sstr+ "KB");
		} else {
			length = size/(1024.0*1024);
			str = Double.toString(length);
			String sstr = str.substring(0,3);
			if(sstr.contains(".")) {
				sstr += str.charAt(3);
			}
			System.out.println(sstr+" MB");
		}
		
		
		
	
	
	}
}
