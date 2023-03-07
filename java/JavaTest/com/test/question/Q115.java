package com.test.question;

import java.io.File;

public class Q115 {

	public static void main(String[] args) {
		
		int count = 0;

		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\파일 제거";
		
		File file = new File(path);
		File[] files = file.listFiles();
		
		for(File f : files) {
			
			if(f.length() == 0) {
				count++;
				f.delete();
			}
			
		}
		
		System.out.printf("총 %d개의 파일을 삭제했습니다.", count);

	} //main
	
}
