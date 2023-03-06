package com.test.project;

import java.util.Scanner;

//★★★★ 프로젝트의 모든 클래스 중 z() 메소드는 단 1개만 존재
public class Main {

	public static void main(String[] args) {

		Data.load();
		
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
			
			UI.mainMenu();
			
			System.out.print("선택: ");
			String sel = scan.nextLine();
			
			if(sel.equals("1")) {
				
			} else if(sel.equals("2")) {
				
			} else if(sel.equals("3")) {
				
			} else {
				loop = false;
			}
				
		} //while(menu)
		
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();

	} //main
	
}
