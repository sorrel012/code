package com.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex89_Lambda {

	public static void main(String[] args) {

		//람다식
		//1. 컬렉션(배열) 정렬
		//2. 스트림(Stream)
		
		
//		m1();
//		m2();
		m3();

	} //main

	private static void m3() {

		//다중 정렬
		ArrayList<User> list = new ArrayList<User>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\dat\\user.txt"));

			String line = null;

			while((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				User user = new User(
						temp[0],
						temp[1],
						Integer.parseInt(temp[2]),
						temp[3],
						temp[4],
						temp[5]);

				list.add(user);

			}

			reader.close();
			
			//정렬
			//1차 정렬. 나이가 많은 순서대로 정렬
			//2차 정렬. 성별 정렬(알파벳순) 정렬
			System.out.println("=== 나이가 많은 순서대로, 나이가 같다면 성별 순서대로 정렬 ===");
			list.sort((u1, u2) -> {
				
				if(u1.getAge() > u2.getAge()) {
					return -1;
				} else if (u1.getAge() < u2.getAge()) {
					return 1;
				} else {
					
					if(u1.getGender().compareTo(u2.getGender()) > 0) {
						return -1;
					} else if (u1.getGender().compareTo(u2.getGender()) < 0) {
						return 1;
					} else {
						
						if(u1.getCity().compareTo(u2.getCity()) > 0) {
							return 1;
						} else if (u1.getCity().compareTo(u2.getCity()) < 0) {
							return -1;
						} else {
							return 0;
						}
						
					}
					
				}
				
			});
						
			for(User user : list) {
				System.out.printf("%s. %s(%d) %s %s\n"
						 			, user.getNo()
						 			, user.getName()
						 			, user.getAge()
						 			, user.getGender()
						 			, user.getCity());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	} //m3

	private static void m2() {
		
		ArrayList<User> list = new ArrayList<User>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\dat\\user.txt"));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				User user = new User(
								temp[0],
								temp[1],
								Integer.parseInt(temp[2]),
								temp[3],
								temp[4],
								temp[5]);
				
				list.add(user);
				
			}
			
			reader.close();
			
			System.out.println();
			
			//나이 기준 오름차순 (어린 순서대로)
			list.sort((u1, u2) -> u1.getAge() - u2.getAge());

			System.out.println("나이 기준 오름차순 정렬 (어린 순서대로)");
			for(User user : list) {
				System.out.printf("%s. %s(%d세)\n", user.getNo(), user.getName(), user.getAge());
			}
			
			System.out.println();
			
			//이름 기준 오름차순 (가나다순)
			list.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
			
			System.out.println("이름 기준 오름차순 정렬 (가나다순)");
			for(User user : list) {
				System.out.printf("%s. %s(%d세)\n", user.getNo(), user.getName(), user.getAge());
			}
			
			System.out.println();
						
			//성별 기준 오름차순 (F -> M)
			list.sort((u1, u2) -> u1.getGender().compareTo(u2.getGender()));
			System.out.println("성별 기준 오름차순 (알파벳순)");
			for(User user : list) {
				System.out.printf("%s. %s(%s)\n", user.getNo(), user.getName(), user.getGender());
			}
			
			System.out.println();
			
			//지역순(사용자 정의)
			list.sort((u1, u2) -> {
				
				int a1 = 0; //u1의 지역
				int a2 = 0; //u2의 지역
				
				if(u1.getCity().equals("서울")) { a1 = 1;}
				else if(u1.getCity().equals("인천")) { a1 = 2; }
				else if(u1.getCity().equals("천안")) { a1 = 3; }
				else if(u1.getCity().equals("대전")) { a1 = 4; }
				else if(u1.getCity().equals("강릉")) { a1 = 5; }
				else if(u1.getCity().equals("광주")) { a1 = 6; }
				else if(u1.getCity().equals("부산")) { a1 = 7; }
				
				if(u2.getCity().equals("서울")) { a2 = 1;}
				else if(u2.getCity().equals("인천")) { a2 = 2; }
				else if(u2.getCity().equals("천안")) { a2 = 3; }
				else if(u2.getCity().equals("대전")) { a2 = 4; }
				else if(u2.getCity().equals("강릉")) { a2 = 5; }
				else if(u2.getCity().equals("광주")) { a2 = 6; }
				else if(u2.getCity().equals("부산")) { a2 = 7; }
				
				return a1 - a2;
				
			});
			System.out.println("서울 기준 거리 오름차순 (서울에서 가까운순)");
			for(User user : list) {
				System.out.printf("%s. %s(%s) %s\n", user.getNo(), user.getName(), user.getGender(), user.getCity());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		int jumin = 980228;
		System.out.println("주민등록번호: " + jumin);
		
		int jumin2 = 020225;
		System.out.println("주민등록번호: " + jumin2);
		
		int color = 0xFF;
		System.out.println(color);
		
	}
	
}

//★ 산술 연산을 하는 숫자		> 숫자형
//★ 산술 연산을 하지 않는 숫자	> 문자열

//1,홍길동.25,M,서울,010-1234-5678
class User {
	
	private String no;
	private String name;
	private int age;
	private String gender;
	private String city;
	private String tel;
	
	public User(String no, String name, int age, String gender, String city, String tel) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.tel = tel;
	}
	
	public String getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getCity() {
		return city;
	}

	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city + ", tel="
				+ tel + "]";
	}
	
}