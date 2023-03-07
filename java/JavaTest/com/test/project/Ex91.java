package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex91 {
	
	public static void main(String[] args) {

		//프로젝트
		// - 파일 입출력 기반(데이터) + 자바 콘솔(응용) 프로젝트
		
		//컬렉션(배열) vs 파일입출력
		// - JavaTest > dat > "member.txt"
		
//		m1();
		System.out.println();
		System.out.println();
		m2();

	} //main

	private static void m2() {
		
		//파일 입출력
		
		//장점
		// - 영구 보관이 가능하다.
		
		//단점
		// - 입출력 속도가 느리다.(HDD)
		// - 기능이 적다.
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\dat\\member.txt")); //파일 경로 final static 상수로 만들어놓기
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
			System.out.println();
			
			//회원 검색
//			Scanner scan = new Scanner(System.in);
//
//			System.out.print("이름: ");
//			String input = scan.nextLine();
//
//
//			reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\dat\\member.txt")); //파일 경로 final static 상수로 만들어놓기
//
//			line = null;
//
//			while((line = reader.readLine()) != null) {
//
//				String[] temp = line.split(",");
//
//				if(temp[1].equals(input)) {
//					System.out.println(line);
//					break;
//				}
//
//			}
//
//			reader.close();
			
			
			//회원수
			System.out.println("[회원 인원 수]");
			
			reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\dat\\member.txt")); //파일 경로 final static 상수로 만들어놓기

			line = null;
			
			int count = 0;
			
			while((line = reader.readLine()) != null) {
				count++;
			}

			reader.close();
			
			System.out.println(count);

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//배열 or ArrayList
		ArrayList<Member> list = new ArrayList<Member>();
		
		//장점
		// - 입출력 속도가 빠르다.(메모리 입출력)
		// - API가 많다.(기능 풍부)
		
		//단점
		// - 영구 보관이 불가능하다.(프로그램이 끝나면 사라짐)
		
		Member m1 = new Member("1", "홍길동", "20", "남자");
		Member m2 = new Member("2", "아무개", "22", "남자");
		Member m3 = new Member("3", "호호호", "25", "여자");
		Member m4 = new Member("4", "테스트", "24", "남자");
		Member m5 = new Member("5", "하하하", "23", "남자");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		
//		System.out.println("[전체 목록]");
//
//		for(Member m : list) {
//			System.out.println(m);
//		}
//
		
		//회원 검색
//		Scanner scan = new Scanner(System.in);
//
//		System.out.print("이름: ");
//		String input = scan.nextLine();
//
//		for (Member m : list) {
//			if (m.getName().equals(input)) {
//				System.out.println(m);
//				break;
//			}
//		}
		
		//회원 수
		System.out.println(list.size());
		
	}

}

class Member {
	
	private String no;
	private String name;
	private String age;
	private String gender;
	
	public Member(String no, String name, String age, String gender) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}