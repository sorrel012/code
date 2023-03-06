package com.test.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data {

	public final static String MEMBER = "C:\\OneDrive\\class\\code\\java\\ToyProject\\src\\dat\\member.txt";
//
	
	public static ArrayList<Member> list;
	
	static {
		list = new ArrayList<Member>();
	}
	
	//★★★★
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				//텍스트 한 줄 > Member 객체 1개
				Member m = new Member(tmp[0], tmp[1], tmp[2], tmp[3]);
				
				list.add(m);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MEMBER));
			
			//Member m > 1,홍길동,20,남자
			for(Member m : list) {
				
				writer.write(String.format("%s,%s,%s,%s\r\n"
											, m.getNo()
											, m.getName()
											, m.getAge()
											, m.getGender()));
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
