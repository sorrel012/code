package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q123 {
	

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\단일검색.dat"));

			ArrayList<Member> members = new ArrayList<Member>();
			String inputName = "";
			String line = null;
			String result = "일치하는 회원 정보가 없습니다.";

			while((line = reader.readLine()) != null) {

				Member m = new Member();

				String[] temp = line.split(",");

				m.setNum(temp[0]);
				m.setName(temp[1]);
				m.setAddress(temp[2]);
				m.setPhone(temp[3]);

				members.add(m);
			}
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("이름: ");
			inputName = scan.nextLine();
			
			for(Member m : members) {
				
				if(m.getName().equals(inputName)) {
					result = new StringBuilder(String.format("[%s]\n", m.getName()))
								.append(String.format("번호: %s\n", m.getNum()))
								.append(String.format("주소: %s\n", m.getAddress()))
								.append(String.format("전화:%s\n", m.getPhone())).toString();
					break;
				}
				
			}
			
			System.out.println(result);
			
			scan.close();
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //main
	
}

class Member {
	
	private String name;
	private String num;
	private String address;
	private String phone;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
