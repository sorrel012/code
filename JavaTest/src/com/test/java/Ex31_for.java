package com.test.java;

import java.util.Scanner;

public class Ex31_for {
    
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
//	m13();
//	m14();
//	m16();
//	m17();
	m19();
	
    } //main
        
    private static void m19() {
	
	//난수 생성기
	
	//1. Math.random()
	System.out.println(Math.random());
	System.out.println(Math.random() * 10);
	System.out.println((int)(Math.random() * 10));
	System.out.println((int)(Math.random() * 10) + 1);
	System.out.println();
	
	// 3~7 > 0~4 구한 후 +3
	System.out.println((int)(Math.random() * 5) + 3);
	
    }


    private static void m17() {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("아이디: ");
	String id = scan.nextLine();
	
	if(checkId(id)) {
	    System.out.println("올바른 아이디");
	} else {
	    System.out.println("올바르지 않은 아이디");
	}
	
	scan.close();
	
    } //m17

    private static boolean checkId(String id) {
	
	//유효성 검사
	
	for (int i = 0; i < id.length(); i++) {
	    
	    char c = id.charAt(i);
	    
	    if ( c < 'a' || c > 'z') {
		return false;
	    }
	    
	}
	
	return true;
	
    } //checkId

    private static void m16() {

	//유효성 검사
	
	//아이디 입력 > 영어 소문자로~ (문자 코드)
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("아이디: ");
	
	String id = scan.nextLine();
	
	for(int i = 0; i < id.length(); i++) {
	   
	    char c = id.charAt(i);
	    
//	    if ((int)c >= (int);a; && (int)c <= (int)'z') {
//		System.out.println("소문자 O");
//	    } else {
//		System.out.println("소문자 X");
//	    }
	    	    
	    if (c < 'a' || c > 'z') {
		System.out.println("아이디가 올바르지 않습니다. 영소문자로만 작성해 주세요.");
		break; //for문 탈출 > 잘못된 문자가 1개라도 발견되면, 나머지 문자는 유효성 검사를 할 필요가 없다.
	    }
	    
	}
	
	scan.close();
	
	
    } //m16

    private static void m14() {
	
	//숫자 전달 > 한글 반환
	String result = getNum(1);
	System.out.println(result);
	
	String result2 = getText();
	System.out.println(result2);
	
    } //m14


    private static String getText() {
	
	String txt = "";
		
	
	/*
	
	//컴파일 시점과 런타임 시점
	
	- 컴파일: 소스를 기계어로 번역
		1. 파싱 > 구문 분석 > 문법 검사
		2. 번역 작업
	
	- 런타임: 기계어 실행
	 
	-> for문이 작동할지 안 할지를 컴파일러는 알지 못 함!
	 
	 */
	
	for (int i = 0; i < 3; i++) {
	    txt += i;
	    
	    return txt; //값 반환 + 메소드 종료(탈출)
	}
	
	return "";
	
    } //getText


    private static String getNum(int num) {
	
	if (num == 1 ) {
	    return "하나";
	}
	if (num == 2 ) {
	    return "둘";
	}
	if (num == 3 ) {
	    return "셋";
	}
	return "나머지 숫자";
	// return "";
	// return null;
	
    } //getNum


    private static void m13() {
	
	//학교 선생님 > 학생 상담(30명)
	
	for (int i = 0; i < 30; i++) {
	    
//	    if (i == 16) {
//		break;
//	    }
	    
	    if (i == 16 || i ==20) { //16번, 20번 결석
		continue;
	    }
	    
	    System.out.printf("%d번 학생을 상담합니다.\n", i+1);
	}
	
    } //m13


    private static void m12() {
	
	//continue
	
	for (int i = 1; i < 11; i++) {
	    
	    if(i == 5) {
		continue;
	    }
	    
	    System.out.println(i);
	    
	}
	
    } //m12


    private static void m11() {
	
	//요구사항] 사용자 숫자 원하는 만큼 입력 받아 합계 구하기
	
	Scanner scan = new Scanner(System.in);
	
	int sum = 0, count = 0;
	
	
	for(;;) {
	    
	    System.out.print("숫자(0 입력 시 종료): ");
	    int num = scan.nextInt();

	    sum += num;

	    if (num == 0) {
		break;
	    }
	    
	    sum += num;
	    count++;
	}
	
	System.out.printf("총 %d개의 숫자를 입력했고, 그 숫자들의 합은 %d입니다.\n", count, sum);
	
	scan.close();
	
    } //m11


    private static void m10() {
	
	//기본적으로 1~10까지 출력 루프 > 사용자 개입 > 루프 횟수 추가 지정
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("숫자: ");
	int num = scan.nextInt();
	
	for (int i = 1; i < 11; i++) {
	    
	    System.out.println(i);
	    
	    if (i == num) {
		break;
	    }
	    
	}
	
	scan.close();
	
    } //m10


    private static void m9() {
	
	//분기문
	
	//break
	
	System.out.println("시작");
	
	for (int i = 0; i < 10; i++) {
	    
	    if (i == 5) {
		break; //제어문 탈출
	    }
	    
	    System.out.println(i + 1);
	}
	
	System.out.println("종료");
	
    } //m9


    private static void m8() {
	
	//무한 루프, Infinite loop
	
//	for (int i = 0; i < 10; i--) {	//엄밀히 무한루프는x 21억 바퀴 정도 돌 것(int의 범위)
//	    System.out.println("안녕하세용");
//	}
	
	//무한 루프 일부러 만들기
	// > 회전수를 미리 예측하기 힘든 경우에 사용
//	for (;;) {
//	    System.out.println("무한 루프");
//	}
	
	for (int i = 1; ; i++) {
	    System.out.println(i);
	}
	
    } //m8


    private static void m7() {
	
	//구구단 출력 > 사용자가 단을 입력
	
	
	/*
	
	5 x 1 =   5
	5 x 2 =  10
	5 x 3 =  15
	    .
	    .
	    .
	5 x 8 =  40
	5 x 9 =  45
		
	*/
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("몇 단을 출력할까요? : ");
	int dan = scan.nextInt();
	
	for (int i = 1; i < 10; i++) {
	    System.out.printf("%d x %d = %2d\n", dan, i, i * dan);
	}
	
	scan.close();
	
    } //m7


    private static void m6() {
	
	//요구사항] 사용자로부터 숫자를 10개 입력 받아 총합을 구하시오.
	
	int sum = 0;
	
	Scanner scan = new Scanner(System.in);
	
	for(int i = 0; i < 10; i++) {
	    System.out.printf("숫자 %d: ", i + 1);
	    int num = scan.nextInt();
	    sum += num;
	}
	
	System.out.println(sum);
	
	scan.close();
	
    } //m6


    private static void m5() {
	
	//요구사항] 사용자로부터 숫자를 입력 받아 1부터 입력한 숫자까지의 총합을 구하시오.
	
	Scanner scan = new Scanner(System.in);

	System.out.print("원하는 숫자 입력: ");
	int num = scan.nextInt();
	
	int sum = 0;
	
	for(int i = 1 ; i < num + 1; i++) {
	    sum += i;
	}
	
	System.out.printf("1 ~ %d 의 합 = %d\n", num, sum);
	
	scan.close();
    }


    private static void m4() {
	
	//요구사항] 1~10까지의 합 구하기
	
	int sum = 0; //누적 변수
	
	for (int i = 0; i < 10; i++) {
	    sum += i + 1;
	}
	
	System.out.println(sum);
	
	/*
	
	sum = 0 + 1
	sum = 0 + 1 + 2
	sum = 0 + 1 + 2 + 3
	sum = 0 + 1 + 2 + 3 + 4
	        .
	        .
	        .
	        .
	sum = 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
	        	
	 */
	
    } //m4


    private static void m3() {
	
	//루프 변수
	
	//요구사항] 숫자 1~10까지 출력
	//추가사항] 숫자를 10000까지 늘려서 출력
	
	for(int i = 0; i < 10; i++) {
	    System.out.println(i + 1);
	}
	System.out.println();
	
	
	//초기식, 조건식, 증감식
	for (int i = 0; i < 100; i+=2) {
	    System.out.println(i + 1);
	}
	
	
    } //m3


    private static void m2() {
	
	//회전수
	
	for (int i = 1; i <= 5; i++) {
	    System.out.println("실행문 A");
	}
	System.out.println();
	
	for (int i = 3; i <= 7; i++) {
	    System.out.println("실행문 B");
	}
	System.out.println();
	
	for (int i = 10; i > 5; i--) {
	    System.out.println("실행문 C");
	}
	System.out.println();
	
	//★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	for (int i = 0; i < 5; i++) {
	    System.out.println("실행문 D");
	}
	System.out.println();
	
    } //m2


    private static void m1() {

	//요구사항] "안녕하세요" x 5번 출력

	for (int i = 1; i < 6; i++) {
	    hello();
	}

    } //m1
    
    private static void hello() {
	
	System.out.println("안녕하세요.");
	
    } //hello
    
}
