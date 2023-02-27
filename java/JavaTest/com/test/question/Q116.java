package com.test.question;

import java.io.File;

public class Q116 {

	public static void main(String[] args) {

		String path1 = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\동일 파일\\MusicA";
		String path2 = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\동일 파일\\MusicB";
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		File[] files1 = file1.listFiles();
		File[] files2 = file2.listFiles();
		
		for(File f1 : files1) {
			
			String filename1 = f1.getName();
			
			for(File f2 : files2) {

				String filename2 = f2.getName();
				
				if(filename1.equals(filename2)) {
					System.out.println(filename1);
				}
				
			}
			
		}

	} //main
		
}
