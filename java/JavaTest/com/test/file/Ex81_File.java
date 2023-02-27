package com.test.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex81_File {

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
//		m9();
//		m10();
		m11();
		

	} //main

	private static void m11() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code2\\java\\JavaTest\\dat\\score.txt"));

			String line = null;

			while((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				int kor = Integer.parseInt(temp[1]);
				int eng = Integer.parseInt(temp[2]);
				int math = Integer.parseInt(temp[3]);
				int total = kor + eng + math;
				double avg = total / 3.0;

				System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n", temp[0], kor, eng, math, total, avg);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m10() {

		//더미 데이터 만들기
		String[] names = { "김", "이", "박", "최", "정", "현", "민", "유", "재", "신" };

		try {

			//. : 현재 프로그램이 있는 폴더
			//자바 콘솔 프로그램 > 현재 위치 : 프로젝트 폴더
			BufferedWriter writer
			= new BufferedWriter(new FileWriter("C:\\OneDrive\\class\\code2\\java\\JavaTest\\dat\\score.txt"));

			for (int i=0; i<30; i++) {

				String name = "";

				name = names[(int)(Math.random() * names.length)]
						+ names[(int)(Math.random() * names.length)]
								+ names[(int)(Math.random() * names.length)];

				int kor = (int)(Math.random() * 61) + 40; //60~100
				int eng = (int)(Math.random() * 61) + 40;
				int math = (int)(Math.random() * 61) + 40;

				writer.write(String.format("%s,%d,%d,%d\r\n"
						, name, kor, eng, math));

			}

			writer.close();

			System.out.println("더미 데이터 생성 완료!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m9() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\JavaTest\\com\\test\\file\\Ex81_File.java"));
			
			String line = null;
			int lineNum = 1;
			
			while ( (line = reader.readLine()) != null ) {
				
				System.out.printf("%03d: %s\n", lineNum, line);
				lineNum++;
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m8() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\class\\code\\java\\file\\data4.txt"));
						
			String line = null;
			
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m7() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\OneDrive\\class\\code\\java\\file\\data4.txt"));
			
			writer.write("안녕하세요.");
			writer.write("\r\n");
			writer.write("홍길동입니다.");
			writer.newLine(); // \r\n
			writer.write("반갑습니다.");
			
			writer.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m6() {

		//파일 읽기 > 파일 경로 입력 받기
		try {

			Scanner scan = new Scanner(System.in);
			
			System.out.print("파일 경로: ");
			String path = scan.nextLine();
			
			FileReader reader = new FileReader(path);

			int code = -1;
			while((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			reader.close();
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m5() {
		
		try {
			
			FileReader reader = new FileReader("C:\\OneDrive\\class\\code\\java\\file\\0227.txt");
			
			int code = -1;
            while((code = reader.read()) != -1) {
                System.out.print((char)code);
            }
            
            reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		
		//메모장 콘솔 버전 > 쓰기
		try {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("저장할 파일명: ");
			String fileName = scan.nextLine();
			
			//프로그램 사용자 환경
			//1. CLI > Command Line Interface > 콘솔창
			//2. GUI > Graphic User Interface > 현재 대부분 프로그램

			FileWriter writer = new FileWriter("C:\\OneDrive\\class\\code\\java\\file\\" + fileName + ".txt");
				
			while(true) {
				
				System.out.print("입력: ");
				String line = scan.nextLine();
				
				if(line.equals("exit")) { //그만두기
					break;
				}
				
				writer.write(line); //한 줄 입력 > 텍스트 파일 한 줄 쓰기
				writer.write("\r\n");
							
			}
			
			scan.close();
			writer.close();
			
			System.out.println("쓰기 종료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m3() {

		try {

			FileWriter writer = new FileWriter("C:\\OneDrive\\class\\code\\java\\file\\data3.txt");

			writer.write("ABC");
			writer.write("홍길동");

			writer.close();

			System.out.println("완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void m2() {

		File file = new File("C:\\OneDrive\\class\\code\\java\\file\\data.txt");

		try {

			if(file.exists()) {

				FileInputStream stream = new FileInputStream(file);

				int code = -1;

				while((code = stream.read()) != -1) {
					System.out.print((char)code);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
