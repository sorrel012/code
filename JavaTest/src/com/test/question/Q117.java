package com.test.question;

import java.io.File;
import java.util.ArrayList;

public class Q117 {
	
	public static void main(String[] args) {

		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\폴더 삭제\\delete";
		
		File file= new File(path);
		File[] flist = file.listFiles();

		ArrayList<String> files = new ArrayList<String>();
		ArrayList<String> dirs = new ArrayList<String>();
		
		deleteFile(flist, files, dirs);
		
		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.", dirs.size(), files.size());

	} //main

	private static void deleteFile(File[] flist, ArrayList<String> files, ArrayList<String> dirs) {
		
		for(File f : flist) {
			
			if(f.isDirectory()) {
				dirs.add(f.getName());
				deleteFile(f.listFiles(), files, dirs); //재귀
				f.delete();
			}
			
			if(f.isFile()) {
				files.add(f.getName());
				f.delete();
			}
			
		}
		
	} //deleteFile
	
}
