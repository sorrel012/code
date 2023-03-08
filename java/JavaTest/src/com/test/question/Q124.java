package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q124 {
	
	public static void main(String[] args) {

		try {
			
			BufferedReader readerMember = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\검색_회원.dat"));
			BufferedReader readerOrder = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\검색_주문.dat"));
			

			ArrayList<MemberOrder> orders = new ArrayList<MemberOrder>();
			String inputName = "";
			String line = null;
			String result = "주문 정보가 존재하지 않습니다.";

			while((line = readerMember.readLine()) != null) {

				MemberOrder m = new MemberOrder();

				String[] temp = line.split(",");

				m.setNum(temp[0]);
				m.setName(temp[1]);
				m.setAddress(temp[2]);

				orders.add(m);
			}
			
			while((line = readerOrder.readLine()) != null) {

				String[] temp = line.split(",");
				
				for(int i = 0; i < orders.size(); i++) {
					
					MemberOrder m = orders.get(i);
					
					if(m.getNum().equals(temp[3])) {
						m.setItem(temp[1]);
						m.setCount(temp[2]);
						break;
					}
				}
			}
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("이름: ");
			inputName = scan.nextLine();
			
			for(MemberOrder m : orders) {
				
				if(m.getName().equals(inputName)) {
					result = new StringBuilder("==== 구매내역 ====\n")
							.append("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]\n")
							.append(String.format("%s\t%s\t%s\t%s\t%s\t\n"
													, m.getNum()
													, m.getName()
													, m.getItem()
													, m.getCount()
													, m.getAddress()) ).toString();
					break;
				}
				
			}
			
			System.out.println(result);
			
			scan.close();
			readerMember.close();
			readerOrder.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main

}

class MemberOrder {
	
	private String num;
	private String name;
	private String item;
	private String count;
	private String address;
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
