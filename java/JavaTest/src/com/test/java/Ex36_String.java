package com.test.java;

import java.util.Arrays;
import java.util.Scanner;

public class Ex36_String {

    public static void main(String[] args) {

//	m1();
//	m2();
//	m3();
//	m4();
//	m5();
//	m6();
//	m7();
//	m8();
//	m9();
//	m10();
//	m11();
//	m12();
	m13();



    } //main

    private static void m13() {

	String s1 = "Hong";
	String s2 = "hong";

	System.out.println(s1.compareTo(s2));
	System.out.println(s1.compareToIgnoreCase(s2));

	System.out.println();

	String s3 = "홍길동";
	String s4 = "아무개";

	System.out.println(s3 + s4);
	System.out.println(s3.concat(s4));

	System.out.println();

	String s5 = "홍길동";
	char[] clist = s5.toCharArray();

	System.out.println(Arrays.toString(clist));

    } //m13

    private static void m12() {

	//문자열 분리

	String name = "홍길동,아무개,하하하";

	String[] list = name.split(",");

	for(int i = 0; i < list.length; i++) {
	    System.out.println(list[i]);
	}

	System.out.println();

	name = ",홍길동,,아무개,하하하,";

	list = name.split(",");

	for(int i = 0; i < list.length; i++) {
	    System.out.println(list[i] + ", " + list[i].length());
	}

    } //m12

    private static void m11() {

	//문자열 치환

	String txt = "안녕하세요. 홍길동입니다.";

	System.out.println(txt.replace("홍길동", "아무개"));
	System.out.println(txt);

	txt = txt.replace("홍길동", "아무개");
	System.out.println(txt);


	System.out.println();
	System.out.println();


	String content = "게시판에 글을 작성합니다. 바보야!!";
	String word = "바보";

	//금지어 안 보이게 처리 > Masking
	System.out.println(content.replace(word, "**"));

	//replace에서 ""(빈 문자열)로 바꾸기
	System.out.println(content.replace(word, ""));

    } //m11

    private static void m10() {

	//문자열 추출

	String txt = "가나다라마바사아자차카타파하";

	System.out.println(txt.substring(3, 7));
	System.out.println(txt.substring(5, 6)); // 문자열 "바"
	System.out.println(txt.charAt(5)); // 문자 '바'

	System.out.println();
	System.out.println();

	//정형화된 데이터
	String jumin = "980117-2134567";

	//몇년생?
	System.out.println(jumin.substring(0, 2));

	//몇월생?
	System.out.println(jumin.substring(2, 4));

	//몇일생?
	System.out.println(jumin.substring(4, 6));

	//성별?
	System.out.println(jumin.substring(7, 8));

	System.out.println();
	System.out.println();

	//파일 경로 > 파일명 추출
	String path = "C:\\OneDrive\\class\\code\\java\\JavaTest\\src\\com\\test\\java\\Ex36_String.java";

	int index = path.lastIndexOf("\\");

	String filename = path.substring(index + 1);
	System.out.println(filename);

	//Ex36_String.java

	//확장자 없는 파일명 추출

	index = filename.lastIndexOf(".");

	String filenameWithoutExtension = filename.substring(0, index);
	System.out.println(filenameWithoutExtension);


	//확장자 추출
	String extension = filename.substring(index);
	System.out.println(extension);

    } //m10

    private static void m9() {

	//패턴 검색

	String txt= "자바 개발자 과정";

	System.out.println(txt.startsWith("자바"));
	System.out.println(txt.startsWith("오라클"));

	System.out.println(txt.endsWith("과정"));
	System.out.println(txt.endsWith("교육"));
	System.out.println(txt.indexOf("과정") == txt.length()-2);

	System.out.println();
	System.out.println();

	//파일 조작
	String file = "Ex36_String.JAVA";

	//해당 파일의 확장자가 ".java"인지 확인
	if (file.toLowerCase().endsWith(".java")) {
	    System.out.println("O");

	} else {
	    System.out.println("X");
	}

    } //m9

    private static void m8() {

	//문자열 대소문자 변경

	String content = "오늘 수업은 String Method입니다.";

	System.out.println(content.toUpperCase());
	System.out.println(content.toLowerCase());

	System.out.println("Java".equals("java"));
	System.out.println("Java".toUpperCase().equals("java".toUpperCase()));
	System.out.println("Java".equalsIgnoreCase("java"));

    } //m8

