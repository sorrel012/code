package com.test.question;

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

			FileReader reader = new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\숫자.dat");
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\숫자_변환.dat"));


			int code = -1;
			while((code = reader.read()) != -1) {
				
				char c = (char)code;
				
				if(c >= '0' && c <= '9') {
					writer.write(getNum(c));

				} else {
					writer.write(c);
				}
				
			}

			reader.close();
			writer.close();

			System.out.println("변환 후 다른 이름으로 저장하였습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main
	
	private static String getNum(char c) {
		
		switch(c) {
		case '1' :
		    return "일";
		case '2' :
		    return "이";
		case '3' :
		    return "삼";
		case '4' :
		    return "사";
		case '5' :
		    return "오";
		case '6' :
		    return "육";
		case '7' :
		    return "칠";
		case '8' :
		    return "팔";
		default:
		    return "구";
		}
		
	}
	
	
}
