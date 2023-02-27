package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q120 {
	
	public static void main(String[] args) {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\이름수정.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\이름수정_변환.dat"));
			
			String line = null;
			
			while ( (line = reader.readLine()) != null ) {
				
				line = line.replace("유재석", "메뚜기");
					writer.write(line);
					writer.newLine();
				
			}
			
			reader.close();
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main

}
