package com.test.question;

import java.io.File;

public class Q119 {

	public static void main(String[] args) {
		
		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\직원";

		File file = new File(path);
		File[] files = file.listFiles();
		
		
		for(File f : files) {
			
			String name = getEmployeeName(f.getName());

			String newDir = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\직원\\" + name;
			File nameDir = new File(newDir);

			if(!nameDir.exists()) {
				nameDir.mkdir();
			}

			String year = getYear(f.getName());

			newDir += "\\" + year;
			File yearDir = new File(newDir);

			if(!yearDir.exists()) {
				yearDir.mkdir();
			}
			
			String renameFile = path + "\\" + name + "\\" + year + "\\" + getFilename(f.getPath());
			
			new File(path + "\\" + getFilename(f.getPath())).renameTo(new File(renameFile));
			
		}
		
		System.out.println("분류가 완료되었습니다.");
		
	} //main
	
	private static String getFilename(String path) {
		
		int index = path.lastIndexOf("\\");
		
		return path.substring(index + 1);
	}
	
	private static String getYear(String path) {
		
		int index1 = path.indexOf("_");
		int index2 = path.indexOf("_", index1 + 1);
		
		return path.substring(index1 + 1, index2);
	}

	private static String getEmployeeName(String path) {
		
		int index = path.indexOf("_");
		
		return path.substring(0, index);
	}
	
}
