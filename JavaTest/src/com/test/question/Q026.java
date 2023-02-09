package com.test.question;

import java.util.Scanner;

public class Q026 {

    /*
    
    요구사항]학생의 국어 점수를 입력받아 성적을 출력하시오.
    
    - 90 ~ 100: A
    - 80 ~  89: B
    - 70 ~  79: C
    - 60 ~  69: D
    -  0 ~   59: F
    - 유효성 검사를 하시오.(점수: 0 ~ 100점 이내)
    
    1. 입력 도구 생성
    2. 라벨 출력 + 점수 입력 받기
    3. 조건문: 점수 구간을 나누어 성적 출력
    	- if, else if, else 사용
    	 
     */
    
    public static void main(String[] args) {
	
	int score = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("점수: ");
	score = scan.nextInt();
	
	if (score < 0 || score > 100) {
	    System.out.println("점수가 올바르지 않습니다. 0~100 사이의 값을 입력하시오.");
	} else if (score > 89) {
	    System.out.printf("입력한 %d점은 성적 A입니다.", score);
	} else if (score > 79) {
	    System.out.printf("입력한 %d점은 성적 B입니다.", score);
	} else if (score > 69) {
	    System.out.printf("입력한 %d점은 성적 C입니다.", score);
	} else if(score > 59) {
	    System.out.printf("입력한 %d점은 성적 D입니다.", score);
	} else {
	    System.out.printf("입력한 %d점은 성적 F입니다.", score);
	}
	
	scan.close();

    } //main
    
}
