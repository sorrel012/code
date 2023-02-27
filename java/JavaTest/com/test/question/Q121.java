package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
- try catch로 묶기
- close() 해주기
 */

public class Q121 {

	public static void main(String[] args) {

		try {

			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\숫자.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\숫자_변환.dat"));

			String line = null;
			
			while ( (line = reader.readLine()) != null ) {
				
				line = line.replace("0", "영")
						.replace("1", "일")
						.replace("2", "이")
						.replace("3", "삼")
						.replace("4", "사")
						.replace("5", "오")
						.replace("6", "육")
						.replace("7", "칠")
						.replace("8", "팔")
						.replace("9", "구");
				
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
