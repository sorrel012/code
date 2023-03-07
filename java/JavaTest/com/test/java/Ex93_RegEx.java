package com.test.java;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex93_RegEx {

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
		m7();
		
//		m8();
//		m9();
		
	

	} //main

	private static void m9() {
		
		//쇼트 서킷(short-circuit)
		int n = 10;
		
//		if (n > 0 && n < 100) {
//			System.out.println("O");
//		} else {
//			System.out.println("X");
//		}
		
		if (n > 0 || n < 100) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
	}

	private static void m8() {
		
		String txt = "홍길동";
		
		
//		String regex = "^[가-힣]{3}";	> 한글로 시작해야 됨
//		String regex = "[가-힣]{3}$"; 	> 한글로 끝나야 됨
		
		String regex = "^[가-힣]{3}$";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		System.out.println(m1.find());
		
	}

	private static void m7() {
		
		//회원가입 > 유효성 검사
		//1. 이름 	> 필수 입력, 한글, 2-5자 이내
		//2. 나이 	> 필수 입력, 숫자, 18세 이상
		//3. 아이디	> 필수 입력, 영어+숫자+_, 숫자로는 시작 불가능, 4-12이내
		
		System.out.println("[회원 가입]");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine().trim();
		
		System.out.print("나이: ");
		String age = scan.nextLine().trim();
		
		System.out.print("아이디: ");
		String id = scan.nextLine().trim();
		
		if(isValid(name, age, id)) {
			System.out.println("가입 완료");
		} else {
			System.out.println("가입 실패");
		}
		
		//날짜(2023-03-03) > "^[0-9]{4}-[0-9]{2}-[0-9]{2}$"
		//시간(14:30) > "^[0-9]{1}:[0-9]{2}$"
		
	}

	private static boolean isValid(String name, String age, String id) {
		
		String regex = "";		//정규식
		Pattern pattern = null;	//정규식 객체
		Matcher matcher = null;	//결과 객체

		//1. 이름 	> 필수 입력, 한글, 2-5자 이내
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name);  //입력 값을 대상으로 정규식 검사
		
		if(!matcher.find()) {
			//유효성 만족 xx
			System.out.println("이름 필수 입력, 한글 2-5자 이내로 입력하세요.");
			return false;
		}
		
		//2. 나이 	> 필수 입력, 숫자, 18세 이상
		regex = "^[0-9]{2,}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(age);
		
		if(!matcher.find() || (Integer.parseInt(age) < 18)) {
			//유효성 만족 xx
			System.out.println("나이 필수 입력, 18세 이상의 숫자를 입력하세요.");
			return false;
		}
		
		
		//3. 아이디	> 필수 입력, 영어+숫자+_, 숫자로는 시작 불가능, 4-12이내
		regex = "^[A-Za-z_][A-Za-z0-9]{3,11}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(id);
		
		if(!matcher.find()) {
			//유효성 만족 xx
			System.out.println("아이디 필수입력, 영어+숫자+_ 4-12자 이내로 입력하세요.(숫자로 시작 불가능)");
			return false;
		}
		
		
		
		return true;
	}

	private static void m6() {
		
		String txt = "안녕하세요. 저는 홍길동입니다. 네? 당신 이름도 길동이라구요? 아 ~ 김길동이군요. 마침 저쪽에도 최길동이 있습니다. 어? 남궁길동도 있네요.";
		
//		String regex = "[홍김최]?길동";
		String regex = "(홍|김|최|남궁)(길동)";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while(m1.find()) {
			System.out.println("찾은 이름: " + m1.group());
			System.out.println("성: " + m1.group(1));
			System.out.println("이름: " + m1.group(2));
			System.out.println();
		}
		
	}

	private static void m5() {
		
		//정규표현식 객체

		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 이 번호로 연락이 안 되면 010-5656-9876으로 연락주세요.";
		
		
		//txt 안에 전화번호가 포함되어 있는지 검사?
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//정규식 객체 생성
		Pattern p1 = Pattern.compile(regex);
		
		//p1이 자신의 정규식으로 txt를 검사한다.
		Matcher m1 = p1.matcher(txt);
		
//		if(m1.find()) {
//			System.out.println("전화번호 발견!");
//		} else {
//			System.out.println("전화번호가 없습니다.");
//		}
		
//		System.out.println(m1.find()); //010-1234-5678
//		System.out.println(m1.find()); //010-5656-9876
//		System.out.println(m1.find());
		
//		int count = 0;
//
//		while(m1.find()) {
//			count++;
//		}
//
//		System.out.println(count);
		
		while(m1.find()) {
			System.out.println("전화번호: " + m1.group());
			System.out.println("통신사: " + m1.group(1));
			System.out.println("가운데 자리: " + m1.group(2));
			System.out.println("끝자리: " + m1.group(3));
			System.out.println();
		}
		
	}

	private static void m4() {
		
		//split()
		String txt = "홍길동,아무개,,하하하;호호호 후후후";
		
		String[] list = txt.split("[,;\\s]+");
		
		for(String name:list) {
			System.out.println(name);
		}
		
	}

	private static void m3() {
		
		//자바의 정규표현식
		
		//게시판 > 개인정보 마스킹
		
		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 이 번호로 연락이 안 되면 010-5656-9876으로 연락주세요.";

		System.out.println(txt);
		System.out.println(txt.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "XXX-XXXX-XXXX"));
	}

	private static void m2() {
		
		String txt = "홍길동 아무개 하하하 호호호 후후후";
		
		//2. StringTokenizer > 이터레이터 방
		// - Token(토큰) : 공백을 기준으로 쪼개진 최소 단위
		
		StringTokenizer st = new StringTokenizer(txt);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		
		txt = "홍길동,아무개,하하하,호호호,후후후";

		st = new StringTokenizer(txt, ",");

		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		
		txt = "홍길동,아무개,하하하,호호호,후후후";

		st = new StringTokenizer(txt, ",", true);

		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		
		txt = "홍길동,아무개,하하하;호호호,후후후";

		st = new StringTokenizer(txt, ",;");

		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
	}

	private static void m1() {
		
		String txt = "홍길동,아무개,하하하,호호호,후후후";
		
		//1. split()
		String[] list = txt.split(",");
		
		for(String name : list) {
			System.out.println(name);
		}
		
	}
	
}
