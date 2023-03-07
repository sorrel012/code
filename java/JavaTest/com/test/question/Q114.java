package com.test.question;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Q114 {
	
	public static void main(String[] args) {

		HashMap<String, Integer> imageMap = new HashMap<String, Integer>();
		
		String filename = "";
		String fExtension = "";

		
		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\확장자별 카운트";
		
		File file = new File(path);
		File[] files = file.listFiles();
				
		for(File f : files) {

			filename = f.getName();
			fExtension = filename.substring(filename.lastIndexOf(".") + 1);
		
			if(!imageMap.containsKey(fExtension)) {
				imageMap.put(fExtension, 1);
				
			} else {
				imageMap.put(fExtension, imageMap.get(fExtension)+1);
			}
			
		}
				
		for(Map.Entry<String,Integer> e : imageMap.entrySet()) {
			System.out.printf("*.%s: %d개\n", e.getKey(), e.getValue());
		}

	} //main
	
}
