package com.test.question;

import java.io.File;
import java.util.Scanner;

public class Q112 {

	public static void main(String[] args) {

		String input = "";
		
		String path1 = "C:\\OneDrive\\class\\code\\java\\file\\AAA\\test.txt";
		String path2 = "C:\\\\OneDrive\\class\\code\\java\\file\\BBB\\test.txt";
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("파일 이동을 실행합니다.");
		
		if(!file2.exists()) {
			file1.renameTo(file2);
			System.out.println("파일을 이동하였습니다.");
			
		} else {
			System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n) ");
			input = scan.nextLine();
			
			if(input.equals("y")) {
				file2.delete();
				file1.renameTo(file2);
				System.out.println("y. 파일을 덮어썼습니다.");
				
			} else {
				System.out.println("n. 작업을 취소합니다.");
			}
			
		}
		
		scan.close();
				
	} //main
	
}
