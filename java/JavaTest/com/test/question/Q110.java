package com.test.question;

import java.io.File;
import java.util.Scanner;

public class Q110 {
	
	public static void main(String[] args) {

		String path = "";
		String filename = "";
		String fileExtension = "";
		String fileSize = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일 경로: ");
		path = scan.nextLine();
		
		File file = new File(path);
		
		filename = file.getName();
		fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
		fileSize = getSize(file.length());
		
		
		System.out.println("파일명: " + filename);
		System.out.println("종류 : " + fileExtension + " 파일");
		System.out.println("파일 크기: " + fileSize);
		
		scan.close();

	} //main

	private static String getSize(long length) {
		
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
		
		
	}
	
}