    private static void m7() {

	//SNS, 게시판 > 금지어

	String content = "안녕하세요. 바보야!! 저는 자바를 배우는 학생입니다.";
	String word = "바보"; //금지어

	if(content.contains(word)) {
	    System.out.println("금지어 발견!");

	} else {
	    System.out.println("글쓰기 진행..");
	}

	if(content.indexOf(word) > -1) {
	    System.out.println("금지어 발견!");

	} else {
	    System.out.println("글쓰기 진행..");
	}

	System.out.println();
	System.out.println();

	content = "안녕하세요. 저는 자바를 배우는 바보입니다.";
	String[] words = { "바보", "멍청이", "메롱" };

	for (int i = 0; i < words.length; i++) {

	    if(content.indexOf(words[i]) > -1) {
		System.out.println("금지어 발견!");
		break;

	    }
	}

	System.out.println("완료");

	System.out.println();
	System.out.println();


	//주민등록번호 > "-"

	String jumin = "980117-1234567";

	if (jumin.indexOf("-") == 6) {
	    System.out.println("O");

	} else {
	    System.out.println("X");
	}

    } //m7

    private static void m6() {

	String txt = "안녕하세요. 홍길동입니다.";

	int index = -1;

	index = txt.indexOf("홍");
	System.out.println(index);

	index = txt.indexOf("홍길동"); //시작 문자의 위치값
	System.out.println(index);

	index = txt.indexOf("홍길순"); //모두 완전 일치해야 함.
	System.out.println(index);
	System.out.println();
	System.out.println();

	txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 네. 홍길동입니다.";

	index = 0;

	while(true) { //같은 문자 여러 개 있을 때 모두 검색하기★

	    index = txt.indexOf("홍길동", index);

	    if(index == -1) {
		break;
	    }

	    System.out.println(index);

	    index += 3;

	}

//	index = txt.indexOf("홍길동", 0);
//	System.out.println(index);
//
//	index = txt.indexOf("홍길동", 10);
//	System.out.println(index);
//
//	index = txt.indexOf("홍길동", 24);
//	System.out.println(index);


	System.out.println();
	System.out.println();


	System.out.println(txt.indexOf("홍길동")); //왼쪽 -> 오른쪽
	System.out.println(txt.lastIndexOf("홍길동")); //오른쪽 -> 왼쪽

    } //m6

    private static void m5() {

	//문자열 검색 contains

	String txt = "홍길동님 안녕하세요.";

	System.out.println(txt.contains("홍길동"));
	System.out.println(txt.contains("아무개"));

	System.out.println("950215-2012457".contains("-"));

    } //m5

    private static void m4() {

	//문자열 공백 제거

	String txt = "  하나    둘	셋	";

	System.out.printf("[%s]\n", txt);
	System.out.printf("[%s]\n", txt.trim());

	String s1 = "자바";
	String s2 = "  자바  ";

	System.out.println(s1.equals(s2));

    } //m4

    private static void m3() {

	//주민등록번호 or 전화번호
	// - 중간에 '-' 반드시 입력

	String jumin = "950215-1014789";

	if(validJumin(jumin)) {
	    System.out.println("올바른 주민등록번호입니다.");

	    //성별?
	    char c = jumin.charAt(7);

	    if (c =='1' || c =='3') {
		System.out.println("남자");

	    } else if ( c == '2' || c== '4') {
		System.out.println("여자");

	    }

	    //char인 숫자를 진짜 숫자로 바꾸기
	    // '1' > 1

	    if((c - 48) % 2 == 1) {
		System.out.println("남자");

	    } else {
		System.out.println("여자");
	    }

	} else {
	    System.out.println("올바르지 않은 주민등록번호입니다.");
	}

    } //m3

    private static boolean validJumin(String jumin) {

	if (jumin.charAt(6) == '-') {
	    return true;

	} else {
	    return false;
	}

    } //validJumin

    private static void m2() {

	//문자열 추출

	String txt = "안녕하세요. 홍길동님";

	char c = txt.charAt(3);

	System.out.println(c);

    } //m2

    private static void m1() {

	//문자열 길이 : int length()

	String name1 = "홍길동";

	System.out.println(name1.length());

	//요구사항] 이름 입력 > 몇 글자?

	Scanner scan = new Scanner(System.in);

	System.out.print("이름: ");
	String name = scan.nextLine();

	System.out.println(name.length());

	//유효성 검사(2~5자 이내
	if (name.length() >= 2 && name.length() <= 5) {
	    System.out.println("올바른 이름");

	} else {
	    System.out.println("이름은 2~5자 이내로 입력.");
	}

    } //m1

}
