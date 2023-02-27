package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Q122 {

	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\성적.dat"));
			
			ArrayList<StudentScore> scores = new ArrayList<StudentScore>();
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				StudentScore s = new StudentScore();
				
				String[] temp = line.split(",");
				
				s.setName(temp[0]);
				s.setPass(Integer.parseInt(temp[1])
						, Integer.parseInt(temp[2])
						, Integer.parseInt(temp[3]));
				
				scores.add(s);
			}
			
			System.out.println("[합격자]");
			for(StudentScore s : scores) {
				if(s.getPass()) {
					System.out.println(s.getName());
				}
			}
			
			System.out.println("\n[불합격자]");
			for(StudentScore s : scores) {
				if(!s.getPass()) {
					System.out.println(s.getName());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} //main
	
}

class StudentScore {
	
	private String name;
	private boolean pass = true;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getPass() {
		return this.pass;
	}
	
	public void setPass(int kor, int eng, int math) {
		int avg = (kor + eng + math) / 3;
		if(avg < 60 || kor < 40 || eng < 40 || math < 40) {
			this.pass = false;
		}
	}
	
}
