package com.test.question;

import java.util.Scanner;

public class Q031 {

    /*
    
    요청사항] 숫자 5개를 입력받아 짝수와 홀수의 개수를 출력하시오.
    
    - 입력: 숫자 입력: 3
    - 출력: 짝수는 2개 홀수는 3개 입력했습니다.
           홀수가 짝수보다 1개 더 많습니다.
    
    1. 입력 도구 생성
    2. for문으로 5번 반복
    	2-1. 라벨 출력 + 숫자 입력 받기
    	2-2. 조건문: 짝수 홀수 구분하여 변수++
    3. 최종 결과 출력
    
     */
    
    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	
	int 	num = 0,
		even = 0,
		odd = 0;
	
	for (int i = 0; i < 5; i++) {
	    System.out.print("숫자 입력: ");
	    num = scan.nextInt();
	    if (num % 2 == 0) {
		even += 1;
	    } else {
		odd += 1;
	    }
	}
	
	System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n",  even, odd);
	System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\n",  odd - even);
	
	scan.close();
	
    } //main
    
    
}