package com.test.question;

import java.io.File;
import java.util.ArrayList;

public class Q118 {

	public static void main(String[] args) {

		String path = "C:\\OneDrive\\쌍용\\과제\\110-113. 파일디렉토리조작\\디렉토리 문제 리소스\\크기 정렬";

		File file= new File(path);
		File[] flist = file.listFiles();
		
		ArrayList<File> fileList = new ArrayList<File>();

		searchFile(flist, fileList);
		sortDesc(fileList);
		
		System.out.printf("%25s\t%8s%15s\n", "[파일명]", "[크기]", "[파일이 들어있는 폴더]");
		
		for(File f : fileList) {
			
			System.out.printf("%30s\t%10s\t%5s\n", f.getName(), calSize(f.length()), f.getParentFile().getName());
			
		}
		
	} //main
	
	private static void searchFile(File[] flist, ArrayList<File> fileList) {

		for(File f : flist) {

			if(f.isFile()) {
				fileList.add(f);
			}
			
			if(f.isDirectory()) {
				searchFile(f.listFiles(), fileList); //재귀
			}

		}
		
	}
	
	private static void sortDesc(ArrayList<File> fileList) {
		
		
		for (int i = 0; i < fileList.size() - 1; i++) {
			for (int j = 0; j < fileList.size() - 1 - i; j++) {

				if (fileList.get(j).length() < (fileList.get(j+1).length())) {
					File tmp = fileList.get(j);
					fileList.set(j, fileList.get(j+1));
					fileList.set(j+1, tmp);

				}
			}
		}

	} //sortDesc

	private static String calSize(long length) {

		if(length < 1024 ) {
			return length + "B";

		} else if (length < 1024*1024) {
			return String.format("%.1f", length / 1024.0) + "KB";

		} else if (length < 1024*1024*1024) {
			return String.format("%.1f", length / 1024.0 / 1024.0) + "MB";

		} else if (length < 1024*1024*1024*1024) {
			return String.format("%.1f", length / 1024.0 / 1024.0 / 1024.0) + "GB";

		} else {
			return String.format("%.1f", length / 1024.0 / 1024.0 / 1024.0 / 1024.0) + "TB";
		}

	} //calSize
	
}