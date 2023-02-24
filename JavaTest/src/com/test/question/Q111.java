package com.test.question;

import java.io.File;
import java.util.Scanner;

public class Q111 {

	public static void main(String[] args) {

		String directory = "";
		String extention = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("폴더: ");
		directory = scan.nextLine();
		
		System.out.print("확장자: ");
		extention = scan.nextLine();
		
		File file = new File(directory);
		
		File[] list = file.listFiles();
		
		for(File f : list) {
			
			String filename = f.getName();
			String fExtension = filename.substring(filename.lastIndexOf(".") + 1);
			
			if(f.isFile() && fExtension.equals(extention)) {
				System.out.println(filename);
			}
			
		}

	} //main
	
}
