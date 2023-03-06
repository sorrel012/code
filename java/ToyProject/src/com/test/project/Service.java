package com.test.project;

import java.util.Scanner;

public class Service {
	
	public static void list() {
		
		UI.subMenu("목록보기");
			
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		
		for (Member m : Data.list) {
			System.out.printf("%s\t%s\t%s\t%s\n"
								, m.getNo()
								, m.getName()
								, m.getAge()
								, m.getGender() );
		}
		
		UI.pause();
		
	} //list
	
	public static void add() {
		
		UI.subMenu("추가하기");
		
		//추가하기
		// - 사용자 > 회원정보 입력 > ArrayList<Member>에 추가
		
		Scanner scan = new Scanner(System.in);
		
		String no = Data.list.stream()
							.mapToInt(m -> Integer.parseInt(m.getNo()))
							.max().getAsInt()
							+ 1 +"";
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		String age = scan.nextLine();
		
		System.out.print("성별(남자/여자): ");
		String gender = scan.nextLine();

		Member m = new Member(no, name, age, gender);
		
		Data.list.add(m); //회원 추가하기
		
		UI.pause();
		
	} //add
	
}


