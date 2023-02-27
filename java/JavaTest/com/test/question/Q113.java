package com.test.question;

import java.io.File;

public class Q113 {

	public static void main(String[] args) {
		
		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\음악 파일";
		
		File file = new File(path);
		
		File[] files = file.listFiles();
		
		for(int i = 0; i < 100; i++) {
			
			String path2 = String.format("C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\음악 파일"
											+ "\\[%03d]%s", i+1 , files[i].getName());
	
			File file2 = new File(path2);
			
			files[i].renameTo(file2);
			
		}

	} //main
	
}
