package com.test.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Ex80_File {

	private static int fileCount;
	private static int dirCount;
	private static int length;
	
	
	public static void main(String[] args) {

		//자바 프로그램
		
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
//		m11();
//		m12();
//		m13();
//		m14();
//		m16();
//		m17();
		m18();
		

	} //main

	private static void m18() {

		String path = "C:\\OneDrive\\class\\dev\\eclipse";
		File dir = new File(path);
		
		if(dir.exists()) {
			count(dir);
		}
		
		System.out.printf("총 파일 개수: %,d개\n", fileCount);
		System.out.printf("총 폴더 개수: %,d개\n", dirCount);
		System.out.printf("폴더 크기: %,dB개\n", length);
		System.out.printf("폴더 크기: %,dMB개\n", length/1024/1024);
		
	}
	
	private static void count(File dir) {
		
		//1. 목록 가져오기
		File[] list = dir.listFiles();
		
		//2. 파일 개수
		for(File file : list) {
			if(file.isFile()) {
				fileCount++;
				length += file.length();
			}
		}
		
		//3. 자식 폴더 > 방금 행동을 반복
		for(File subdir : list) {
			if(subdir.isDirectory()) {
				dirCount++;
				count(subdir);
			}
		}

	}

	private static void m17() {
		
		String path = "C:\\OneDrive\\class\\dev\\eclipse";
		File dir = new File(path);
		
		int count = 0;
		
		if(dir.exists()) {
			
		}
		
		File[] list = dir.listFiles();
		
		//자식 폴더 > 탐색 + 파일 개수
		for(File subdir : list) {
			if(subdir.isDirectory()) {
				
				//자식 폴더의 내용
				File[] sublist = subdir.listFiles();
				
				for(File subfile : sublist) {
					if(subfile.isFile()) {
						count++;
					}
				}
			}
		}
		
		System.out.printf("총 파일 개수: %,d개\n", count);
	}

	private static void m16() {
		
		//팩토리얼
		int n = 4;
		
		int result = m17(n);
		System.out.println(result);
		
		result = factorial(n);
		System.out.printf("%d! = %d\n", n, result);
		
	}

	private static int factorial(int n) {
		
		return (n == 1) ? 1 : n  * factorial(n-1);
		
	}

	private static int m17(int n) {
		
		System.out.println(n);
		
		int result = (n == 1) ? 1 : m17(n-1);
		
		return result;
		
	}

	private static void m14() {
		int n = 1;
		m15(n);
	}

	private static void m15(int n) {
		if( n  < 5 ) {
			m15(n);
			n++;
		} else {
			return;
		}
	}

	private static void m13() {
		
		// 메소드 사용+ 파일 디렉토리 조작
		
		//선언+호출
		test();
		
	}

	private static void test() {
		
		System.out.println("메소드 호출");
		
		test();
		
	}

	private static void m12() {
		
		//폴더 내용 보기
		String path = "C:\\OneDrive\\class\\dev\\eclipse";
		
		File dir = new File(path);
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			/*
			for(File file : list) {
				System.out.println(file.getName());
				System.out.println(file.isFile());
				System.out.println(file.isDirectory());
				System.out.println();
			}
			*/
			
			for(File file : list) {
				
				if(file.isDirectory()) {
					System.out.printf("[%s]\n", file.getName());
				}
				
				if(file.isFile()) {
					System.out.println(file.getName());
				}
				
			}
			
		}
		
	}

	private static void m11() {
		
		//폴더 조작
		// - 폴더 삭제
		
		File dir1 = new File("C:\\OneDrive\\class\\code\\java\\file\\\\member\\fff");
		
		if(dir1.exists()) {
			System.out.println(dir1.delete());
		}
		
	}

	private static void m10() {
		
		//폴더 조작
		// - 폴더명 수정 + 폴더 이동
		File dir1 = new File("C:\\OneDrive\\class\\code\\java\\file\\aaa");
		File dir2 = new File("C:\\OneDrive\\class\\code\\java\\file\\\\member\\fff");
		
		if(dir1.exists()) {
			System.out.println(dir1.renameTo(dir2));
		}
		
	}

	private static void m9() {
		
		//요구사항] 날짜별 폴더 생성
		// - "2023-01-01" ~ "2023-12-31" X 365 생성

		Calendar c1 = Calendar.getInstance();

		c1.set(2023, 0, 1);

		for (int i = 0; i < 365; i++ ) {

			String path = String.format("C:\\OneDrive\\class\\code\\java\\file\\plan\\%tF", c1);

			File dir = new File(path);

			dir.mkdir();

			c1.add(Calendar.DATE, 1);
		}

		System.out.println("종료");

	}

	private static void m8() {
		
		//요구사항] 회원 명단 > 개인 폴더 생성
		
		String[] member = { "홍길동", "아무개", "하하하", "호호호", "유재석", "강호동", "조세호", "이이경" };
		
		
		
		for (int i = 0; i < member.length; i++ ) {
			
			//회원 1명 > 1개 폴더 생성
			String path = String.format("C:\\OneDrive\\class\\code\\java\\file\\member\\[개인폴더]%s님", member[i]);
			
			File dir = new File(path);
			
			dir.mkdir();
			
		}
		
		System.out.println("종료");
		
	}

	private static void m7() {
		
		// 폴더 조작
		// - 새폴더 만들기

		String path = "C:\\OneDrive\\class\\code\\java\\aaa";
		File dir = new File(path);
		
		System.out.println(dir.mkdir());
		
		String path2 = "C:\\OneDrive\\class\\code\\java\\bbb\\ccc";
		File dir2 = new File(path2);
		 
		System.out.println(dir2.mkdirs());
		
	}

	private static void m6() {
		
		// 파일 조작
		// - 파일 삭제

		String path = "C:\\OneDrive\\class\\code\\java\\file\\test.txt";
		File file = new File(path);

		if(file.exists()) {
			System.out.println(file.delete());
		}
		
	}

	private static void m5() {

		// 파일 조작
		//- 파일 이동

		String path = "C:\\OneDrive\\class\\code\\java\\file\\수업.txt";
		File file = new File(path);
		

		String path2 = "C:\\OneDrive\\class\\code\\java\\move\\수업.txt";
		File file2 = new File(path2);
		
		if(file.exists()) {
			System.out.println(file.renameTo(file2));
		} else {
			
		}
		
	}

	private static void m4() {
		
		//파일 조작
		// - 파일명 수정
		
		//원본
		String path = "C:\\OneDrive\\class\\code\\java\\file\\수업.txt";
		File file = new File(path);
		
		//수정 후
		String path2 = "C:\\OneDrive\\class\\code\\java\\file\\class.txt";
		File file2 = new File(path2);
		
		if(file.exists()) {
			System.out.println(file.renameTo(file2));
		} else {
			
		}
		
		
	}

	private static void m3() {

		//파일 조작
		// - 파일 생성
		
		String path = "C:\\OneDrive\\class\\code\\java\\file\\수업.txt";
		
		File file = new File(path);
		
		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		//폴더
		String path = "C:\\OneDrive\\class\\code\\java\\file";
		
		//폴더 참조 객체(디렉토리는 파일의 일종이다.)
		File dir = new File(path);
		if (dir.exists()) {
			System.out.println("파일 있음");
			
			System.out.println(dir.getName());			//파일명
			
			System.out.println(dir.isFile());
			System.out.println(dir.isDirectory());
			
			System.out.println(dir.length()); 			//파일의 크기(byte)
			
			System.out.println(dir.getAbsolutePath());	//파일 경로
			
			System.out.println(dir.lastModified());	//최종 수정 시각(수정한 날짜)
			System.out.println(dir.isHidden());		//숨김 여부
			System.out.println(dir);
			
			//tick > Calendar
			Calendar c1 = Calendar.getInstance();
			
			System.out.println(c1.getTimeInMillis());
			
			c1.setTimeInMillis(dir.lastModified());
			
			System.out.printf("%tF %tT", c1, c1);
			
		} else {
			System.out.println("파일 없음");
		}
	}

	private static void m1() {
		
		//파일
		
		//파일 경로
		String path = "C:\\OneDrive\\class\\code\\java\\file\\test.txt";
		
		//파일 참조 객체 > java.io.File 클래스
		File file = new File(path);
		
		//해당 경로에 파일이 실제로 존재하는지 확인
//		System.out.println(file.exists());
		
		if (file.exists()) {
			System.out.println("파일 있음");
			
			System.out.println(file.getName());			//파일명
			
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
			
			System.out.println(file.length()); 			//파일의 크기(byte)
			
			System.out.println(file.getAbsolutePath());	//파일 경로
			
			System.out.println(file.lastModified());	//최종 수정 시각(수정한 날짜)
			System.out.println(file.isHidden());		//숨김 여부
			System.out.println(file.getParent());
			
			//tick > Calendar
			Calendar c1 = Calendar.getInstance();
			
			System.out.println(c1.getTimeInMillis());
			
			c1.setTimeInMillis(file.lastModified());
			
			System.out.printf("%tF %tT", c1, c1);
			
		} else {
			System.out.println("파일 없음");
		}
	}
	
}
