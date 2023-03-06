package com.test.project;

import java.util.Scanner;

public class UI {

	public static void mainMenu() {
		
		System.out.println("=============================");
		System.out.println("[회원 관리 프로그램]");
		System.out.println("1. 목록보기");
		System.out.println("2. 추가하기");
		System.out.println("3. 삭제하기");
		System.out.println("4. 종료");
		System.out.println("=============================");
		
	}
	
	public static void subMenu(String title) {
		
		System.out.println("---------------------------------");
		System.out.printf("<%s>\n", title);
		System.out.println("---------------------------------");
		
	}

	//메인 메뉴로 바로 돌아가지 못하게 잠시 멈춤
	public static void pause() {
		
		Scanner scan = new Scanner(System.in);
			
		System.out.println();
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		scan.nextLine();
	}
	
}
