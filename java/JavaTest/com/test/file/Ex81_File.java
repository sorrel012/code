package com.test.file;

import java.io.File;
import java.io.FileOutputStream;

public class Ex81_File {

	public static void main(String[] args) {

		m1();

	} //main

	private static void m1() {
		
		//파일 쓰기(출력)
		// - 쓰기 스트림 객체
		
		try {

			//데이터를 저장할 파일을 참조
			File file = new File("C:\\OneDrive\\class\\code\\java\\file\\data2.txt");
			
			//저장할 파일의 스트림 객체 생성(스트림 열기)
			FileOutputStream stream = new FileOutputStream(file, true); // true를 붙이면 이어쓰기 모드
			
			//쓰기 > 문자코드값
//			stream.write(68);
//			stream.write(69);
//			stream.write(70);
			
//			stream.write('\r');
//			stream.write('\n');
//
//			stream.write('J');
//			stream.write('a');
//			stream.write('v');
//			stream.write('a');

//			stream.write('\r');
//			stream.write('\n');
//
//			String txt = "Hello Java!!";
//
//			for(int i = 0; i < txt.length(); i++) {
//
//				char c = txt.charAt(i);
//				stream.write(c);
//
//			}

//			stream.write('\n');
			
//			byte[] list = { 'A', 'B', 'C' };
//			stream.write(list);
			
			stream.write('\n');
			
			String txt = "Java Programming";
			
			stream.write(txt.getBytes());
			
			
			//스트림 닫기
			stream.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
