package com.test.question;

import java.util.Scanner;

public class Q048 {
    
    /*
    
    요구사항]최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
    
    - int 양수만 입력하시오.
    
     1. 변수 선언
     2. 입력 도구 생성
     3. 라벨 출력 + 숫자 입력 받기
     4. while 사용하여 각 자리의 숫자 분리하기
     5. if문 사용하여 홀수 , 짝수 나누어 누적하기
     6. 결과 출력하기
    
     */
    
    public static void main(String[] args) {

	int num = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("숫자 입력: ");
	num = scan.nextInt();
	
	if(num > 999999999) {
	    System.out.println("최대 9자리 숫자를 입력해 주세요.\n");
	    System.out.print("숫자 입력: ");
	    num = scan.nextInt();
	    
	}
	
	printSum(num);
	
	
    } //main

    private static void printSum(int num) {
	
	int even = 0;
	int odd = 0;
	int cipher = 0;
	
	
	while (num > 0) {
	    
	    cipher = num % 10;
	    
            if ( (cipher) % 2 == 0) {
        	even += cipher;
        	
            } else {
        	odd += cipher;
            }
            num /= 10;
        }
	
	System.out.printf("짝수의 합: %d\n", even);
	System.out.printf("홀수의 합: %d\n", odd);
	
	
	
    }
    
    

}
