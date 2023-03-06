package com.test.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// member.txt의 입력과 출력 담당
public class Data {

	public final static String MEMBER = ".\\dat\\member.txt";
	
	public static ArrayList<Member> list;
	
	static {
		list = new ArrayList<Member>();
	}
	
	//★★★★★
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				//텍스트 1줄 > Member 객체 1개
				Member m = new Member(tmp[0], tmp[1], tmp[2], tmp[3]);
				
				list.add(m);
				
			}
			
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
