package com.test.project;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Data.load();
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			UI.mainMenu();
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			if(sel.equals("1")) {
				Service.list();
			} else if(sel.equals("2")) {
				Service.add();
			} else if(sel.equals("3")) {
				Service.delete();
			} else {
				loop = false;
			}
			
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		//배열 > member.txt
		Data.save();
		
		scan.close();

	} //main
	
}
