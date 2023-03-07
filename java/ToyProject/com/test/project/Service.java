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

	@SuppressWarnings("resource")
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
		
		//이번 프로젝트할 때는 안 해도 됨.. 정상종료만 구현해도 된다.
		if(Data.list.size() % 5 == 0) {
			Data.save(); //1명씩 추가 > 데이터를 파일에 저장
		}
		
	} //add
	
	@SuppressWarnings("resource")
	public static void delete() {
		
		//특정 회원 > 원하는 1명
		UI.subMenu("삭제하기");
		
		//업무 구현
		
		for(Member m : Data.list) {
			System.out.println(m);
		}
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("번호: ");
		
		String sel = scan.nextLine();
		
		for(Member m : Data.list) {
			
			if(m.getNo().equals(sel)) {
				Data.list.remove(m);
				break;
			}
			
		}
		
		UI.pause();
		
	}
	
}


